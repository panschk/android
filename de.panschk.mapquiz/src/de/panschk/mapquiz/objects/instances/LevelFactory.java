package de.panschk.mapquiz.objects.instances;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import de.panschk.mapquiz.R;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;

public class LevelFactory {
    
    public static enum LevelEnum {
        LEVEL_WORLD_CONTINENTS_ISLANDS,
        LEVEL_WORLD_OCEANS,
        LEVEL_WORLD_BIGGEST_CITIES,
        
        LEVEL_EUROPE_COUNTRIES_EASY ,
        LEVEL_EUROPE_IMPORTANT_CITIES,
        LEVEL_EUROPE_COUNTRIES_HARD,
        LEVEL_EUROPE_COUNTRIES_ALL,
        
        LEVEL_SOUTH_AFRICA_COUNTRIES,
        LEVEL_SOUTH_AFRICA_CITIES,
        LEVEL_NORTH_AFRICA_COUNTRIES,
        LEVEL_NORTH_AFRICA_CITIES,
        LEVEL_EAST_AFRICA_COUNTRIES,
        LEVEL_EAST_AFRICA_CITIES,
        
        LEVEL_NEAR_EAST_COUNTRIES,
        LEVEL_NEAR_EAST_CITIES,
        LEVEL_ASIA_COUNTRIES,
        LEVEL_ASIA_CITIES,
        
        LEVEL_OCEANIA_COUNTRIES,
        LEVEL_OCEANIA_CITIES,
        
        
        LEVEL_NORTH_AMERICA_COUNTRIES,
        LEVEL_NORTH_AMERICA_CITIES,
        
       
        LEVEL_SOUTH_AMERICA_COUNTRIES,
        LEVEL_SOUTH_AMERICA_CITIES,
        
        LEVEL_WORLD_CONFLICT_REGIONS,
        LEVEL_WORLD_HOLIDAY_DESTINATIONS,
        
    }
   
    
    
    private Activity activity;
    
    
    
    public LevelFactory(Activity activity) {
        this.activity = activity;
        
    }
    
    public Level getLevel(LevelEnum level) {
        int id = level.ordinal();
        switch (level) {
        case LEVEL_WORLD_CONTINENTS_ISLANDS:
            return getWorldContinentsIslands(id);
        case LEVEL_WORLD_OCEANS:
            return getWorldOceans(id);
        case LEVEL_WORLD_BIGGEST_CITIES:
            return getWorldCities(id);
        case LEVEL_EUROPE_COUNTRIES_EASY:
            return getLevelEuropeCountriesEasy(id);
        case LEVEL_EUROPE_COUNTRIES_HARD:
            return getLevelEuropeCountriesHard(id);
        case LEVEL_EUROPE_COUNTRIES_ALL:
            return getLevelEuropeCountriesAll(id);
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
        default:
            break;
        }
        
        return null;
        
    }

    private Level getNorthAmericaCities(int id) {
        String name = activity.getString(R.string.cities_in_north_central_america);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 307,  486, getResources().getString(R.string.mexico_city)));
        entries.add(new Entry( 579,  222, getResources().getString(R.string.new_york_city)));
        entries.add(new Entry( 79,  304, getResources().getString(R.string.los_angeles)));
        entries.add(new Entry( 429,  182, getResources().getString(R.string.chicago)));
        entries.add(new Entry( 531,  155, getResources().getString(R.string.toronto)));
        entries.add(new Entry( 555,  263, getResources().getString(R.string.washington)));
        entries.add(new Entry( 565,  129, getResources().getString(R.string.ottawa)));
        entries.add(new Entry( 641,  512, getResources().getString(R.string.santo_domingo)));
        entries.add(new Entry( 496,  452, getResources().getString(R.string.havana)));
        entries.add(new Entry( 350,  369, getResources().getString(R.string.houston)));
        entries.add(new Entry( 606,  125, getResources().getString(R.string.montral)));
        entries.add(new Entry( 616,  506, getResources().getString(R.string.portauprince)));
        entries.add(new Entry( 565,  515, getResources().getString(R.string.kingston)));
        entries.add(new Entry( 404,  553, getResources().getString(R.string.guatemala_city)));
        entries.add(new Entry( 450,  561, getResources().getString(R.string.tegucigalpa)));
        entries.add(new Entry( 462,  584, getResources().getString(R.string.managua)));
        entries.add(new Entry( 427,  568, getResources().getString(R.string.san_salvador)));
        entries.add(new Entry( 533,  625, getResources().getString(R.string.panama_city)));
        entries.add(new Entry( 482,  610, getResources().getString(R.string.san_jose)));
        entries.add(new Entry( 431,  527, getResources().getString(R.string.belmopan)));
        entries.add(new Entry( 558,  430, getResources().getString(R.string.nassau)));

        Level level = new Level(id, name, entries, R.drawable.north_central_america, R.drawable.thumb_north_central_america, 800, 640);
        return level;
    }

    private Level getSouthAmericaCities(int id) {
        String name = getResources().getString(R.string.cities_in_south_america);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 396,  701, getResources().getString(R.string.buenos_aires)));
        entries.add(new Entry( 560,  519, getResources().getString(R.string.sao_paulo)));
        entries.add(new Entry( 140,  343, getResources().getString(R.string.lima)));
        entries.add(new Entry( 168,  110, getResources().getString(R.string.bogota)));
        entries.add(new Entry( 615,  501, getResources().getString(R.string.rio_de_janeiro)));
        entries.add(new Entry( 223,  680, getResources().getString(R.string.santiago)));
        entries.add(new Entry( 682,  334, getResources().getString(R.string.salvador_de_bahia)));
        entries.add(new Entry( 210,  14, getResources().getString(R.string.maracaibo)));
        entries.add(new Entry( 547,  404, getResources().getString(R.string.braslia)));
        entries.add(new Entry( 149,  78, getResources().getString(R.string.medellin)));
        entries.add(new Entry( 89,  205, getResources().getString(R.string.guayaquil)));
        entries.add(new Entry( 280,  27, getResources().getString(R.string.caracas)));
        entries.add(new Entry( 333,  430, getResources().getString(R.string.santa_cruz)));
        entries.add(new Entry( 111,  181, getResources().getString(R.string.quito)));
        entries.add(new Entry( 430,  698, getResources().getString(R.string.montevideo)));
        entries.add(new Entry( 398,  76, getResources().getString(R.string.georgetown)));
        entries.add(new Entry( 249,  409, getResources().getString(R.string.la_paz)));
        entries.add(new Entry( 412,  541, getResources().getString(R.string.asuncin)));
        
        Level level = new Level(id, name, entries, R.drawable.south_america, R.drawable.thumb_south_america, 800, 800);
        return level;
    }

    private Level getOceaniaCities(int id) {
        String name = getResources().getString(R.string.cities_in_oceaniasoutheast_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 584,  419, getResources().getString(R.string.sydney)));
        entries.add(new Entry( 535,  460, getResources().getString(R.string.melbourne)));
        entries.add(new Entry( 316,  406, getResources().getString(R.string.perth)));
        entries.add(new Entry( 762,  445, getResources().getString(R.string.auckland)));
        entries.add(new Entry( 552,  202, getResources().getString(R.string.port_moresby)));
        entries.add(new Entry( 770,  492, getResources().getString(R.string.wellington)));
        entries.add(new Entry( 251,  178, getResources().getString(R.string.jakarta)));
        entries.add(new Entry( 388,  197, getResources().getString(R.string.dili)));
        entries.add(new Entry( 211,  100, getResources().getString(R.string.kuala_lumpur)));
        entries.add(new Entry( 353,  3, getResources().getString(R.string.manila)));
        entries.add(new Entry( 226,  113, getResources().getString(R.string.singapore)));
        entries.add(new Entry( 37,  67, getResources().getString(R.string.sri_jayawardenapurakotte)));
        entries.add(new Entry( 291,  189, getResources().getString(R.string.surabaya)));

        Level level = new Level(id, name, entries, R.drawable.oceania, R.drawable.thumb_oceania, 800, 640);
        return level;
    }

    private Level getAsianCities(int id) {
        String name = getResources().getString(R.string.cities_in_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 770,  344, getResources().getString(R.string.shanghai)));
        entries.add(new Entry( 216,  495, getResources().getString(R.string.bombay)));
        entries.add(new Entry( 147,  419, getResources().getString(R.string.karachi)));
        entries.add(new Entry( 258,  378, getResources().getString(R.string.delhi)));
        entries.add(new Entry( 410,  449, getResources().getString(R.string.dhaka)));
        entries.add(new Entry( 827,  256, getResources().getString(R.string.soeul)));
        entries.add(new Entry( 977,  282, getResources().getString(R.string.tokyo)));
        entries.add(new Entry( 720,  227, getResources().getString(R.string.peking)));
        entries.add(new Entry( 235,  339, getResources().getString(R.string.lahore)));
        entries.add(new Entry( 218,  286, getResources().getString(R.string.islamabad)));
        entries.add(new Entry( 532,  562, getResources().getString(R.string.bangkok)));
        entries.add(new Entry( 267,  586, getResources().getString(R.string.bangalore)));
        entries.add(new Entry( 168,  299, getResources().getString(R.string.kabul)));
        entries.add(new Entry( 170,  205, getResources().getString(R.string.tashkent)));
        entries.add(new Entry( 170,  243, getResources().getString(R.string.dushanbe)));
        entries.add(new Entry( 236,  180, getResources().getString(R.string.bishkek)));
        entries.add(new Entry( 192,  35, getResources().getString(R.string.astana)));
        entries.add(new Entry( 587,  85, getResources().getString(R.string.ulaanbaatar)));
        entries.add(new Entry( 816,  232, getResources().getString(R.string.pyongyang)));
        entries.add(new Entry( 592,  468, getResources().getString(R.string.hanoi)));
        entries.add(new Entry( 769,  423, getResources().getString(R.string.taipei)));
        entries.add(new Entry( 355,  390, getResources().getString(R.string.kathmandu)));
        entries.add(new Entry( 476,  527, getResources().getString(R.string.rangoon)));
        entries.add(new Entry( 579,  587, getResources().getString(R.string.phnom_penh)));
        entries.add(new Entry( 550,  505, getResources().getString(R.string.vientiane)));
        
        Level level = new Level(id, name, entries, R.drawable.asia, R.drawable.thumb_asia, 1033, 650);
        return level;
    }

    private Level getNearEastCities(int id) {
        String name = getResources().getString(R.string.cities_in_region_near_eastcaucasus);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 41,  180, getResources().getString(R.string.istanbul)));
        entries.add(new Entry( 152,  214, getResources().getString(R.string.ankara)));
        entries.add(new Entry( 473,  450, getResources().getString(R.string.baghdad)));
        entries.add(new Entry( 218,  507, getResources().getString(R.string.jerusalem)));
        entries.add(new Entry( 226,  446, getResources().getString(R.string.beirut)));
        entries.add(new Entry( 242,  505, getResources().getString(R.string.amman)));
        entries.add(new Entry( 495,  152, getResources().getString(R.string.tbilisi)));
        entries.add(new Entry( 484,  215, getResources().getString(R.string.yerewan)));
        entries.add(new Entry( 633,  200, getResources().getString(R.string.baku)));
        entries.add(new Entry( 247,  460, getResources().getString(R.string.damascus)));
        entries.add(new Entry( 448,  350, getResources().getString(R.string.mosul)));
        entries.add(new Entry( 273,  350, getResources().getString(R.string.aleppo)));
        entries.add(new Entry( 576,  546, getResources().getString(R.string.al_basrah)));
        entries.add(new Entry( 575,  590, getResources().getString(R.string.kuwait)));
        entries.add(new Entry( 657,  357, getResources().getString(R.string.tehran)));

        
        Level level = new Level(id, name, entries, R.drawable.near_east, R.drawable.thumb_near_east, 800, 640);
        return level;
    }

    private Level getArabianSeaCities(int id) {
        String name = getResources().getString(R.string.cities_around_the_arabian_sea);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 416,  3, getResources().getString(R.string.tehran)));
        entries.add(new Entry( 289,  40, getResources().getString(R.string.bagdhad)));
        entries.add(new Entry( 353,  121, getResources().getString(R.string.kuwait)));
        entries.add(new Entry( 319,  194, getResources().getString(R.string.riyadh)));
        entries.add(new Entry( 445,  204, getResources().getString(R.string.abu_dhabi)));
        entries.add(new Entry( 472,  183, getResources().getString(R.string.dubai)));
        entries.add(new Entry( 516,  219, getResources().getString(R.string.muscat)));
        entries.add(new Entry( 291,  362, getResources().getString(R.string.sanaa)));
        entries.add(new Entry( 208,  457, getResources().getString(R.string.addis_ababa)));
        entries.add(new Entry( 276,  417, getResources().getString(R.string.djibouti)));
        entries.add(new Entry( 212,  349, getResources().getString(R.string.asmera)));
        entries.add(new Entry( 102,  517, getResources().getString(R.string.juba)));
        entries.add(new Entry( 117,  352, getResources().getString(R.string.khartoum)));
        entries.add(new Entry( 650,  189, getResources().getString(R.string.karachi)));
        entries.add(new Entry( 615,  68, getResources().getString(R.string.kandahar)));
        entries.add(new Entry( 678,  9, getResources().getString(R.string.kabul)));
        entries.add(new Entry( 249,  266, getResources().getString(R.string.mecca)));
        entries.add(new Entry( 89,  101, getResources().getString(R.string.cairo)));
        entries.add(new Entry( 211,  201, getResources().getString(R.string.medina)));


        Level level = new Level(id, name, entries, R.drawable.arabian_sea, R.drawable.thumb_arabian_sea, 800, 640);
        return level;
    }

    private Level getNorthAfricaCities(int id) {
        String name = getResources().getString(R.string.cities_in_northern_africa);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 338,  542, getResources().getString(R.string.lagos)));
        entries.add(new Entry( 755,  151, getResources().getString(R.string.cairo)));
        entries.add(new Entry( 766,  405, getResources().getString(R.string.khartoum)));
        entries.add(new Entry( 732,  141, getResources().getString(R.string.alexandria)));
        entries.add(new Entry( 158,  103, getResources().getString(R.string.casablanca)));
        entries.add(new Entry( 225,  571, getResources().getString(R.string.abidjan)));
        entries.add(new Entry( 413,  453, getResources().getString(R.string.kano)));
        entries.add(new Entry( 337,  39, getResources().getString(R.string.algier)));
        entries.add(new Entry( 434,  29, getResources().getString(R.string.tunis)));
        entries.add(new Entry( 24,  419, getResources().getString(R.string.dakar)));
        entries.add(new Entry( 428,  581, getResources().getString(R.string.douala)));
        entries.add(new Entry( 456,  594, getResources().getString(R.string.yaound)));
        entries.add(new Entry( 385,  495, getResources().getString(R.string.abuja)));
        entries.add(new Entry( 179,  83, getResources().getString(R.string.rabat)));
        entries.add(new Entry( 129,  549, getResources().getString(R.string.monrovia)));
        entries.add(new Entry( 88,  514, getResources().getString(R.string.freetown)));
        entries.add(new Entry( 74,  499, getResources().getString(R.string.conakry)));
        entries.add(new Entry( 278,  561, getResources().getString(R.string.accra)));
        entries.add(new Entry( 313,  432, getResources().getString(R.string.niamey)));
        entries.add(new Entry( 521,  462, getResources().getString(R.string.ndjamena)));
        entries.add(new Entry( 156,  443, getResources().getString(R.string.bamako)));
        entries.add(new Entry( 486,  112, getResources().getString(R.string.tripoli)));

        
        Level level = new Level(id, name, entries, R.drawable.north_africa, R.drawable.thumb_north_africa, 800, 640);
        return level;
    }

    private Level getSouthAfricaCities(int id) {
        String name = getResources().getString(R.string.cities_in_southern_africa);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 336,  241, getResources().getString(R.string.kinshasa)));
        entries.add(new Entry( 298,  345, getResources().getString(R.string.luanda)));
        entries.add(new Entry( 627,  742, getResources().getString(R.string.johannesburg)));
        entries.add(new Entry( 412,  937, getResources().getString(R.string.cape_town)));
        entries.add(new Entry( 862,  306, getResources().getString(R.string.dar_es_salaam)));
        entries.add(new Entry( 1036,  560, getResources().getString(R.string.antananarivo)));
        entries.add(new Entry( 716,  725, getResources().getString(R.string.maputo)));
        entries.add(new Entry( 671,  547, getResources().getString(R.string.harare)));
        entries.add(new Entry( 615,  481, getResources().getString(R.string.lusaka)));
        entries.add(new Entry( 569,  708, getResources().getString(R.string.gabarone)));
        entries.add(new Entry( 375,  656, getResources().getString(R.string.windhoek)));
        entries.add(new Entry( 212,  114, getResources().getString(R.string.libreville)));
        entries.add(new Entry( 712,  137, getResources().getString(R.string.kampala)));
        entries.add(new Entry( 809,  173, getResources().getString(R.string.nairobi)));
        entries.add(new Entry( 659,  181, getResources().getString(R.string.kigali)));
        entries.add(new Entry( 647,  215, getResources().getString(R.string.bujumbura)));
        entries.add(new Entry( 327,  226, getResources().getString(R.string.brazzaville)));
        
        Level level = new Level(id, name, entries, R.drawable.south_africa, R.drawable.thumb_south_africa, 1301, 1008);
        return level;
    }

    private Level getWorldCities(int id) {
        String name = getResources().getString(R.string.biggest_cities_worldwide);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 816,  205, getResources().getString(R.string.beijing)));
        entries.add(new Entry( 269,  320, getResources().getString(R.string.bogot)));
        entries.add(new Entry( 319,  443, getResources().getString(R.string.buenos_aires)));
        entries.add(new Entry( 566,  239, getResources().getString(R.string.cairo)));
        entries.add(new Entry( 703,  257, getResources().getString(R.string.delhi)));
        entries.add(new Entry( 735,  266, getResources().getString(R.string.dhaka)));
        entries.add(new Entry( 808,  265, getResources().getString(R.string.guangzhou)));
        entries.add(new Entry( 560,  207, getResources().getString(R.string.istanbul)));
        entries.add(new Entry( 787,  349, getResources().getString(R.string.jakarta)));
        entries.add(new Entry( 675,  257, getResources().getString(R.string.karachi)));
        entries.add(new Entry( 523,  339, getResources().getString(R.string.kinshasa)));
        entries.add(new Entry( 720,  274, getResources().getString(R.string.kolkata)));
        entries.add(new Entry( 495,  316, getResources().getString(R.string.lagos)));
        entries.add(new Entry( 259,  355, getResources().getString(R.string.lima)));
        entries.add(new Entry( 479,  157, getResources().getString(R.string.london)));
        entries.add(new Entry( 141,  228, getResources().getString(R.string.los_angeles)));
        entries.add(new Entry( 826,  288, getResources().getString(R.string.manila)));
        entries.add(new Entry( 199,  275, getResources().getString(R.string.mexico_city)));
        entries.add(new Entry( 582,  138, getResources().getString(R.string.moscow)));
        entries.add(new Entry( 688,  280, getResources().getString(R.string.mumbai)));
        entries.add(new Entry( 269,  208, getResources().getString(R.string.new_york_city)));
        entries.add(new Entry( 864,  230, getResources().getString(R.string.osaka)));
        entries.add(new Entry( 359,  398, getResources().getString(R.string.rio_de_janeiro)));
        entries.add(new Entry( 344,  406, getResources().getString(R.string.so_paulo)));
        entries.add(new Entry( 844,  220, getResources().getString(R.string.seoul)));
        entries.add(new Entry( 826,  245, getResources().getString(R.string.shanghai)));
        entries.add(new Entry( 623,  226, getResources().getString(R.string.tehran)));
        entries.add(new Entry( 878,  223, getResources().getString(R.string.tokyo)));
        
        Level level = new Level(id, name, entries, R.drawable.world, R.drawable.thumb_world, 1022, 616);
        return level;
    }

    private Level getWorldOceans(int id) {
        String name = getResources().getString(R.string.biggest_oceans_and_seas);
        List<Entry> entries = new ArrayList<Entry>();
     
        entries.add(new Entry( 93,  304, getResources().getString(R.string.pacific_ocean)));
        entries.add(new Entry( 374,  233, getResources().getString(R.string.atlantic_ocean)));
        entries.add(new Entry( 719,  396, getResources().getString(R.string.indian_ocean)));
        entries.add(new Entry( 502,  14, getResources().getString(R.string.arctic_ocean)));
        entries.add(new Entry( 808,  295, getResources().getString(R.string.south_china_sea)));
        entries.add(new Entry( 273,  288, getResources().getString(R.string.caribbean_sea)));
        entries.add(new Entry( 498,  210, getResources().getString(R.string.mediterranean_sea)));
        entries.add(new Entry( 10,  119, getResources().getString(R.string.bering_sea)));
        entries.add(new Entry( 902,  140, getResources().getString(R.string.sea_of_okhotsk)));
        entries.add(new Entry( 219,  258, getResources().getString(R.string.gulf_of_mexico)));
        entries.add(new Entry( 660, 285, getResources().getString(R.string.arabian_sea)));
        entries.add(new Entry( 912, 381, getResources().getString(R.string.coral_sea)));
        entries.add(new Entry( 869, 299, getResources().getString(R.string.philippine_sea)));
        
        
        
        Level level = new Level(id, name, entries, R.drawable.world, R.drawable.thumb_world, 1022, 616);
        return level;
    }

    private Level getWorldContinentsIslands(int id) {
        String name = getResources().getString(R.string.continents_and_biggest_islands);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 199,  178, getResources().getString(R.string.north_america)));
        entries.add(new Entry( 320,  378, getResources().getString(R.string.south_america)));
        entries.add(new Entry( 535,  288, getResources().getString(R.string.africa)));
        entries.add(new Entry( 505,  171, getResources().getString(R.string.europe)));
        entries.add(new Entry( 739,  120, getResources().getString(R.string.asia)));
        entries.add(new Entry( 867,  410, getResources().getString(R.string.australia)));
        entries.add(new Entry( 770,  597, getResources().getString(R.string.antartica)));
        entries.add(new Entry( 356,  51, getResources().getString(R.string.greenland)));
        entries.add(new Entry( 886,  345, getResources().getString(R.string.new_guinea)));
        entries.add(new Entry( 805,  328, getResources().getString(R.string.borneo)));
        entries.add(new Entry( 617,  386, getResources().getString(R.string.madagascar)));
        entries.add(new Entry( 276,  50, getResources().getString(R.string.baffin_island)));
        entries.add(new Entry( 774,  338, getResources().getString(R.string.sumatra)));
        
        Level level = new Level(id, name, entries, R.drawable.world, R.drawable.thumb_world, 1022, 616);
        return level;

    }

    private Level getSouthAmericaCountries(int id) {
        String name = getResources().getString(R.string.south_america);
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry( 356,  25, getResources().getString(R.string.trinidad_and_tobago)));
        entries.add(new Entry( 295,  64, getResources().getString(R.string.venezuela)));
        entries.add(new Entry( 182,  121, getResources().getString(R.string.colombia)));
        entries.add(new Entry( 105,  196, getResources().getString(R.string.ecuador)));
        entries.add(new Entry( 146,  286, getResources().getString(R.string.peru)));
        entries.add(new Entry( 389,  93, getResources().getString(R.string.guyana)));
        entries.add(new Entry( 437,  119, getResources().getString(R.string.suriname)));
        entries.add(new Entry( 471,  117, getResources().getString(R.string.french_guiana_france)));
        entries.add(new Entry( 516,  334, getResources().getString(R.string.brasil)));
        entries.add(new Entry( 313,  598, getResources().getString(R.string.argentina)));
        entries.add(new Entry( 299,  412, getResources().getString(R.string.bolivia)));
        entries.add(new Entry( 402,  513, getResources().getString(R.string.paraguay)));
        entries.add(new Entry( 426,  653, getResources().getString(R.string.uruguay)));
        entries.add(new Entry( 242,  507, getResources().getString(R.string.chile)));
        Level level = new Level(id, name, entries, R.drawable.south_america, R.drawable.thumb_south_america, 800, 800);
        return level;
    }

    private Level getNorthAmericaCountries(int id) {
        String name = getResources().getString(R.string.northcentral_america);
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry( 543,  53, getResources().getString(R.string.canada)));
        entries.add(new Entry( 285,  220, getResources().getString(R.string.united_states_of_america)));
        entries.add(new Entry( 266,  454, getResources().getString(R.string.mexico)));
        entries.add(new Entry( 540,  463, getResources().getString(R.string.cuba)));
        entries.add(new Entry( 637,  501, getResources().getString(R.string.dominican_republic)));
        entries.add(new Entry( 687,  511, getResources().getString(R.string.purto_rico)));
        entries.add(new Entry( 616,  499, getResources().getString(R.string.haiti)));
        entries.add(new Entry( 517,  494, getResources().getString(R.string.cayman_islands)));
        entries.add(new Entry( 552,  434, getResources().getString(R.string.the_bahamas)));
        entries.add(new Entry( 561,  512, getResources().getString(R.string.jamaica)));
        entries.add(new Entry( 428,  525, getResources().getString(R.string.belize)));
        entries.add(new Entry( 407,  544, getResources().getString(R.string.guatemala)));
        entries.add(new Entry( 452,  554, getResources().getString(R.string.honduras)));
        entries.add(new Entry( 423,  565, getResources().getString(R.string.el_salvador)));
        entries.add(new Entry( 467,  579, getResources().getString(R.string.nicaragua)));
        entries.add(new Entry( 482,  613, getResources().getString(R.string.costa_rica)));
        entries.add(new Entry( 516,  627, getResources().getString(R.string.panama)));
        Level level = new Level(id, name, entries, R.drawable.north_central_america, R.drawable.thumb_north_central_america, 800, 640);
        return level;
    }

    private Level getOceaniaCountries(int id) {
        String name = getResources().getString(R.string.oceania);
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry( 44,  61, getResources().getString(R.string.sri_lanka)));
        entries.add(new Entry( 209,  94, getResources().getString(R.string.malaysia)));
        entries.add(new Entry( 370,  26, getResources().getString(R.string.philippines)));
        entries.add(new Entry( 226,  113, getResources().getString(R.string.singapore)));
        entries.add(new Entry( 298,  140, getResources().getString(R.string.indonesia)));
        entries.add(new Entry( 305,  87, getResources().getString(R.string.brunei)));
        entries.add(new Entry( 390,  196, getResources().getString(R.string.east_timor)));
        entries.add(new Entry( 537,  177, getResources().getString(R.string.papua_new_guinea)));
        entries.add(new Entry( 457,  344, getResources().getString(R.string.australia)));
        entries.add(new Entry( 749,  512, getResources().getString(R.string.new_zealand)));
        entries.add(new Entry( 643,  198, getResources().getString(R.string.solomon_islands)));
        entries.add(new Entry( 714,  262, getResources().getString(R.string.vanuatu)));
        entries.add(new Entry( 695,  307, getResources().getString(R.string.new_caledonia_france)));
        entries.add(new Entry( 789,  275, getResources().getString(R.string.fiji)));      
        Level level = new Level(id, name, entries, R.drawable.oceania, R.drawable.thumb_oceania, 800, 640);
        return level;
    }

    private Level getAsianCountries(int id) {
        String name = getResources().getString(R.string.centraleastern_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 566,  296, getResources().getString(R.string.china)));
        entries.add(new Entry( 554,  111, getResources().getString(R.string.mongolia)));
        entries.add(new Entry( 164,  86, getResources().getString(R.string.kazakhstan)));
        entries.add(new Entry( 111,  200, getResources().getString(R.string.uzbekistan)));
        entries.add(new Entry( 48,  231, getResources().getString(R.string.turkmenistan)));
        entries.add(new Entry( 235,  198, getResources().getString(R.string.kyrgystan)));
        entries.add(new Entry( 207,  238, getResources().getString(R.string.tajikistan)));
        entries.add(new Entry( 144,  303, getResources().getString(R.string.afghanistan)));
        entries.add(new Entry( 185,  356, getResources().getString(R.string.pakistan)));
        entries.add(new Entry( 280,  456, getResources().getString(R.string.india)));
        entries.add(new Entry( 301,  624, getResources().getString(R.string.sri_lanka)));
        entries.add(new Entry( 408,  444, getResources().getString(R.string.bangladesh)));
        entries.add(new Entry( 336,  381, getResources().getString(R.string.nepal)));
        entries.add(new Entry( 413,  391, getResources().getString(R.string.bhutan)));
        entries.add(new Entry( 482,  473, getResources().getString(R.string.myanmar_burma)));
        entries.add(new Entry( 554,  484, getResources().getString(R.string.laos)));
        entries.add(new Entry( 534,  540, getResources().getString(R.string.thailand)));
        entries.add(new Entry( 621,  570, getResources().getString(R.string.vietnam)));
        entries.add(new Entry( 576,  574, getResources().getString(R.string.cambodia)));
        entries.add(new Entry( 967,  282, getResources().getString(R.string.japan)));
        entries.add(new Entry( 759,  439, getResources().getString(R.string.taiwan)));
        entries.add(new Entry( 828,  222, getResources().getString(R.string.north_korea)));
        entries.add(new Entry( 843,  272, getResources().getString(R.string.south_korea)));
        
        Level level = new Level(id, name, entries, R.drawable.asia, R.drawable.thumb_asia, 1033, 650);
        return level;
    }

    private Level getNearEastCountries(int id) {
        String name = getResources().getString(R.string.near_east__caucasus);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 233,  250, getResources().getString(R.string.turkey)));
        entries.add(new Entry( 312,  391, getResources().getString(R.string.syria)));
        entries.add(new Entry( 235,  434, getResources().getString(R.string.lebanon)));
        entries.add(new Entry( 209,  537, getResources().getString(R.string.israel)));
        entries.add(new Entry( 221,  494, getResources().getString(R.string.palestinian_autonomous_areas_west_bank)));
        entries.add(new Entry( 83,  573, getResources().getString(R.string.egypt)));
        entries.add(new Entry( 252,  534, getResources().getString(R.string.jordan)));
        entries.add(new Entry( 444,  460, getResources().getString(R.string.iraq)));
        entries.add(new Entry( 704,  440, getResources().getString(R.string.iran)));
        entries.add(new Entry( 452,  138, getResources().getString(R.string.georgia)));
        entries.add(new Entry( 489,  206, getResources().getString(R.string.armenia)));
        entries.add(new Entry( 563,  197, getResources().getString(R.string.azerbaijan)));
        entries.add(new Entry( 565,  581, getResources().getString(R.string.kuwait)));
        entries.add(new Entry( 362,  585, getResources().getString(R.string.saudi_arabia)));
        entries.add(new Entry( 770,  221, getResources().getString(R.string.turkmenistan)));
        
        
        Level level = new Level(id, name, entries, R.drawable.near_east, R.drawable.thumb_near_east, 800, 640);
        return level;
    }

    private Level getArabicSeaCountries(int id) {
        String name = getResources().getString(R.string.around_the_arabian_sea_east_africa_west_asia);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 65,  162, getResources().getString(R.string.egypt)));
        entries.add(new Entry( 67,  328, getResources().getString(R.string.sudan)));
        entries.add(new Entry( 82,  480, getResources().getString(R.string.south_sudan)));
        entries.add(new Entry( 117,  573, getResources().getString(R.string.uganda)));
        entries.add(new Entry( 191,  585, getResources().getString(R.string.kenya)));
        entries.add(new Entry( 343,  513, getResources().getString(R.string.somalia)));
        entries.add(new Entry( 219,  471, getResources().getString(R.string.ethopia)));
        entries.add(new Entry( 201,  343, getResources().getString(R.string.eritrea)));
        entries.add(new Entry( 265,  416, getResources().getString(R.string.djibouti)));
        entries.add(new Entry( 348,  351, getResources().getString(R.string.yemen)));
        entries.add(new Entry( 479,  287, getResources().getString(R.string.oman)));
        entries.add(new Entry( 294,  203, getResources().getString(R.string.saudi_arabia)));
        entries.add(new Entry( 443,  215, getResources().getString(R.string.united_arab_emirates)));
        entries.add(new Entry( 404,  185, getResources().getString(R.string.qatar)));
        entries.add(new Entry( 392,  172, getResources().getString(R.string.bahrain)));
        entries.add(new Entry( 453,  64, getResources().getString(R.string.iran)));
        entries.add(new Entry( 647,  140, getResources().getString(R.string.pakistan)));
        entries.add(new Entry( 766,  213, getResources().getString(R.string.india)));
        entries.add(new Entry( 348,  113, getResources().getString(R.string.kuwait)));
        entries.add(new Entry( 617,  41, getResources().getString(R.string.afghanistan)));
        entries.add(new Entry( 171,  83, getResources().getString(R.string.jordan)));
        entries.add(new Entry( 285, 52, getResources().getString(R.string.iraq)));
        
        
        Level level = new Level(id, name, entries, R.drawable.arabian_sea, R.drawable.thumb_arabian_sea, 800, 640);
        return level;
    }

    private Level getNorthAfricaCountries(int id) {
        String name = getResources().getString(R.string.northwest_africa);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 427,  85, getResources().getString(R.string.tunisia)));
        entries.add(new Entry( 330, 185, getResources().getString(R.string.algeria)));
        entries.add(new Entry( 180, 115, getResources().getString(R.string.marocco)));
        entries.add(new Entry( 550, 198, getResources().getString(R.string.libya)));
        entries.add(new Entry( 730, 217, getResources().getString(R.string.egypt)));
        entries.add(new Entry( 133,  330, getResources().getString(R.string.mauretania)));
        entries.add(new Entry( 56,  403, getResources().getString(R.string.senegal)));
        entries.add(new Entry( 38,  433, getResources().getString(R.string.gambia)));
        entries.add(new Entry( 55,  462, getResources().getString(R.string.guineabissau)));
        entries.add(new Entry( 80,  484, getResources().getString(R.string.guinea)));
        entries.add(new Entry( 103,  512, getResources().getString(R.string.sierra_leone)));
        entries.add(new Entry( 136,  542, getResources().getString(R.string.liberia)));
        entries.add(new Entry( 206,  547, getResources().getString(R.string.cte_divoire_ivory_coast)));
        entries.add(new Entry( 266,  540, getResources().getString(R.string.ghana)));
        entries.add(new Entry( 304,  523, getResources().getString(R.string.togo)));
        entries.add(new Entry( 319,  496, getResources().getString(R.string.benin)));
        entries.add(new Entry( 396,  510, getResources().getString(R.string.nigeria)));
        entries.add(new Entry( 465,  574, getResources().getString(R.string.cameroon)));
        entries.add(new Entry( 438,  622, getResources().getString(R.string.equatorial_guinea)));
        entries.add(new Entry( 718,  413, getResources().getString(R.string.sudan)));
        entries.add(new Entry( 740,  540, getResources().getString(R.string.south_sudan)));
        entries.add(new Entry( 563,  400, getResources().getString(R.string.chad)));
        entries.add(new Entry( 553,  214, getResources().getString(R.string.libya)));
        entries.add(new Entry( 422,  362, getResources().getString(R.string.niger)));
        entries.add(new Entry( 591,  540, getResources().getString(R.string.central_african_republic)));
        
        Level level = new Level(id, name, entries, R.drawable.north_africa, R.drawable.thumb_north_africa, 800, 640);
        return level;
    }

    private Level getLevelEuropeanCities(int id) {
        String name = getString(R.string.europe_cities);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 714, 530, getResources().getString(R.string.istanbul)));
        entries.add(new Entry( 793, 255, getResources().getString(R.string.moscow)));
        entries.add(new Entry( 381, 355, getResources().getString(R.string.london)));
        entries.add(new Entry( 728, 187, getResources().getString(R.string.saint_petersburg)));
        entries.add(new Entry( 536, 334, getResources().getString(R.string.berlin)));
        entries.add(new Entry( 346, 541, getResources().getString(R.string.madrid)));
        entries.add(new Entry( 735, 381, getResources().getString(R.string.kiev)));
        entries.add(new Entry( 519, 508, getResources().getString(R.string.rome)));
        entries.add(new Entry( 415, 401, getResources().getString(R.string.paris)));
        entries.add(new Entry( 702, 312, getResources().getString(R.string.minsk)));
        entries.add(new Entry( 496, 319, getResources().getString(R.string.hamburg)));
        entries.add(new Entry( 604, 433, getResources().getString(R.string.budapest)));
        entries.add(new Entry( 577, 416, getResources().getString(R.string.vienna)));
        entries.add(new Entry( 622, 343, getResources().getString(R.string.warsaw)));
        entries.add(new Entry( 408, 525, getResources().getString(R.string.bucharest)));
        entries.add(new Entry( 675, 475, getResources().getString(R.string.munich)));
        entries.add(new Entry( 491, 461, getResources().getString(R.string.milan)));
        entries.add(new Entry( 551, 387, getResources().getString(R.string.prague)));
        entries.add(new Entry( 661, 505, getResources().getString(R.string.sofia)));
        entries.add(new Entry( 619, 478, getResources().getString(R.string.belgrade)));
        
        Level level = new Level(id, name, entries, R.drawable.europe, R.drawable.thumb_europe, 800, 640);
        return level;
    }

    private Level getSouthAfricaCountries(int id) {
        String name = getResources().getString(R.string.africasouth);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 502, 857, getResources().getString(R.string.south_africa)));
        entries.add(new Entry( 1017, 590, getResources().getString(R.string.madagascar)));
        entries.add(new Entry( 617, 820, getResources().getString(R.string.lesotho)));
        entries.add(new Entry( 689, 745, getResources().getString(R.string.swasiland)));
        entries.add(new Entry( 772, 547, getResources().getString(R.string.mozambique)));
        entries.add(new Entry( 657, 565, getResources().getString(R.string.zimbabwe)));
        entries.add(new Entry( 524, 635, getResources().getString(R.string.botswana)));
        entries.add(new Entry( 362, 645, getResources().getString(R.string.namibia)));
        entries.add(new Entry( 375, 413, getResources().getString(R.string.angola)));
        entries.add(new Entry( 750, 431, getResources().getString(R.string.malawi)));
        entries.add(new Entry( 580, 454, getResources().getString(R.string.zambia)));
        entries.add(new Entry( 509, 186, getResources().getString(R.string.dr_of_the_congo_kinshasa)));
        entries.add(new Entry( 745, 279, getResources().getString(R.string.tanzania)));
        entries.add(new Entry( 339, 161, getResources().getString(R.string.republic_of_the_congo_brazzaville)));
        entries.add(new Entry( 255, 144, getResources().getString(R.string.gabon)));
        entries.add(new Entry( 660, 180, getResources().getString(R.string.ruanda)));
        entries.add(new Entry( 655, 224, getResources().getString(R.string.burundi)));
        entries.add(new Entry( 712, 112, getResources().getString(R.string.uganda)));
        entries.add(new Entry( 871, 122, getResources().getString(R.string.kenya)));
        entries.add(new Entry( 150, 134, getResources().getString(R.string.sao_tome_and_principe)));
        entries.add(new Entry( 992, 427, getResources().getString(R.string.mayotte_france)));
        entries.add(new Entry( 1219, 616, getResources().getString(R.string.runion_france)));
        entries.add(new Entry( 952, 399, getResources().getString(R.string.comores)));
        entries.add(new Entry( 1265, 597, getResources().getString(R.string.mauritius)));
        
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
    
    private Level getLevelEuropeCountriesAll(int id) {
        String name = getString(R.string.europe_countries_all);
        List<Entry> entries = europeCountryListHard();
        entries.addAll(europeCountryListEasy());
        Level level = new Level(id, name, entries, R.drawable.europe, R.drawable.thumb_europe,  800, 640);
        return level;
    }
    

    private List<Entry> europeCountryListEasy() {
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 410, 439, getString(R.string.france)));
//        entries.add(new Entry( 497, 352, getString(R.string.germany)));
//        entries.add(new Entry( 377, 345, getString(R.string.england)));
//        entries.add(new Entry( 605, 339, getString(R.string.poland)));
//        entries.add(new Entry( 352, 539, getString(R.string.spain)));
//        entries.add(new Entry( 723, 390, getString(R.string.ukraine)));
//        entries.add(new Entry( 745, 229, getString(R.string.russia)));
//        entries.add(new Entry( 667, 454, getString(R.string.romania)));
//        entries.add(new Entry( 450, 337, getString(R.string.the_netherlands)));
//        entries.add(new Entry( 438, 367, getString(R.string.belgium)));
//        entries.add(new Entry( 647, 566, getString(R.string.greece)));
//        entries.add(new Entry( 550, 389, getString(R.string.czech_republic)));
//        entries.add(new Entry( 605, 434, getString(R.string.hungary)));
//        entries.add(new Entry( 290, 550, getString(R.string.portugal)));
//        entries.add(new Entry( 523, 500, getString(R.string.italy)));
//        entries.add(new Entry( 622, 480, getString(R.string.serbia)));
//        entries.add(new Entry( 705, 322, getString(R.string.belarus)));        
//        entries.add(new Entry( 747, 559, getString(R.string.turkey)));        
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


    private Resources getResources() {
        return activity.getResources();
    }

}
