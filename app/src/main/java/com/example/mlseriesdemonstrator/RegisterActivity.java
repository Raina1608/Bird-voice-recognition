package com.example.mlseriesdemonstrator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText email_reg;
    private EditText name_reg;
    private  EditText pass_reg;
    private Button register_btn;
    private TextView already;
    private TextView skip_register;

    String emailPattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email_reg = findViewById(R.id.email_reg);
        name_reg = findViewById(R.id.name_reg);
        pass_reg = findViewById( R.id.pass_reg);
        register_btn = findViewById(R.id.register_btn);
        already = findViewById(R.id.already);
        skip_register = findViewById(R.id.skip_register);

        mAuth= FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog = new ProgressDialog(this);

        checkCredentials();

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        skip_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void checkCredentials() {
        String username = name_reg.getText().toString();
        String email = email_reg.getText().toString();
        String password = pass_reg.getText().toString();

        if(username.isEmpty() || username.length()<7)
        {
            showError(name_reg,"Your username is not valid");
        }else if(email.isEmpty() || !email.matches(emailPattern))
        {
            showError(email_reg,"Email is not valid");
        }
        else if(password.isEmpty() || password.length()<7)
        {
            showError(pass_reg,"Password must be 7 characters");
        }
        else {
            progressDialog.setMessage("Registation...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegisterActivity.this, "Registration Success" + task.getException(), Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void showError(EditText input, String s) {

        input.setError(s);
        input.requestFocus();

    }


}