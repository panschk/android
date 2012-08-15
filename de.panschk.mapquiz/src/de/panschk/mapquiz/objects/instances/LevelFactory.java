package de.panschk.mapquiz.objects.instances;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import de.panschk.mapquiz.R;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;

public class LevelFactory {
    
    public static final int LEVEL_EUROPE_COUNTRIES_EASY = 100;
    public static final int LEVEL_EUROPE_IMPORTANT_CITIES = 101;
    public static final int LEVEL_EUROPE_COUNTRIES_HARD = 102;
    public static final int LEVEL_EUROPE_COUNTRIES_ALL = 103;
    
    public static final int LEVEL_SOUTH_AFRICA_COUNTRIES = 200;
    public static final int LEVEL_NORTH_AFRICA_COUNTRIES = 210;
    public static final int LEVEL_EAST_AFRICA_COUNTRIES = 220;
    
    public static final int LEVEL_NEAR_EAST_COUNTRIES = 300;
    
    private Activity activity;
    
    
    
    public LevelFactory(Activity activity) {
        this.activity = activity;
        
    }
    
    public Level getLevel(int levelId) {
        switch (levelId) {
        case LEVEL_EUROPE_COUNTRIES_EASY:
            return getLevelEuropeCountriesEasy();
        case LEVEL_EUROPE_COUNTRIES_HARD:
            return getLevelEuropeCountriesHard();
        case LEVEL_EUROPE_COUNTRIES_ALL:
            return getLevelEuropeCountriesAll();
        case LEVEL_EUROPE_IMPORTANT_CITIES:
            return getLevelEuropeanCities();
        case LEVEL_SOUTH_AFRICA_COUNTRIES:
            return getSouthAfricaCountries();
        case LEVEL_NORTH_AFRICA_COUNTRIES:
            return getNorthAfricaCountries();
        case LEVEL_EAST_AFRICA_COUNTRIES:
            return getArabicSeaCountries();
        case LEVEL_NEAR_EAST_COUNTRIES:
            return getNearEastCountries();
        default:
            break;
        }
        
        return null;
        
    }

    private Level getNearEastCountries() {
        String name = "Near East / Caucasus";
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 233,  250, "Turkey"));
        entries.add(new Entry( 312,  391, "Syria"));
        entries.add(new Entry( 235,  434, "Lebanon"));
        entries.add(new Entry( 209,  537, "Israel"));
        entries.add(new Entry( 221,  494, "Palestinian Autonomous Areas (West Bank)"));
        entries.add(new Entry( 83,  573, "Egypt"));
        entries.add(new Entry( 252,  534, "Jordan"));
        entries.add(new Entry( 444,  460, "Iraq"));
        entries.add(new Entry( 704,  440, "Iran"));
        entries.add(new Entry( 452,  138, "Georgia"));
        entries.add(new Entry( 489,  206, "Armenia"));
        entries.add(new Entry( 563,  197, "Azerbaijan"));
        entries.add(new Entry( 565,  581, "Kuwait"));
        entries.add(new Entry( 362,  585, "Saudi Arabia"));
        entries.add(new Entry( 770,  221, "Turkmenistan"));
        
        
        Level level = new Level(name, entries, R.drawable.near_east, 800, 640);
        return level;
    }

    private Level getArabicSeaCountries() {
        String name = "Around the Arabian Sea (East Africa, West Asia)";
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 65,  162, "Egypt"));
        entries.add(new Entry( 67,  328, "Sudan"));
        entries.add(new Entry( 82,  480, "South Sudan"));
        entries.add(new Entry( 117,  573, "Uganda"));
        entries.add(new Entry( 191,  585, "Kenya"));
        entries.add(new Entry( 343,  513, "Somalia"));
        entries.add(new Entry( 219,  471, "Ethopia"));
        entries.add(new Entry( 201,  343, "Eritrea"));
        entries.add(new Entry( 265,  416, "Djibouti"));
        entries.add(new Entry( 348,  351, "Yemen"));
        entries.add(new Entry( 479,  287, "Oman"));
        entries.add(new Entry( 294,  203, "Saudi Arabia"));
        entries.add(new Entry( 443,  215, "United Arab Emirates"));
        entries.add(new Entry( 404,  185, "Qatar"));
        entries.add(new Entry( 392,  172, "Bahrain"));
        entries.add(new Entry( 453,  64, "Iran"));
        entries.add(new Entry( 647,  140, "Pakistan"));
        entries.add(new Entry( 766,  213, "India"));
        entries.add(new Entry( 348,  113, "Kuwait"));
        entries.add(new Entry( 617,  41, "Afghanistan"));
        entries.add(new Entry( 171,  83, "Jordan"));
        entries.add(new Entry( 285, 52, "Iraq"));
        
        
        Level level = new Level(name, entries, R.drawable.arabian_sea, 800, 640);
        return level;
    }

    private Level getNorthAfricaCountries() {
        String name = "North/West Africa";
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 427,  85, "Tunisia"));
        entries.add(new Entry( 330, 185, "Algeria"));
        entries.add(new Entry( 180, 115, "Marocco"));
        entries.add(new Entry( 550, 198, "Libya"));
        entries.add(new Entry( 730, 217, "Egypt"));
        entries.add(new Entry( 133,  330, "Mauretania"));
        entries.add(new Entry( 56,  403, "Senegal"));
        entries.add(new Entry( 38,  433, "Gambia"));
        entries.add(new Entry( 55,  462, "Guinea-Bissau"));
        entries.add(new Entry( 80,  484, "Guinea"));
        entries.add(new Entry( 103,  512, "Sierra Leone"));
        entries.add(new Entry( 136,  542, "Liberia"));
        entries.add(new Entry( 206,  547, "Côte d'Ivoire (Ivory Coast)"));
        entries.add(new Entry( 266,  540, "Ghana"));
        entries.add(new Entry( 304,  523, "Togo"));
        entries.add(new Entry( 319,  496, "Benin"));
        entries.add(new Entry( 396,  510, "Nigeria"));
        entries.add(new Entry( 465,  574, "Cameroon"));
        entries.add(new Entry( 438,  622, "Equatorial Guinea"));
        entries.add(new Entry( 718,  413, "Sudan"));
        entries.add(new Entry( 740,  540, "South Sudan"));
        entries.add(new Entry( 563,  400, "Chad"));
        entries.add(new Entry( 553,  214, "Libya"));
        entries.add(new Entry( 422,  362, "Niger"));
        entries.add(new Entry( 591,  540, "Central African Republic"));
        
        Level level = new Level(name, entries, R.drawable.north_africa, 800, 640);
        return level;
    }

    private Level getLevelEuropeanCities() {
        String name = getString(R.string.europe);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 714, 530, "Istanbul"));
        entries.add(new Entry( 793, 255, "Moscow"));
        entries.add(new Entry( 381, 355, "London"));
        entries.add(new Entry( 728, 187, "Saint Petersburg"));
        entries.add(new Entry( 536, 334, "Berlin"));
        entries.add(new Entry( 346, 541, "Madrid"));
        entries.add(new Entry( 735, 381, "Kiev"));
        entries.add(new Entry( 519, 508, "Rome"));
        entries.add(new Entry( 415, 401, "Paris"));
        entries.add(new Entry( 702, 312, "Minsk"));
        entries.add(new Entry( 496, 319, "Hamburg"));
        entries.add(new Entry( 604, 433, "Budapest"));
        entries.add(new Entry( 577, 416, "Vienna"));
        entries.add(new Entry( 622, 343, "Warsaw"));
        entries.add(new Entry( 408, 525, "Bucharest"));
        entries.add(new Entry( 675, 475, "Munich"));
        entries.add(new Entry( 491, 461, "Milan"));
        entries.add(new Entry( 551, 387, "Prague"));
        entries.add(new Entry( 661, 505, "Sofia"));
        entries.add(new Entry( 619, 478, "Belgrade"));
        
        Level level = new Level(name, entries, R.drawable.europe, 800, 640);
        return level;
    }

    private Level getSouthAfricaCountries() {
        String name = "Africa(south)";
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 502, 857, "South Africa"));
        entries.add(new Entry( 1017, 590, "Madagascar"));
        entries.add(new Entry( 617, 820, "Lesotho"));
        entries.add(new Entry( 689, 745, "Swasiland"));
        entries.add(new Entry( 772, 547, "Mozambique"));
        entries.add(new Entry( 657, 565, "Zimbabwe"));
        entries.add(new Entry( 524, 635, "Botswana"));
        entries.add(new Entry( 362, 645, "Namibia"));
        entries.add(new Entry( 375, 413, "Angola"));
        entries.add(new Entry( 750, 431, "Malawi"));
        entries.add(new Entry( 580, 454, "Zambia"));
        entries.add(new Entry( 509, 186, "D.R. of the Congo (Kinshasa)"));
        entries.add(new Entry( 745, 279, "Tanzania"));
        entries.add(new Entry( 339, 161, "Republic of the Congo (Brazzaville)"));
        entries.add(new Entry( 255, 144, "Gabon"));
        entries.add(new Entry( 660, 180, "Ruanda"));
        entries.add(new Entry( 655, 224, "Burundi"));
        entries.add(new Entry( 712, 112, "Uganda"));
        entries.add(new Entry( 871, 122, "Kenya"));
        entries.add(new Entry( 150, 134, "Sao Tome and Principe"));
        entries.add(new Entry( 992, 427, "Mayotte (France)"));
        entries.add(new Entry( 1219, 616, "Réunion (France)"));
        entries.add(new Entry( 952, 399, "Comores"));
        entries.add(new Entry( 1265, 597, "Mauritius"));
        
        Level level = new Level(name, entries, R.drawable.south_africa, 1301, 1008);
        return level;
    }
    

    private Level getLevelEuropeCountriesEasy() {
        String name = getString(R.string.europe);
        List<Entry> entries = europeCountryListEasy();        
        Level level = new Level(name, entries, R.drawable.europe, 800, 640);
        return level;
    }
    private Level getLevelEuropeCountriesHard() {
        String name = getString(R.string.europe);
        List<Entry> entries = europeCountryListHard();        
        Level level = new Level(name, entries, R.drawable.europe, 800, 640);
        return level;
    }
    
    private Level getLevelEuropeCountriesAll() {
        String name = getString(R.string.europe);
        List<Entry> entries = europeCountryListHard();
        entries.addAll(europeCountryListEasy());
        Level level = new Level(name, entries, R.drawable.europe, 800, 640);
        return level;
    }
    

    private List<Entry> europeCountryListEasy() {
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 410, 439, getString(R.string.france)));
        entries.add(new Entry( 497, 352, getString(R.string.germany)));
        entries.add(new Entry( 377, 345, getString(R.string.england)));
        entries.add(new Entry( 605, 339, getString(R.string.poland)));
        entries.add(new Entry( 352, 539, getString(R.string.spain)));
        entries.add(new Entry( 723, 390, getString(R.string.ukraine)));
        entries.add(new Entry( 745, 229, getString(R.string.russia)));
        entries.add(new Entry( 667, 454, getString(R.string.romania)));
        entries.add(new Entry( 450, 337, getString(R.string.the_netherlands)));
        entries.add(new Entry( 438, 367, getString(R.string.belgium)));
        entries.add(new Entry( 647, 566, getString(R.string.greece)));
        entries.add(new Entry( 550, 389, getString(R.string.czech_republic)));
        entries.add(new Entry( 605, 434, getString(R.string.hungary)));
        entries.add(new Entry( 290, 550, getString(R.string.portugal)));
        entries.add(new Entry( 523, 500, getString(R.string.italy)));
        entries.add(new Entry( 622, 480, getString(R.string.serbia)));
        entries.add(new Entry( 705, 322, getString(R.string.belarus)));        
        entries.add(new Entry( 747, 559, getString(R.string.turkey)));        
        return entries;
    }
    
    private List<Entry> europeCountryListHard() {
        List<Entry> entries = new ArrayList<Entry>();
        
        entries.add(new Entry( 312, 296, getString(R.string.north_ireland)));
        entries.add(new Entry( 493, 274, getString(R.string.denmark)));
        entries.add(new Entry( 485, 157, getString(R.string.norway)));
        entries.add(new Entry( 555, 424, getString(R.string.austria)));
        entries.add(new Entry( 677, 509, getString(R.string.bulgaria)));
        entries.add(new Entry( 560, 140, getString(R.string.sweden)));
        entries.add(new Entry( 682, 122, getString(R.string.finland)));
        entries.add(new Entry( 602, 404, getString(R.string.slowakia)));
        entries.add(new Entry( 554, 452, getString(R.string.slowenia)));
        entries.add(new Entry( 562, 474, getString(R.string.croatia)));
        entries.add(new Entry( 478, 439, getString(R.string.switzerland)));
        entries.add(new Entry( 345, 345, getString(R.string.wales)));
        entries.add(new Entry( 594, 480, getString(R.string.bosnia_and_herzegowina)));
        entries.add(new Entry( 607, 501, getString(R.string.montenegro)));
        entries.add(new Entry( 182, 69,  getString(R.string.island)));
        entries.add(new Entry( 612, 526, getString(R.string.albania)));
        entries.add(new Entry( 300, 327, getString(R.string.ireland)));
        entries.add(new Entry( 340, 257, getString(R.string.scotland)));
        entries.add(new Entry( 634, 521, getString(R.string.macedonia)));
        entries.add(new Entry( 627, 507, getString(R.string.kosovo)));
        entries.add(new Entry( 710, 429, getString(R.string.moldova)));
        entries.add(new Entry( 457, 389, getString(R.string.luxembourg)));
        entries.add(new Entry( 552, 607, getString(R.string.malta)));        
        entries.add(new Entry( 760, 621, getString(R.string.cyprus)));        
        entries.add(new Entry( 645, 284, getString(R.string.lithuania)));        
        entries.add(new Entry( 684, 253, getString(R.string.latvia)));        
        entries.add(new Entry( 680, 216, getString(R.string.estonia)));      
        return entries;
    }
    
    private String getString(int id) {
        return activity.getResources().getString(id);
    }

}
