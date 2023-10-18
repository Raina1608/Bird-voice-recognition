package com.example.mlseriesdemonstrator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class birdActivity extends MainActivity {

    private RecyclerView recyclerView;
    private List<Item> itemList;
    private ItemAdapter itemAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();

        itemList.add(new Item("Sparrow","House Sparrows aren’t related to other North American sparrows, and they’re differently shaped. House Sparrows are chunkier, fuller in the chest, with a larger, rounded head, shorter tail, and stouter bill than most American sparrows. For more info : https://www.allaboutbirds.org/guide/House_Sparrow/id#",R.drawable.sparrow));
        itemList.add(new Item("Crow","Not everyone realizes it, but there are two kinds of crows across much of the eastern United States. Looking almost identical to the ubiquitous American Crow, Fish Crows are tough to identify until you learn their nasal calls. Look for them around bodies of water, usually in flocks and sometimes with American Crows. They are supreme generalists, eating just about anything they can find. Fish Crows have expanded their range inland and northward along major river systems in recent decades. For more info:https://www.allaboutbirds.org/guide/Fish_Crow/ ",R.drawable.crow));
        itemList.add(new Item("White-breasted ","Very small, stub-tailed wren of humid tropical lowland forest. Favors forest understory, where usually found near or on the ground. Heard far more often than seen, and is notably elusive, even in fairly open understory. Common call is a metallic “peenk”; rather froglike and difficult to trace. Varied whistled songs rather short, usually introduced with a quiet whistled hiss. Note the boldly striped face, white bib, rich dark brown upperparts, and short tail. Gray-breasted Wood-Wren occurs in highlands. For more info: https://ebird.org/species/wbwwre1",R.drawable.white_breasted));
        itemList.add(new Item("Red Crossbill","A fascinating finch of coniferous woodlands, the Red Crossbill forages on nutritious seeds in pine, hemlock, Douglas-fir, and spruce cones. Their specialized bills allow them to break into unopened cones, giving them an advantage over other finch species. Because conifers produce seeds unpredictably, Red Crossbills sometimes wander (or “irrupt”) far beyond their usual range. They nest wherever and whenever they find abundant food, sometimes even in winter. Several types of Red Crossbill exist; they each have different calls, feed on particular conifer species, and might represent distinct species. For more info:https://www.allaboutbirds.org/guide/Red_Crossbill/ ",R.drawable.red));
        itemList.add(new Item("Chestnut-crowned Antpitta","A plump ball on sticks. Quite common and easily heard, but shy and rarely seen in the open. Striking plumage renders this species unmistakable in range: bright rufous head, white throat, and streaked underparts. Sexes alike. Found from subtropical zone up to the temperate zone in the Andes, within forest but also edges, thickets, second growth, and bamboo patches. Slightly less elusive than other antpittas; can sometimes be coaxed into the open by imitating its three-parted whistled song. For more info:https://ebird.org/species/chcant2 ",R.drawable.chestnut_crowned));
        itemList.add(new Item("Azara's Spinetail","Small, long-tailed bird that skulks in thickets and tangles. Mostly gray with rufous cap, wings, and tail. Sexes alike. More often heard than seen; listen for distinctive “whip-WEEP!” song repeatedly coming from dense scrubby areas. Found at fairly high elevations in the Andes, mostly from 1,500–3,000 m, higher than most other species of Synallaxis spinetails. For more info : https://ebird.org/species/azaspi1",R.drawable.azaraspinetail));
        itemList.add(new Item("Kingfisher","Beautiful little blue-and-orange bird with a long, pointed bill. Often rather shy and inconspicuous despite bright plumage. Found along rivers, streams, lakes, and ponds—almost any fresh or brackish habitat with small fish. Often perches quietly in trees over water; most often seen in very fast low flight as a turquoise flash over the water, usually flying away. Easily detected once its high, shrill whistled call is learned, even if the bird itself is hidden. The only small blue kingfisher over much of its range.For more info : https://ebird.org/species/comkin1?siteLanguage=en_IN",R.drawable.kingfisher));
        itemList.add(new Item("Hummingbird","A distinctive, fairly large hummingbird with a super long bill. Note the streaky throat and breast, and dull green upperparts with a coppery crown. The tail has a pale gray base, a broad black band, and white tips. Sexes similar, although female lacks toothlike serrations on bill (nearly impossible to see in the field). Found in lowlands and foothills from extreme eastern Panama to northwest Ecuador. Typically occurs within mature humid forest where it feeds in the lower to middle levels. For more info : https://ebird.org/species/tobhum1/",R.drawable.hummingbird));
        itemList.add(new Item("Fork-tailed Drongo-Cuckoo","Glossy small black cuckoo with a forked tail. Juvenile has a galaxy-like smattering of white spots all over the body. Square-tailed Drongo-Cuckoo has a less prominently-forked tail; note less difference in length of outermost tail feathers. Adults may be confused with drongos, but are lighter-billed and smaller, with distinctly white-barred undertail. Widespread, found in forests and scrubby plains from lowlands up into foothills and mountainous areas, but much more often heard than seen, typically sitting still in the middle and upper levels of forest; song is an extremely loud ascending series of whistles. Lays its eggs in the nests of babblers, bulbuls, and shrikes. For more info : https://ebird.org/species/asidrc2/",R.drawable.forkcuckoo));
        itemList.add(new Item("Grey-headed Canary-Flycatcher","An unmistakable, dainty woodland flycatcher with a slightly peaked head shape. It has a gray head and upper breast with a narrow white eyering. Upperparts are olive-green; breast and belly are bright yellow. An active member of mixed-species foraging flocks, but also seen singly or in pairs. Quite vocal, with a loud, squeaky whistled song delivered throughout the year: “wi-tu-wi-tu-wee!” or “wi-wuh-wuh-wee!!”. Frequently gives a rapid-fire series of high bouncy notes that rises quickly, then trails off. Other calls include sharp “chilup,” “kitwik,” or “chit” notes repeated a few times. For more info : https://ebird.org/species/gyhcaf1/",R.drawable.greycanary));
        itemList.add(new Item("Black-collared Lovebird","Short-tailed, mostly green miniature parrot. The back of the neck has a line of black above a line of color that varies geographically from yellow in the eastern part of the range to red in the center and orange in the east. Also note the blue rump and red patches on the sides of the tail. Found in lowland rainforest, including forest clearings and edge, and sometimes in secondary habitat. Often seen in small groups flying fast above the forest canopy. The call is a quick, high-pitched, silvery “siireee,” often given in flight. Structure and mostly green coloration similar to Red-headed Lovebird, but note the black collar and lack of red on the face. For more info : https://ebird.org/species/blclov2/",R.drawable.lovebird));
        itemList.add(new Item("King Rail","Large, bright rail of freshwater marshes. Generally uncommon to rare across range. Note rich orange neck and face, contrasty black-and-white barring on sides, and rich brownish upperparts with distinct dark streaks. Females are duller than males. Very similar to Clapper Rail, especially on the Gulf Coast. Habitat is a good first clue: King prefers freshwater marshes with extensive cattails or other reeds; rarely found in brackish or saltwater marshes like Clapper. King is also brighter overall with more contrasting pattern on the sides and upperparts. Beware that King and Clapper can hybridize where fresh and saltwater meet; some birds are best left unidentified. Listen for series of harsh key notes or loud, rasping grunts erupting from marsh, slower and deeper than Clapper Rail. For more info : https://ebird.org/species/kinrai4/",R.drawable.kingrail));
        itemList.add(new Item("Red-throated Loon","The smallest loon, with a slender neck and bill. Often holds the thin bill at an upward angle. In breeding plumage, note smooth gray head, brick-red throat, and dark back. In winter, dark cap and hind neck contrast with white face and throat. In flight, often lowers and raises head more than other loons; also note small feet. Juveniles can look quite dark with a smudgy gray neck and limited white throat.. For more info : https://ebird.org/species/retloo/",R.drawable.redloon));
        itemList.add(new Item("Mao","A large, entirely dark honeyeater. Plumage becomes paler from the shoulders back, turning blackish to yellowish-olive. Note the caramel-colored moustache stripe below the eye. Dependent on native primary forest in foothills and montane areas. Voice includes a sequence of rising nasal piping notes, vocal and loud. For more info : https://ebird.org/species/mao1/",R.drawable.mao));
        itemList.add(new Item("Northern Gannet","Large seabird of the Atlantic with long, pointed bill, wings, and tail. Adults bright white with cream-colored head and black wingtips. Takes several years to reach adult plumage; juveniles are all sooty-brown and slowly acquire more white as they mature. Nests in enormous colonies on cliffs in the North Atlantic. Spends most of its life at sea, although often fairly close to land, so they are often visible from shore or on whale watching boats. Dives torpedolike into the ocean for fish. Gathers in large feeding flocks, but sometimes solitary. For more info : https://ebird.org/species/norgan/",R.drawable.gannetnoeth));
        itemList.add(new Item("Indian Peafowl","An unmistakable, large ground bird. The unmistakable iridescent blue male spreads out its ornamental upper tail feathers when courting females. Females have a shorter tail, an iridescent green neck, and browner plumage. Found in forest, forest edge, and agricultural land. Often seen on paths or alertly feeding in the undergrowth. Can be fairly confiding especially when found close to human habitation. Its loud screaming “may-yow” calls are heard incessantly during the rainy season. For more info : https://ebird.org/species/compea/",R.drawable.peafowl));
        itemList.add(new Item("Scarlet Macaw","Spectacular, huge, and long-tailed parrot, wiped out from most areas by capture for the pet trade; attempts at reintroduction are taking place in some protected areas. Found very locally in lowland rainforest and adjacent semiopen areas with big trees; usually in pairs. Unmistakable, bright scarlet red overall with big yellow wing patches and mostly blue wings and rump. Calls are deep, throaty roars that carry long distances.For more info : https://ebird.org/species/scamac1/",R.drawable.macaw));
        itemList.add(new Item("Fiery-browed Myna","An unmistakable, long-tailed, conspicuous myna with a broad orange eyebrow, a pale eye, an ash-gray body, mossy green wings and tail, and a contrasting yellowish rump. Juvenile browner, with a narrower eyebrow and a dark eye. A montane species which frequents the canopy of forest and is usually encountered in pairs or small groups. Confined to Sulawesi. Frequently repeated call is a metallic, wet “wink” given singly or repeatedly For more info : https://ebird.org/species/fibmyn1/",R.drawable.myna));
        itemList.add(new Item("Palm Cockatoo","Distinctive dark cockatoo with truly massive bill. Inhabits rainforests and woodlands of New Guinea and northern Cape York Peninsula. Large patch of bare red skin on the cheeks and a long black crest distinctive. Use sticks to drum on trees during territorial displays. In flight, note all-black tail (Red-tailed Black-Cockatoo has bright red tail panels). Voice a sharp whistle or squeak, lacking the mournful, drawn-out wailing quality of Red-tailed Black-Cockatoo. For more info : https://ebird.org/species/palcoc1/",R.drawable.palmcockatoo));
        itemList.add(new Item("Little Raven","Australian crows and ravens are challenging to identify; concentrate on call, throat-hackles, behavior, and location. Calls usually fairly fast and lack the drawn-out wail typical of Australian Raven. Long throat hackles lend it a slightly bearded appearance. Often flicks wings when calling. Inhabits a broad area of southeastern Australia. The default crow/raven in Adelaide and Melbourne and forms very large flocks in high-elevation areas like the Australian Alps. For more info : https://ebird.org/species/litrav1/",R.drawable.raven));
        itemList.add(new Item("Swallow-winged Puffbird","Often seen perched on fences and power lines along roadsides in scrubby areas and forest edges. Also found close to sandy embankments where they nest in burrows. The body is mostly navy blue with a rusty belly, and a white vent, rump, and underwings. Makes sallying flights on long broad wings with wing “fingers” splayed. For more info : https://ebird.org/species/swwpuf1/",R.drawable.bluepuffbird));
        itemList.add(new Item("Greater Ground-Robin","A medium-sized, pittalike bird of sub-alpine forest floor. Brown head and upperparts extending to the sides of the chest, pale gray underparts, with whitish throat, center of the belly and sometimes some scalloping on the chest. Note the strong bill and long legs. Shy and difficult to see. Same general shape and habits as the Lesser Ground-Robin, but Greater occurs at higher elevations and is much larger. Much more often heard than seen. Very distinctive, short, whistled phrase sounding like ‘What do you think?’ with the last note upslurred. For more info : https://ebird.org/species/grgrob1/",R.drawable.robin));
        itemList.add(new Item("Common Swift","Medium-sized swift, dark overall with a white throat. Almost always seen in fast, direct flight, which, as the name suggests, is swift. Bigger and longer-winged than swallows, with strong stiff wingbeats. Lacks the white rump patches of similarly-sized Pacific Swift (and other fork-tailed swifts) and various needletails. Nests in cavities in cliffs and buildings. Ranges widely over any habitat in search of aerial insects, often over lakes and reservoirs where swallows congregate. Usually flies higher than swallows except when swooping low to drink by splashing briefly on water surface. Calls frequently, especially near the nest, giving a high-pitched wheezing scream. For more info : https://ebird.org/species/comswi/",R.drawable.common));

        itemAdapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(itemAdapter);



    }

    private void filterList(String text) {
        List<Item> filteredList = new ArrayList<>();
        for(Item item : itemList){
            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty())
        {
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else {
            itemAdapter.setFilteredList(filteredList);
        }
    }

    public void back(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}