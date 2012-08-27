package de.panschk.mapquiz.objects.instances;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import de.panschk.mapquiz.R;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactoryBonus.LevelEnumBonus;

public class LevelFactory {
    
    public static enum LevelEnum {
        LEVEL_WORLD_BIGGEST_COUNTRIES, 
        LEVEL_WORLD_CONTINENTS_ISLANDS,
        LEVEL_WORLD_OCEANS,
        
        LEVEL_EUROPE_COUNTRIES_EASY ,
        LEVEL_EUROPE_COUNTRIES_HARD,
        LEVEL_EUROPE_IMPORTANT_CITIES,
        
        LEVEL_NEAR_EAST_COUNTRIES,
        LEVEL_NEAR_EAST_CITIES,
        LEVEL_ASIA_COUNTRIES,
        LEVEL_ASIA_CITIES,
        
        LEVEL_OCEANIA_COUNTRIES,
        LEVEL_OCEANIA_CITIES,
        
        LEVEL_SOUTH_AFRICA_COUNTRIES,
        LEVEL_SOUTH_AFRICA_CITIES,
        LEVEL_NORTH_AFRICA_COUNTRIES,
        LEVEL_NORTH_AFRICA_CITIES,
        LEVEL_EAST_AFRICA_COUNTRIES,
        LEVEL_EAST_AFRICA_CITIES,
        
        
        LEVEL_NORTH_AMERICA_COUNTRIES,
        LEVEL_NORTH_AMERICA_CITIES,
        
       
        LEVEL_SOUTH_AMERICA_COUNTRIES,
        LEVEL_SOUTH_AMERICA_CITIES,
        
        LEVEL_WORLD_BIGGEST_CITIES,
        
    }
   
    
    
    protected Activity activity;
    
    
    
    public LevelFactory(Activity activity) {
        this.activity = activity;
        
    }
    
    public Level getLevel(LevelEnum level) {
        int id = level.ordinal();
        switch (level) {
        case LEVEL_WORLD_CONTINENTS_ISLANDS:
            return getWorldContinentsIslands(id);
        case LEVEL_WORLD_BIGGEST_COUNTRIES:
            return getWorldCountries(id);
        case LEVEL_WORLD_OCEANS:
            return getWorldOceans(id);
        case LEVEL_EUROPE_COUNTRIES_EASY:
            return getLevelEuropeCountriesEasy(id);
        case LEVEL_EUROPE_COUNTRIES_HARD:
            return getLevelEuropeCountriesHard(id);
        case LEVEL_EUROPE_IMPORTANT_CITIES:
            return getLevelEuropeanCities(id);
        case LEVEL_SOUTH_AFRICA_COUNTRIES:
            return getSouthAfricaCountries(id);
        case LEVEL_SOUTH_AFRICA_CITIES:
            return getSouthAfricaCities(id);
        case LEVEL_NORTH_AFRICA_COUNTRIES:
            return getNorthAfricaCountries(id);
        case LEVEL_NORTH_AFRICA_CITIES:
            return getNorthAfricaCities(id);
        case LEVEL_EAST_AFRICA_COUNTRIES:
            return getArabicSeaCountries(id);
        case LEVEL_EAST_AFRICA_CITIES:
            return getArabianSeaCities(id);
        case LEVEL_NEAR_EAST_COUNTRIES:
            return getNearEastCountries(id);
        case LEVEL_NEAR_EAST_CITIES:
            return getNearEastCities(id);
        case LEVEL_ASIA_COUNTRIES:
            return getAsianCountries(id);
        case LEVEL_ASIA_CITIES:
            return getAsianCities(id);
        case LEVEL_OCEANIA_COUNTRIES:
            return getOceaniaCountries(id);
        case LEVEL_OCEANIA_CITIES:
            return getOceaniaCities(id);
        case LEVEL_NORTH_AMERICA_COUNTRIES:
            return getNorthAmericaCountries(id);
        case LEVEL_NORTH_AMERICA_CITIES:
            return getNorthAmericaCities(id);
        case LEVEL_SOUTH_AMERICA_COUNTRIES:
            return getSouthAmericaCountries(id);
        case LEVEL_SOUTH_AMERICA_CITIES:
            return getSouthAmericaCities(id);
        case LEVEL_WORLD_BIGGEST_CITIES:
            return getLevelWorldCities(id);
        default:
            break;
        }
        
        return null;
        
    }
    

    private Level getLevelWorldCities(int id) {
        String name = getString(R.string.biggest_cities_worldwide);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(816, 205, getString(R.string.beijing)));
        entries.add(new Entry(269, 320, getString(R.string.bogot)));
        entries.add(new Entry(319, 443, getString(R.string.buenos_aires)));
        entries.add(new Entry(566, 239, getString(R.string.cairo)));
        entries.add(new Entry(703, 257, getString(R.string.delhi)));
        entries.add(new Entry(735, 266, getString(R.string.dhaka)));
        entries.add(new Entry(808, 265, getString(R.string.guangzhou)));
        entries.add(new Entry(560, 207, getString(R.string.istanbul)));
        entries.add(new Entry(787, 349, getString(R.string.jakarta)));
        entries.add(new Entry(675, 257, getString(R.string.karachi)));
        entries.add(new Entry(523, 339, getString(R.string.kinshasa)));
        entries.add(new Entry(720, 274, getString(R.string.kolkata)));
        entries.add(new Entry(495, 316, getString(R.string.lagos)));
        entries.add(new Entry(259, 355, getString(R.string.lima)));
        entries.add(new Entry(479, 157, getString(R.string.london)));
        entries.add(new Entry(141, 228, getString(R.string.los_angeles)));
        entries.add(new Entry(826, 288, getString(R.string.manila)));
        entries.add(new Entry(199, 275, getString(R.string.mexico_city)));
        entries.add(new Entry(582, 138, getString(R.string.moscow)));
        entries.add(new Entry(688, 280, getString(R.string.mumbai)));
        entries.add(new Entry(269, 208, getString(R.string.new_york_city)));
        entries.add(new Entry(864, 230, getString(R.string.osaka)));
        entries.add(new Entry(359, 398, getString(R.string.rio_de_janeiro)));
        entries.add(new Entry(344, 406, getString(R.string.so_paulo)));
        entries.add(new Entry(844, 220, getString(R.string.seoul)));
        entries.add(new Entry(826, 245, getString(R.string.shanghai)));
        entries.add(new Entry(623, 226, getString(R.string.tehran)));
        entries.add(new Entry(878, 223, getString(R.string.tokyo)));

        Level level = new Level(id, name, entries, R.drawable.world2, R.drawable.thumb_world2, 1022, 616);
        return level;
    }

    private Level getNorthAmericaCities(int id) {
        String name = activity.getString(R.string.cities_in_north_central_america);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 307,  486, getString(R.string.mexico_city)));
        entries.add(new Entry( 579,  222, getString(R.string.new_york_city)));
        entries.add(new Entry( 79,  304, getString(R.string.los_angeles)));
        entries.add(new Entry( 429,  182, getString(R.string.chicago)));
        entries.add(new Entry( 531,  155, getString(R.string.toronto)));
        entries.add(new Entry( 555,  263, getString(R.string.washington)));
        entries.add(new Entry( 565,  129, getString(R.string.ottawa)));
        entries.add(new Entry( 641,  512, getString(R.string.santo_domingo)));
        entries.add(new Entry( 496,  452, getString(R.string.havana)));
        entries.add(new Entry( 350,  369, getString(R.string.houston)));
        entries.add(new Entry( 606,  125, getString(R.string.montral)));
        entries.add(new Entry( 616,  506, getString(R.string.portauprince)));
        entries.add(new Entry( 565,  515, getString(R.string.kingston)));
        entries.add(new Entry( 404,  553, getString(R.string.guatemala_city)));
        entries.add(new Entry( 450,  561, getString(R.string.tegucigalpa)));
        entries.add(new Entry( 462,  584, getString(R.string.managua)));
        entries.add(new Entry( 427,  568, getString(R.string.san_salvador)));
        entries.add(new Entry( 533,  625, getString(R.string.panama_city)));
        entries.add(new Entry( 482,  610, getString(R.string.san_jose)));
        entries.add(new Entry( 431,  527, getString(R.string.belmopan)));
        entries.add(new Entry( 558,  430, getString(R.string.nassau)));

        Level level = new Level(id, name, entries, R.drawable.north_central_america, R.drawable.thumb_north_central_america, 800, 640);
        return level;
    }

    private Level getSouthAmericaCities(int id) {
        String name = getString(R.string.cities_in_south_america);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 396,  701, getString(R.string.buenos_aires)));
        entries.add(new Entry( 560,  519, getString(R.string.sao_paulo)));
        entries.add(new Entry( 140,  343, getString(R.string.lima)));
        entries.add(new Entry( 168,  110, getString(R.string.bogota)));
        entries.add(new Entry( 615,  501, getString(R.string.rio_de_janeiro)));
        entries.add(new Entry( 223,  680, getString(R.string.santiago)));
        entries.add(new Entry( 682,  334, getString(R.string.salvador_de_bahia)));
        entries.add(new Entry( 210,  14, getString(R.string.maracaibo)));
        entries.add(new Entry( 547,  404, getString(R.string.braslia)));
        entries.add(new Entry( 149,  78, getString(R.string.medellin)));
        entries.add(new Entry( 89,  205, getString(R.string.guayaquil)));
        entries.add(new Entry( 280,  27, getString(R.string.caracas)));
        entries.add(new Entry( 333,  430, getString(R.string.santa_cruz)));
        entries.add(new Entry( 111,  181, getString(R.string.quito)));
        entries.add(new Entry( 430,  698, getString(R.string.montevideo)));
        entries.add(new Entry( 398,  76, getString(R.string.georgetown)));
        entries.add(new Entry( 249,  409, getString(R.string.la_paz)));
        entries.add(new Entry( 412,  541, getString(R.string.asuncin)));
        
        Level level = new Level(id, name, entries, R.drawable.south_america, R.drawable.thumb_south_america, 800, 800);
        return level;
    }

    private Level getOceaniaCities(int id) {
        String name = getString(R.string.cities_in_oceaniasoutheast_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 584,  419, getString(R.string.sydney)));
        entries.add(new Entry( 535,  460, getString(R.string.melbourne)));
        entries.add(new Entry( 316,  406, getString(R.string.perth)));
        entries.add(new Entry( 762,  445, getString(R.string.auckland)));
        entries.add(new Entry( 552,  202, getString(R.string.port_moresby)));
        entries.add(new Entry( 770,  492, getString(R.string.wellington)));
        entries.add(new Entry( 251,  178, getString(R.string.jakarta)));
        entries.add(new Entry( 388,  197, getString(R.string.dili)));
        entries.add(new Entry( 211,  100, getString(R.string.kuala_lumpur)));
        entries.add(new Entry( 353,  3, getString(R.string.manila)));
        entries.add(new Entry( 226,  113, getString(R.string.singapore)));
        entries.add(new Entry( 37,  67, getString(R.string.sri_jayawardenapurakotte)));
        entries.add(new Entry( 291,  189, getString(R.string.surabaya)));

        Level level = new Level(id, name, entries, R.drawable.oceania, R.drawable.thumb_oceania, 800, 640);
        return level;
    }

    private Level getAsianCities(int id) {
        String name = getString(R.string.cities_in_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 770,  344, getString(R.string.shanghai)));
        entries.add(new Entry( 216,  495, getString(R.string.mumbai)));
        entries.add(new Entry( 147,  419, getString(R.string.karachi)));
        entries.add(new Entry( 258,  378, getString(R.string.delhi)));
        entries.add(new Entry( 410,  449, getString(R.string.dhaka)));
        entries.add(new Entry( 827,  256, getString(R.string.soeul)));
        entries.add(new Entry( 977,  282, getString(R.string.tokyo)));
        entries.add(new Entry( 720,  227, getString(R.string.beijing)));
        entries.add(new Entry( 235,  339, getString(R.string.lahore)));
        entries.add(new Entry( 218,  286, getString(R.string.islamabad)));
        entries.add(new Entry( 532,  562, getString(R.string.bangkok)));
        entries.add(new Entry( 267,  586, getString(R.string.bangalore)));
        entries.add(new Entry( 168,  299, getString(R.string.kabul)));
        entries.add(new Entry( 170,  205, getString(R.string.tashkent)));
        entries.add(new Entry( 170,  243, getString(R.string.dushanbe)));
        entries.add(new Entry( 236,  180, getString(R.string.bishkek)));
        entries.add(new Entry( 192,  35, getString(R.string.astana)));
        entries.add(new Entry( 587,  85, getString(R.string.ulaanbaatar)));
        entries.add(new Entry( 816,  232, getString(R.string.pyongyang)));
        entries.add(new Entry( 592,  468, getString(R.string.hanoi)));
        entries.add(new Entry( 769,  423, getString(R.string.taipei)));
        entries.add(new Entry( 355,  390, getString(R.string.kathmandu)));
        entries.add(new Entry( 476,  527, getString(R.string.rangoon)));
        entries.add(new Entry( 579,  587, getString(R.string.phnom_penh)));
        entries.add(new Entry( 550,  505, getString(R.string.vientiane)));
        
        Level level = new Level(id, name, entries, R.drawable.asia, R.drawable.thumb_asia, 1033, 650);
        return level;
    }

    private Level getNearEastCities(int id) {
        String name = getString(R.string.cities_in_region_near_eastcaucasus);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 41,  180, getString(R.string.istanbul)));
        entries.add(new Entry( 152,  214, getString(R.string.ankara)));
        entries.add(new Entry( 473,  450, getString(R.string.baghdad)));
        entries.add(new Entry( 218,  507, getString(R.string.jerusalem)));
        entries.add(new Entry( 226,  446, getString(R.string.beirut)));
        entries.add(new Entry( 242,  505, getString(R.string.amman)));
        entries.add(new Entry( 495,  152, getString(R.string.tbilisi)));
        entries.add(new Entry( 484,  215, getString(R.string.yerewan)));
        entries.add(new Entry( 633,  200, getString(R.string.baku)));
        entries.add(new Entry( 247,  460, getString(R.string.damascus)));
        entries.add(new Entry( 448,  350, getString(R.string.mosul)));
        entries.add(new Entry( 273,  350, getString(R.string.aleppo)));
        entries.add(new Entry( 576,  546, getString(R.string.al_basrah)));
        entries.add(new Entry( 575,  590, getString(R.string.kuwait)));
        entries.add(new Entry( 657,  357, getString(R.string.tehran)));

        
        Level level = new Level(id, name, entries, R.drawable.near_east, R.drawable.thumb_near_east, 800, 640);
        return level;
    }

    private Level getArabianSeaCities(int id) {
        String name = getString(R.string.cities_around_the_arabian_sea);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 416,  3, getString(R.string.tehran)));
        entries.add(new Entry( 289,  40, getString(R.string.baghdad)));
        entries.add(new Entry( 353,  121, getString(R.string.kuwait)));
        entries.add(new Entry( 319,  194, getString(R.string.riyadh)));
        entries.add(new Entry( 445,  204, getString(R.string.abu_dhabi)));
        entries.add(new Entry( 472,  183, getString(R.string.dubai)));
        entries.add(new Entry( 516,  219, getString(R.string.muscat)));
        entries.add(new Entry( 291,  362, getString(R.string.sanaa)));
        entries.add(new Entry( 208,  457, getString(R.string.addis_ababa)));
        entries.add(new Entry( 276,  417, getString(R.string.djibouti)));
        entries.add(new Entry( 212,  349, getString(R.string.asmera)));
        entries.add(new Entry( 102,  517, getString(R.string.juba)));
        entries.add(new Entry( 117,  352, getString(R.string.khartoum)));
        entries.add(new Entry( 650,  189, getString(R.string.karachi)));
        entries.add(new Entry( 615,  68, getString(R.string.kandahar)));
        entries.add(new Entry( 678,  9, getString(R.string.kabul)));
        entries.add(new Entry( 247,  260, getString(R.string.mecca)));
        entries.add(new Entry( 89,  101, getString(R.string.cairo)));
        entries.add(new Entry( 216,  201, getString(R.string.medina)));


        Level level = new Level(id, name, entries, R.drawable.arabian_sea, R.drawable.thumb_arabian_sea, 800, 640);
        return level;
    }

    private Level getNorthAfricaCities(int id) {
        String name = getString(R.string.cities_in_northern_africa);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 338,  542, getString(R.string.lagos)));
        entries.add(new Entry( 755,  151, getString(R.string.cairo)));
        entries.add(new Entry( 766,  405, getString(R.string.khartoum)));
        entries.add(new Entry( 732,  141, getString(R.string.alexandria)));
        entries.add(new Entry( 158,  103, getString(R.string.casablanca)));
        entries.add(new Entry( 225,  571, getString(R.string.abidjan)));
        entries.add(new Entry( 413,  453, getString(R.string.kano)));
        entries.add(new Entry( 337,  39, getString(R.string.algier)));
        entries.add(new Entry( 434,  29, getString(R.string.tunis)));
        entries.add(new Entry( 24,  419, getString(R.string.dakar)));
        entries.add(new Entry( 428,  581, getString(R.string.douala)));
        entries.add(new Entry( 456,  594, getString(R.string.yaound)));
        entries.add(new Entry( 385,  495, getString(R.string.abuja)));
        entries.add(new Entry( 179,  83, getString(R.string.rabat)));
        entries.add(new Entry( 129,  549, getString(R.string.monrovia)));
        entries.add(new Entry( 88,  514, getString(R.string.freetown)));
        entries.add(new Entry( 74,  499, getString(R.string.conakry)));
        entries.add(new Entry( 278,  561, getString(R.string.accra)));
        entries.add(new Entry( 313,  432, getString(R.string.niamey)));
        entries.add(new Entry( 521,  462, getString(R.string.ndjamena)));
        entries.add(new Entry( 156,  443, getString(R.string.bamako)));
        entries.add(new Entry( 486,  112, getString(R.string.tripoli)));

        
        Level level = new Level(id, name, entries, R.drawable.north_africa, R.drawable.thumb_north_africa, 800, 640);
        return level;
    }

    private Level getSouthAfricaCities(int id) {
        String name = getString(R.string.cities_in_southern_africa);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 336,  241, getString(R.string.kinshasa)));
        entries.add(new Entry( 298,  345, getString(R.string.luanda)));
        entries.add(new Entry( 627,  742, getString(R.string.johannesburg)));
        entries.add(new Entry( 412,  937, getString(R.string.cape_town)));
        entries.add(new Entry( 862,  306, getString(R.string.dar_es_salaam)));
        entries.add(new Entry( 1036,  560, getString(R.string.antananarivo)));
        entries.add(new Entry( 716,  725, getString(R.string.maputo)));
        entries.add(new Entry( 671,  547, getString(R.string.harare)));
        entries.add(new Entry( 615,  481, getString(R.string.lusaka)));
        entries.add(new Entry( 569,  708, getString(R.string.gabarone)));
        entries.add(new Entry( 375,  656, getString(R.string.windhoek)));
        entries.add(new Entry( 212,  114, getString(R.string.libreville)));
        entries.add(new Entry( 712,  137, getString(R.string.kampala)));
        entries.add(new Entry( 809,  173, getString(R.string.nairobi)));
        entries.add(new Entry( 659,  181, getString(R.string.kigali)));
        entries.add(new Entry( 647,  215, getString(R.string.bujumbura)));
        entries.add(new Entry( 327,  226, getString(R.string.brazzaville)));
        
        Level level = new Level(id, name, entries, R.drawable.south_africa, R.drawable.thumb_south_africa, 1301, 1008);
        return level;
    }

    private Level getWorldOceans(int id) {
        String name = getString(R.string.biggest_oceans_and_seas);
        List<Entry> entries = new ArrayList<Entry>();
     
        entries.add(new Entry( 93,  304, getString(R.string.pacific_ocean)));
        entries.add(new Entry( 374,  233, getString(R.string.atlantic_ocean)));
        entries.add(new Entry( 719,  396, getString(R.string.indian_ocean)));
        entries.add(new Entry( 502,  14, getString(R.string.arctic_ocean)));
        entries.add(new Entry( 808,  295, getString(R.string.south_china_sea)));
        entries.add(new Entry( 273,  288, getString(R.string.caribbean_sea)));
        entries.add(new Entry( 498,  210, getString(R.string.mediterranean_sea)));
        entries.add(new Entry( 10,  119, getString(R.string.bering_sea)));
        entries.add(new Entry( 902,  140, getString(R.string.sea_of_okhotsk)));
        entries.add(new Entry( 219,  258, getString(R.string.gulf_of_mexico)));
        entries.add(new Entry( 660, 285, getString(R.string.arabian_sea)));
        entries.add(new Entry( 912, 381, getString(R.string.coral_sea)));
        entries.add(new Entry( 869, 299, getString(R.string.philippine_sea)));
        
        
        
        Level level = new Level(id, name, entries, R.drawable.world, R.drawable.thumb_world, 1022, 616);
        return level;
    }
    
    private Level getWorldCountries(int id) {
        String name = getString(R.string.world_largest_countries);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 763,  65, getString(R.string.russia)));
        entries.add(new Entry( 194,  137, getString(R.string.canada)));
        entries.add(new Entry( 813,  174, getString(R.string.china)));
        entries.add(new Entry( 204,  207, getString(R.string.united_states_of_america)));
        entries.add(new Entry( 346,  366, getString(R.string.brasil)));
        entries.add(new Entry( 863,  403, getString(R.string.australia)));
        entries.add(new Entry( 704,  270, getString(R.string.india)));
        entries.add(new Entry( 297,  443, getString(R.string.argentina)));
        entries.add(new Entry( 668,  174, getString(R.string.kazakhstan)));
        entries.add(new Entry( 492,  235, getString(R.string.algeria)));
        entries.add(new Entry( 545,  335, getString(R.string.dr_of_the_congo_kinshasa)));
        entries.add(new Entry( 366,  39, getString(R.string.greenland)));
        entries.add(new Entry( 612,  265, getString(R.string.saudi_arabia)));
        entries.add(new Entry( 197,  274, getString(R.string.mexico)));
        entries.add(new Entry( 797,  351, getString(R.string.indonesia)));

        
        Level level = new Level(id, name, entries, R.drawable.world, R.drawable.thumb_world, 1022, 616);
        return level;

    }

    private Level getWorldContinentsIslands(int id) {
        String name = getString(R.string.continents_and_biggest_islands);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 199,  178, getString(R.string.north_america)));
        entries.add(new Entry( 320,  378, getString(R.string.south_america)));
        entries.add(new Entry( 535,  288, getString(R.string.africa)));
        entries.add(new Entry( 505,  171, getString(R.string.europe)));
        entries.add(new Entry( 739,  120, getString(R.string.asia)));
        entries.add(new Entry( 867,  410, getString(R.string.australia)));
        entries.add(new Entry( 770,  597, getString(R.string.antartica)));
        entries.add(new Entry( 356,  51, getString(R.string.greenland)));
        entries.add(new Entry( 886,  345, getString(R.string.new_guinea)));
        entries.add(new Entry( 805,  328, getString(R.string.borneo)));
        entries.add(new Entry( 617,  386, getString(R.string.madagascar)));
        entries.add(new Entry( 276,  50, getString(R.string.baffin_island)));
        entries.add(new Entry( 774,  338, getString(R.string.sumatra)));
        
        Level level = new Level(id, name, entries, R.drawable.world, R.drawable.thumb_world, 1022, 616);
        return level;

    }

    private Level getSouthAmericaCountries(int id) {
        String name = getString(R.string.south_america);
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry( 356,  25, getString(R.string.trinidad_and_tobago)));
        entries.add(new Entry( 295,  64, getString(R.string.venezuela)));
        entries.add(new Entry( 182,  121, getString(R.string.colombia)));
        entries.add(new Entry( 105,  196, getString(R.string.ecuador)));
        entries.add(new Entry( 146,  286, getString(R.string.peru)));
        entries.add(new Entry( 389,  93, getString(R.string.guyana)));
        entries.add(new Entry( 437,  119, getString(R.string.suriname)));
        entries.add(new Entry( 471,  117, getString(R.string.french_guiana_france)));
        entries.add(new Entry( 516,  334, getString(R.string.brasil)));
        entries.add(new Entry( 313,  598, getString(R.string.argentina)));
        entries.add(new Entry( 299,  412, getString(R.string.bolivia)));
        entries.add(new Entry( 402,  513, getString(R.string.paraguay)));
        entries.add(new Entry( 426,  653, getString(R.string.uruguay)));
        entries.add(new Entry( 242,  507, getString(R.string.chile)));
        Level level = new Level(id, name, entries, R.drawable.south_america, R.drawable.thumb_south_america, 800, 800);
        return level;
    }

    private Level getNorthAmericaCountries(int id) {
        String name = getString(R.string.northcentral_america);
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry( 543,  53, getString(R.string.canada)));
        entries.add(new Entry( 285,  220, getString(R.string.united_states_of_america)));
        entries.add(new Entry( 266,  454, getString(R.string.mexico)));
        entries.add(new Entry( 540,  463, getString(R.string.cuba)));
        entries.add(new Entry( 637,  501, getString(R.string.dominican_republic)));
        entries.add(new Entry( 687,  511, getString(R.string.purto_rico)));
        entries.add(new Entry( 616,  499, getString(R.string.haiti)));
        entries.add(new Entry( 517,  494, getString(R.string.cayman_islands)));
        entries.add(new Entry( 552,  434, getString(R.string.the_bahamas)));
        entries.add(new Entry( 561,  512, getString(R.string.jamaica)));
        entries.add(new Entry( 428,  525, getString(R.string.belize)));
        entries.add(new Entry( 407,  544, getString(R.string.guatemala)));
        entries.add(new Entry( 452,  554, getString(R.string.honduras)));
        entries.add(new Entry( 423,  565, getString(R.string.el_salvador)));
        entries.add(new Entry( 467,  579, getString(R.string.nicaragua)));
        entries.add(new Entry( 482,  613, getString(R.string.costa_rica)));
        entries.add(new Entry( 516,  627, getString(R.string.panama)));
        Level level = new Level(id, name, entries, R.drawable.north_central_america, R.drawable.thumb_north_central_america, 800, 640);
        return level;
    }

    private Level getOceaniaCountries(int id) {
        String name = getString(R.string.oceania);
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry( 44,  61, getString(R.string.sri_lanka)));
        entries.add(new Entry( 209,  94, getString(R.string.malaysia)));
        entries.add(new Entry( 370,  26, getString(R.string.philippines)));
        entries.add(new Entry( 226,  113, getString(R.string.singapore)));
        entries.add(new Entry( 298,  140, getString(R.string.indonesia)));
        entries.add(new Entry( 305,  87, getString(R.string.brunei)));
        entries.add(new Entry( 390,  196, getString(R.string.east_timor)));
        entries.add(new Entry( 537,  177, getString(R.string.papua_new_guinea)));
        entries.add(new Entry( 457,  344, getString(R.string.australia)));
        entries.add(new Entry( 749,  512, getString(R.string.new_zealand)));
        entries.add(new Entry( 643,  198, getString(R.string.solomon_islands)));
        entries.add(new Entry( 714,  262, getString(R.string.vanuatu)));
        entries.add(new Entry( 695,  307, getString(R.string.new_caledonia_france)));
        entries.add(new Entry( 789,  275, getString(R.string.fiji)));      
        Level level = new Level(id, name, entries, R.drawable.oceania, R.drawable.thumb_oceania, 800, 640);
        return level;
    }

    private Level getAsianCountries(int id) {
        String name = getString(R.string.centraleastern_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 566,  296, getString(R.string.china)));
        entries.add(new Entry( 554,  111, getString(R.string.mongolia)));
        entries.add(new Entry( 164,  86, getString(R.string.kazakhstan)));
        entries.add(new Entry( 111,  200, getString(R.string.uzbekistan)));
        entries.add(new Entry( 48,  231, getString(R.string.turkmenistan)));
        entries.add(new Entry( 235,  198, getString(R.string.kyrgystan)));
        entries.add(new Entry( 207,  238, getString(R.string.tajikistan)));
        entries.add(new Entry( 144,  303, getString(R.string.afghanistan)));
        entries.add(new Entry( 185,  356, getString(R.string.pakistan)));
        entries.add(new Entry( 280,  456, getString(R.string.india)));
        entries.add(new Entry( 301,  624, getString(R.string.sri_lanka)));
        entries.add(new Entry( 408,  444, getString(R.string.bangladesh)));
        entries.add(new Entry( 336,  381, getString(R.string.nepal)));
        entries.add(new Entry( 413,  391, getString(R.string.bhutan)));
        entries.add(new Entry( 482,  473, getString(R.string.myanmar_burma)));
        entries.add(new Entry( 554,  484, getString(R.string.laos)));
        entries.add(new Entry( 534,  540, getString(R.string.thailand)));
        entries.add(new Entry( 621,  570, getString(R.string.vietnam)));
        entries.add(new Entry( 576,  574, getString(R.string.cambodia)));
        entries.add(new Entry( 967,  282, getString(R.string.japan)));
        entries.add(new Entry( 759,  439, getString(R.string.taiwan)));
        entries.add(new Entry( 828,  222, getString(R.string.north_korea)));
        entries.add(new Entry( 843,  272, getString(R.string.south_korea)));
        
        Level level = new Level(id, name, entries, R.drawable.asia, R.drawable.thumb_asia, 1033, 650);
        return level;
    }

    private Level getNearEastCountries(int id) {
        String name = getString(R.string.near_east__caucasus);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 233,  250, getString(R.string.turkey)));
        entries.add(new Entry( 312,  391, getString(R.string.syria)));
        entries.add(new Entry( 235,  434, getString(R.string.lebanon)));
        entries.add(new Entry( 209,  537, getString(R.string.israel)));
        entries.add(new Entry( 221,  494, getString(R.string.palestinian_autonomous_areas_west_bank)));
        entries.add(new Entry( 83,  573, getString(R.string.egypt)));
        entries.add(new Entry( 252,  534, getString(R.string.jordan)));
        entries.add(new Entry( 444,  460, getString(R.string.iraq)));
        entries.add(new Entry( 704,  440, getString(R.string.iran)));
        entries.add(new Entry( 452,  138, getString(R.string.georgia)));
        entries.add(new Entry( 489,  206, getString(R.string.armenia)));
        entries.add(new Entry( 563,  197, getString(R.string.azerbaijan)));
        entries.add(new Entry( 565,  581, getString(R.string.kuwait)));
        entries.add(new Entry( 362,  585, getString(R.string.saudi_arabia)));
        entries.add(new Entry( 770,  221, getString(R.string.turkmenistan)));
        
        
        Level level = new Level(id, name, entries, R.drawable.near_east, R.drawable.thumb_near_east, 800, 640);
        return level;
    }

    private Level getArabicSeaCountries(int id) {
        String name = getString(R.string.around_the_arabian_sea_east_africa_west_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 65,  162, getString(R.string.egypt)));
        entries.add(new Entry( 67,  328, getString(R.string.sudan)));
        entries.add(new Entry( 82,  480, getString(R.string.south_sudan)));
        entries.add(new Entry( 117,  573, getString(R.string.uganda)));
        entries.add(new Entry( 191,  585, getString(R.string.kenya)));
        entries.add(new Entry( 343,  513, getString(R.string.somalia)));
        entries.add(new Entry( 219,  471, getString(R.string.ethopia)));
        entries.add(new Entry( 201,  343, getString(R.string.eritrea)));
        entries.add(new Entry( 265,  416, getString(R.string.djibouti)));
        entries.add(new Entry( 348,  351, getString(R.string.yemen)));
        entries.add(new Entry( 479,  287, getString(R.string.oman)));
        entries.add(new Entry( 294,  203, getString(R.string.saudi_arabia)));
        entries.add(new Entry( 443,  215, getString(R.string.united_arab_emirates)));
        entries.add(new Entry( 404,  185, getString(R.string.qatar)));
        entries.add(new Entry( 392,  172, getString(R.string.bahrain)));
        entries.add(new Entry( 453,  64, getString(R.string.iran)));
        entries.add(new Entry( 647,  140, getString(R.string.pakistan)));
        entries.add(new Entry( 766,  213, getString(R.string.india)));
        entries.add(new Entry( 348,  113, getString(R.string.kuwait)));
        entries.add(new Entry( 617,  41, getString(R.string.afghanistan)));
        entries.add(new Entry( 171,  83, getString(R.string.jordan)));
        entries.add(new Entry( 285, 52, getString(R.string.iraq)));
        
        
        Level level = new Level(id, name, entries, R.drawable.arabian_sea, R.drawable.thumb_arabian_sea, 800, 640);
        return level;
    }

    private Level getNorthAfricaCountries(int id) {
        String name = getString(R.string.northwest_africa);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 427,  85, getString(R.string.tunisia)));
        entries.add(new Entry( 330, 185, getString(R.string.algeria)));
        entries.add(new Entry( 180, 115, getString(R.string.marocco)));
        entries.add(new Entry( 550, 198, getString(R.string.libya)));
        entries.add(new Entry( 730, 217, getString(R.string.egypt)));
        entries.add(new Entry( 133,  330, getString(R.string.mauretania)));
        entries.add(new Entry( 56,  403, getString(R.string.senegal)));
        entries.add(new Entry( 38,  433, getString(R.string.gambia)));
        entries.add(new Entry( 55,  462, getString(R.string.guineabissau)));
        entries.add(new Entry( 80,  484, getString(R.string.guinea)));
        entries.add(new Entry( 103,  512, getString(R.string.sierra_leone)));
        entries.add(new Entry( 136,  542, getString(R.string.liberia)));
        entries.add(new Entry( 206,  547, getString(R.string.cte_divoire_ivory_coast)));
        entries.add(new Entry( 266,  540, getString(R.string.ghana)));
        entries.add(new Entry( 304,  523, getString(R.string.togo)));
        entries.add(new Entry( 319,  496, getString(R.string.benin)));
        entries.add(new Entry( 396,  510, getString(R.string.nigeria)));
        entries.add(new Entry( 465,  574, getString(R.string.cameroon)));
        entries.add(new Entry( 438,  622, getString(R.string.equatorial_guinea)));
        entries.add(new Entry( 718,  413, getString(R.string.sudan)));
        entries.add(new Entry( 740,  540, getString(R.string.south_sudan)));
        entries.add(new Entry( 563,  400, getString(R.string.chad)));
        entries.add(new Entry( 422,  362, getString(R.string.niger)));
        entries.add(new Entry( 591,  540, getString(R.string.central_african_republic)));
        entries.add(new Entry( 261,  449, getString(R.string.burkina_faso)));
        entries.add(new Entry( 255,  356, getString(R.string.mali)));

        
        Level level = new Level(id, name, entries, R.drawable.north_africa, R.drawable.thumb_north_africa, 800, 640);
        return level;
    }

    private Level getLevelEuropeanCities(int id) {
        String name = getString(R.string.europe_cities);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 714, 530, getString(R.string.istanbul)));
        entries.add(new Entry( 793, 255, getString(R.string.moscow)));
        entries.add(new Entry( 381, 355, getString(R.string.london)));
        entries.add(new Entry( 728, 187, getString(R.string.saint_petersburg)));
        entries.add(new Entry( 536, 334, getString(R.string.berlin)));
        entries.add(new Entry( 346, 541, getString(R.string.madrid)));
        entries.add(new Entry( 735, 381, getString(R.string.kiev)));
        entries.add(new Entry( 519, 508, getString(R.string.rome)));
        entries.add(new Entry( 415, 401, getString(R.string.paris)));
        entries.add(new Entry( 702, 312, getString(R.string.minsk)));
        entries.add(new Entry( 496, 319, getString(R.string.hamburg)));
        entries.add(new Entry( 604, 433, getString(R.string.budapest)));
        entries.add(new Entry( 577, 416, getString(R.string.vienna)));
        entries.add(new Entry( 622, 343, getString(R.string.warsaw)));
        entries.add(new Entry( 408, 525, getString(R.string.barcelona)));
        entries.add(new Entry( 682, 479, getString(R.string.bucharest)));
        entries.add(new Entry( 522, 411, getString(R.string.munich)));
        entries.add(new Entry( 491, 461, getString(R.string.milan)));
        entries.add(new Entry( 551, 387, getString(R.string.prague)));
        entries.add(new Entry( 661, 505, getString(R.string.sofia)));
        entries.add(new Entry( 619, 478, getString(R.string.belgrade)));
        
        Level level = new Level(id, name, entries, R.drawable.europe, R.drawable.thumb_europe, 800, 640);
        return level;
    }

    private Level getSouthAfricaCountries(int id) {
        String name = getString(R.string.africasouth);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 502, 857, getString(R.string.south_africa)));
        entries.add(new Entry( 1017, 590, getString(R.string.madagascar)));
        entries.add(new Entry( 617, 820, getString(R.string.lesotho)));
        entries.add(new Entry( 689, 745, getString(R.string.swasiland)));
        entries.add(new Entry( 772, 547, getString(R.string.mozambique)));
        entries.add(new Entry( 657, 565, getString(R.string.zimbabwe)));
        entries.add(new Entry( 524, 635, getString(R.string.botswana)));
        entries.add(new Entry( 362, 645, getString(R.string.namibia)));
        entries.add(new Entry( 375, 413, getString(R.string.angola)));
        entries.add(new Entry( 750, 431, getString(R.string.malawi)));
        entries.add(new Entry( 580, 454, getString(R.string.zambia)));
        entries.add(new Entry( 509, 186, getString(R.string.dr_of_the_congo_kinshasa)));
        entries.add(new Entry( 745, 279, getString(R.string.tanzania)));
        entries.add(new Entry( 339, 161, getString(R.string.republic_of_the_congo_brazzaville)));
        entries.add(new Entry( 255, 144, getString(R.string.gabon)));
        entries.add(new Entry( 660, 180, getString(R.string.ruanda)));
        entries.add(new Entry( 655, 224, getString(R.string.burundi)));
        entries.add(new Entry( 712, 112, getString(R.string.uganda)));
        entries.add(new Entry( 871, 122, getString(R.string.kenya)));
        entries.add(new Entry( 150, 134, getString(R.string.sao_tome_and_principe)));
        entries.add(new Entry( 992, 427, getString(R.string.mayotte_france)));
        entries.add(new Entry( 1219, 616, getString(R.string.runion_france)));
        entries.add(new Entry( 952, 399, getString(R.string.comores)));
        entries.add(new Entry( 1265, 597, getString(R.string.mauritius)));
        
        Level level = new Level(id, name, entries, R.drawable.south_africa, R.drawable.thumb_south_africa, 1301, 1008);
        return level;
    }
    

    private Level getLevelEuropeCountriesEasy(int id) {
        String name = getString(R.string.europe_countries1);
        List<Entry> entries = europeCountryListEasy();        
        Level level = new Level(id, name, entries, R.drawable.europe, R.drawable.thumb_europe, 800, 640);
        return level;
    }
    private Level getLevelEuropeCountriesHard(int id) {
        String name = getString(R.string.europe_countries2);
        List<Entry> entries = europeCountryListHard();        
        Level level = new Level(id, name, entries, R.drawable.europe,R.drawable.thumb_europe,  800, 640);
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
        
        entries.add(new Entry( 312, 296, getString(R.string.northern_ireland)));
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



    public Level getLevel(LevelEnumBonus levelEnumBonus) {
        return null;
    }

}
