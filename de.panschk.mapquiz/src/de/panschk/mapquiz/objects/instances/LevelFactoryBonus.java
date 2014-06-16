package de.panschk.mapquiz.objects.instances;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import de.panschk.mapquiz.R;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;

public class LevelFactoryBonus extends LevelFactory {

    public static enum LevelEnumBonus {
        LEVEL_EUROPE_COUNTRIES_ALL, LEVEL_FRANCE_REGIONS, LEVEL_FRANCE_CITIES, LEVEL_GUYANA_GUIANA, LEVEL_GERMANY_BUNDERLAENDER, LEVEL_GERMANY_CITIES, LEVEL_WORLD_MOUNTAIN_RANGES, LEVEL_UK_REGIONS, LEVEL_UK_CITIES, LEVEL_USA_STATES, LEVEL_USA_CITIES, LEVEL_EUROPE_FOOD, LEVEL_INDIA_CITIES, LEVEL_CHINA_CITIES, LEVEL_WORLD_BIG_COMPANIES, LEVEL_WORLD_LAKES, LEVEL_EUROPE_STREAMS, LEVEL_MADAGASCAR, LEVEL_BIGGEST_DESERTS, LEVEL_GERMAN_ISLANDS

    }


    public LevelFactoryBonus(Activity activity) {
        super(activity);

    }

    public Level getLevel(LevelEnumBonus level) {
        int id = level.ordinal();
        switch (level) {
        case LEVEL_EUROPE_COUNTRIES_ALL:
            return getLevelEuropeCountriesAll(id);
        case LEVEL_FRANCE_REGIONS:
            return getLevelFranceRegions(id);
        case LEVEL_FRANCE_CITIES:
            return getLevelFranceCities(id);
        case LEVEL_GUYANA_GUIANA:
            return getLevelGuyanaGuinea(id);
        case LEVEL_GERMANY_BUNDERLAENDER:
            return getLevelGermanyBundeslaender(id);
        case LEVEL_GERMANY_CITIES:
            return getLevelGermanyCities(id);
        case LEVEL_WORLD_MOUNTAIN_RANGES:
            return getLevelMountains(id);
        case LEVEL_UK_REGIONS:
            return getLevelUKRegions(id);
        case LEVEL_UK_CITIES:
            return getLevelUKCities(id);
        case LEVEL_USA_CITIES:
            return getLevelUSCities(id);
        case LEVEL_USA_STATES:
            return getLevelUSStates(id);
        case LEVEL_EUROPE_FOOD:
            return getLevelEuropeFood(id);
        case LEVEL_MADAGASCAR:
        	return getLevelMadagascar(id);
        case LEVEL_INDIA_CITIES:
            return getLevelIndiaCities(id);
        case LEVEL_CHINA_CITIES:
            return getLevelChinaCities(id);
        case LEVEL_WORLD_BIG_COMPANIES:
            return getLevelWorldCompanies(id);
        case LEVEL_WORLD_LAKES:
            return getLevelWorldLakes(id);
        case LEVEL_EUROPE_STREAMS:
            return getLevelEuropeStreams(id);
        case LEVEL_BIGGEST_DESERTS:
        	return getBiggestDeserts(id);
        case LEVEL_GERMAN_ISLANDS:
        	return getGermanIslands(id);
        default:
            break;
        }

        return null;

    }

   private Level getLevelEuropeStreams(int id) {
       String name = getString(R.string.rivers_in_europe);
       List<Entry> entries = new ArrayList<Entry>();
       entries.add(new Entry( 381,  257, getString(R.string.dnjepr)));
       entries.add(new Entry( 292,  333, getString(R.string.donau)));
       entries.add(new Entry( 74,  349, getString(R.string.ebro)));
       entries.add(new Entry( 224,  233, getString(R.string.elbe)));
       entries.add(new Entry( 139,  297, getString(R.string.loire)));
       entries.add(new Entry( 244,  236, getString(R.string.oder)));
       entries.add(new Entry( 216,  338, getString(R.string.po)));
       entries.add(new Entry( 186,  262, getString(R.string.rhein)));
       entries.add(new Entry( 168,  323, getString(R.string.rhone)));
       entries.add(new Entry( 134,  273, getString(R.string.seine)));
       entries.add(new Entry( 40,  375, getString(R.string.tajo)));
       entries.add(new Entry( 294,  239, getString(R.string.weichsel)));
       entries.add(new Entry( 445,  152, getString(R.string.wolga)));

       Level level = new Level(id, name, entries, R.drawable.europe_streams, R.drawable.thumb_europe_streams, 472, 472);
       return level;
    }

private Level getLevelWorldLakes(int id) {
    String name = getString(R.string.largest_lakes_worldwide);
    List<Entry> entries = new ArrayList<Entry>();
    entries.add(new Entry( 625,  205, getString(R.string.caspian_sea)));
    entries.add(new Entry( 220,  170, getString(R.string.lake_superior)));
    entries.add(new Entry( 228,  180, getString(R.string.lake_michigan)));
    entries.add(new Entry( 240,  174, getString(R.string.lake_huron)));
    entries.add(new Entry( 267,  174, getString(R.string.lake_ontario)));
    entries.add(new Entry( 131,  77, getString(R.string.great_bear_lake)));
    entries.add(new Entry( 571,  326, getString(R.string.lake_victoria)));
    entries.add(new Entry( 572,  347, getString(R.string.lake_tanganyika)));
    entries.add(new Entry( 762,  181, getString(R.string.baikal)));
    entries.add(new Entry( 578,  369, getString(R.string.lake_malawi)));
    entries.add(new Entry( 152,  126, getString(R.string.great_slave_lake)));
    entries.add(new Entry( 685,  187, getString(R.string.issyk_kul)));
    Level level = new Level(id, name, entries, R.drawable.world2, R.drawable.thumb_world2, 1022, 616);
    return level;
    }

 private Level getLevelWorldCompanies(int id) {
        String name = getString(R.string.most_profitable_companies);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 212,  223, getString(R.string.exxonmobil_oil_and_gas)));
        entries.add(new Entry( 478,  157, getString(R.string.royal_dutch_shell_oil_and_gas)));
        entries.add(new Entry( 221,  212, getString(R.string.walmart_retailing)));
        entries.add(new Entry( 478,  156, getString(R.string.bp_oil_and_gas)));
        entries.add(new Entry( 488,  167, getString(R.string.vitol_commodities)));
        entries.add(new Entry( 805,  200, getString(R.string.sinopec_oil_and_gas)));
        entries.add(new Entry( 136,  214, getString(R.string.chevron_oil_and_gas)));
        entries.add(new Entry( 844,  223, getString(R.string.samsung_electronics)));
        entries.add(new Entry( 877,  224, getString(R.string.toyota_automotive)));
        entries.add(new Entry( 488,  173, getString(R.string.total_sa_oil_and_gas)));
        entries.add(new Entry( 511,  157, getString(R.string.volkswagen_group_automotive)));
        entries.add(new Entry( 505,  175, getString(R.string.glencore_commodities)));
        entries.add(new Entry( 619,  251, getString(R.string.saudi_aramco_oil_and_gas)));
        entries.add(new Entry( 591,  142, getString(R.string.gazprom_oil_and_gas)));

        Level level = new Level(id, name, entries, R.drawable.world2, R.drawable.thumb_world2, 1022, 616);
        return level;
    }

    private Level getLevelChinaCities(int id) {
        String name = getString(R.string.cities_in_china);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 825,  500, getString(R.string.shanghai)));
        entries.add(new Entry( 720,  307, getString(R.string.beijing)));
        entries.add(new Entry( 710,  704, getString(R.string.hong_kong)));
        entries.add(new Entry( 739,  326, getString(R.string.tianjin)));
        entries.add(new Entry( 681,  519, getString(R.string.wuhan)));
        entries.add(new Entry( 683,  686, getString(R.string.guangzhou)));
        entries.add(new Entry( 704,  693, getString(R.string.shenzhen)));
        entries.add(new Entry( 825,  273, getString(R.string.shenyang)));
        entries.add(new Entry( 547,  551, getString(R.string.chongqing)));
        entries.add(new Entry( 776,  483, getString(R.string.nanjing)));
        entries.add(new Entry( 893,  149, getString(R.string.harbin)));
        entries.add(new Entry( 845,  633, getString(R.string.taipei)));
        entries.add(new Entry( 599,  433, getString(R.string.xian)));
        entries.add(new Entry( 501,  526, getString(R.string.chengdu)));
        entries.add(new Entry( 850,  213, getString(R.string.changchun)));
        entries.add(new Entry( 808,  521, getString(R.string.hangzhou)));
        entries.add(new Entry( 729,  391, getString(R.string.jinan)));
        Level level = new Level(id, name, entries, R.drawable.china, R.drawable.thumb_china, 996, 800);
        return level;
    }

    private Level getLevelIndiaCities(int id) {
        String name = getString(R.string.cities_in_india);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 120,  475, getString(R.string.mumbai)));
        entries.add(new Entry( 242,  200, getString(R.string.delhi)));
        entries.add(new Entry( 248,  655, getString(R.string.bangalore)));
        entries.add(new Entry( 273,  522, getString(R.string.hyderabad)));
        entries.add(new Entry( 106,  383, getString(R.string.ahmedabad)));
        entries.add(new Entry( 326,  651, getString(R.string.chennai)));
        entries.add(new Entry( 545,  371, getString(R.string.kolkata)));
        entries.add(new Entry( 123,  414, getString(R.string.surat)));
        entries.add(new Entry( 137,  492, getString(R.string.pune)));
        entries.add(new Entry( 209,  251, getString(R.string.jaipur)));
        entries.add(new Entry( 341,  251, getString(R.string.lucknow)));
        entries.add(new Entry( 248,  358, getString(R.string.bhopal)));
        entries.add(new Entry( 450,  288, getString(R.string.patna)));
  
        Level level = new Level(id, name, entries, R.drawable.india, R.drawable.thumb_india, 773, 802);
        return level;
    }

    private Level getLevelUSStates(int id) {
        String name = getString(R.string.us_states);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 816,  528, getString(R.string.alabama)));
        entries.add(new Entry( 253,  471, getString(R.string.arizona)));
        entries.add(new Entry( 689,  478, getString(R.string.arkansas)));
        entries.add(new Entry( 78,  373, getString(R.string.california)));
        entries.add(new Entry( 401,  362, getString(R.string.colorado)));
        entries.add(new Entry( 1080,  228, getString(R.string.connecticut)));
        entries.add(new Entry( 1044,  315, getString(R.string.delaware)));
        entries.add(new Entry( 958,  646, getString(R.string.florida)));
        entries.add(new Entry( 903,  516, getString(R.string.georgia_state)));
        entries.add(new Entry( 237,  210, getString(R.string.idaho)));
        entries.add(new Entry( 749,  319, getString(R.string.illinois)));
        entries.add(new Entry( 813,  330, getString(R.string.indiana)));
        entries.add(new Entry( 652,  279, getString(R.string.iowa)));
        entries.add(new Entry( 544,  378, getString(R.string.kansas)));
        entries.add(new Entry( 842,  392, getString(R.string.kentucky)));
        entries.add(new Entry( 690,  579, getString(R.string.louisiana)));
        entries.add(new Entry( 1122,  89, getString(R.string.maine)));
        entries.add(new Entry( 1012,  312, getString(R.string.maryland)));
        entries.add(new Entry( 1090,  203, getString(R.string.massachusetts)));
        entries.add(new Entry( 821,  212, getString(R.string.michigan)));
        entries.add(new Entry( 636,  141, getString(R.string.minnesota)));
        entries.add(new Entry( 756,  520, getString(R.string.mississippi)));
        entries.add(new Entry( 681,  380, getString(R.string.missouri)));
        entries.add(new Entry( 366,  122, getString(R.string.montana)));
        entries.add(new Entry( 530,  294, getString(R.string.nebraska)));
        entries.add(new Entry( 166,  306, getString(R.string.nevada)));
        entries.add(new Entry( 1091,  168, getString(R.string.new_hampshire)));
        entries.add(new Entry( 1057,  287, getString(R.string.new_jersey)));
        entries.add(new Entry( 375,  483, getString(R.string.new_mexico)));
        entries.add(new Entry( 1027,  209, getString(R.string.new_york)));
        entries.add(new Entry( 973,  424, getString(R.string.north_carolina)));
        entries.add(new Entry( 520,  121, getString(R.string.north_dakota)));
        entries.add(new Entry( 878,  307, getString(R.string.ohio)));
        entries.add(new Entry( 584,  454, getString(R.string.oklahoma)));
        entries.add(new Entry( 101,  169, getString(R.string.oregon)));
        entries.add(new Entry( 978,  269, getString(R.string.pennsylvania)));
        entries.add(new Entry( 1105,  225, getString(R.string.rhode_island)));
        entries.add(new Entry( 954,  481, getString(R.string.south_carolina)));
        entries.add(new Entry( 516,  214, getString(R.string.south_dakota)));
        entries.add(new Entry( 822,  443, getString(R.string.tennessee)));
        entries.add(new Entry( 536,  574, getString(R.string.texas)));
        entries.add(new Entry( 268,  332, getString(R.string.utah)));
        entries.add(new Entry( 1066,  165, getString(R.string.vermont)));
        entries.add(new Entry( 985,  372, getString(R.string.virginia)));
        entries.add(new Entry( 142,  76, getString(R.string.washington)));
        entries.add(new Entry( 934,  344, getString(R.string.west_virginia)));
        entries.add(new Entry( 732,  199, getString(R.string.wisconsin)));
        entries.add(new Entry( 372,  241, getString(R.string.wyoming)));
        Level level = new Level(id, name, entries, R.drawable.usa, R.drawable.thumb_usa, 1187, 739);
        return level;
    }

    private Level getLevelUSCities(int id) {
        String name = getString(R.string.largest_cities_in_the_usa);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1065, 258, getString(R.string.new_york_city)));
        entries.add(new Entry(100, 455, getString(R.string.los_angeles)));
        entries.add(new Entry(776, 278, getString(R.string.chicago)));
        entries.add(new Entry(627, 625, getString(R.string.houston)));
        entries.add(new Entry(1038, 292, getString(R.string.philadelphia)));
        entries.add(new Entry(240, 493, getString(R.string.phoenix)));
        entries.add(new Entry(535, 632, getString(R.string.san_antonio)));
        entries.add(new Entry(122, 495, getString(R.string.san_diego)));
        entries.add(new Entry(588, 541, getString(R.string.dallas)));
        entries.add(new Entry(46, 341, getString(R.string.san_jose)));
        entries.add(new Entry(958, 591, getString(R.string.jacksonville)));
        entries.add(new Entry(815, 332, getString(R.string.indianapolis)));
        entries.add(new Entry(568, 611, getString(R.string.austin)));
        entries.add(new Entry(39, 329, getString(R.string.san_francisco)));
        entries.add(new Entry(880, 319, getString(R.string.columbus)));
        entries.add(new Entry(577, 539, getString(R.string.fort_worth)));
        entries.add(new Entry(960, 447, getString(R.string.charlotte)));
        entries.add(new Entry(868, 251, getString(R.string.detroit)));
        entries.add(new Entry(743, 466, getString(R.string.memphis)));
        entries.add(new Entry(1112, 201, getString(R.string.boston)));
        entries.add(new Entry(115, 61, getString(R.string.seattle)));
        entries.add(new Entry(417, 340, getString(R.string.denver)));
        entries.add(new Entry(1016, 312, getString(R.string.baltimore)));
        entries.add(new Entry(1011, 326, getString(R.string.washington)));
        entries.add(new Entry(812, 434, getString(R.string.nashville)));
        Level level = new Level(id, name, entries, R.drawable.usa, R.drawable.thumb_usa, 1187, 739);
        return level;
    }

    private Level getLevelUKCities(int id) {
        String name = getString(R.string.cities_of_great_britain);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(565, 599, getString(R.string.london)));
        entries.add(new Entry(443, 528, getString(R.string.birmingham)));
        entries.add(new Entry(360, 239, getString(R.string.glasgow)));
        entries.add(new Entry(410, 440, getString(R.string.liverpool)));
        entries.add(new Entry(492, 383, getString(R.string.leeds)));
        entries.add(new Entry(500, 428, getString(R.string.sheffield)));
        entries.add(new Entry(415, 219, getString(R.string.edinburgh)));
        entries.add(new Entry(419, 604, getString(R.string.bristol)));
        entries.add(new Entry(440, 433, getString(R.string.manchester)));
        entries.add(new Entry(507, 497, getString(R.string.leicester)));
        entries.add(new Entry(395, 605, getString(R.string.cardiff)));
        entries.add(new Entry(228, 354, getString(R.string.belfast)));

        Level level = new Level(id, name, entries, R.drawable.uk, R.drawable.thumb_uk, 680, 734);
        return level;
    }

    private Level getLevelUKRegions(int id) {
        String name = getString(R.string.regions_of_great_britain);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(527, 476, getString(R.string.east_midlands)));
        entries.add(new Entry(599, 532, getString(R.string.east_of_england)));
        entries.add(new Entry(565, 596, getString(R.string.greater_london)));
        entries.add(new Entry(473, 300, getString(R.string.north_east_england)));
        entries.add(new Entry(418, 344, getString(R.string.north_west_england)));
        entries.add(new Entry(388, 650, getString(R.string.south_west_england)));
        entries.add(new Entry(528, 633, getString(R.string.south_east_england)));
        entries.add(new Entry(447, 515, getString(R.string.west_midlands)));
        entries.add(new Entry(506, 388, getString(R.string.yorkshire_and_the_humber)));
        entries.add(new Entry(362, 159, getString(R.string.scotland)));
        entries.add(new Entry(371, 550, getString(R.string.wales)));
        entries.add(new Entry(197, 359, getString(R.string.northern_ireland)));

        Level level = new Level(id, name, entries, R.drawable.uk, R.drawable.thumb_uk, 680, 734);
        return level;
    }

    private Level getLevelGermanyCities(int id) {
        String name = getString(R.string.german_cities);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(310, 982, getString(R.string.stuttgart)));
        entries.add(new Entry(600, 1082, getString(R.string.munich)));
        entries.add(new Entry(717, 365, getString(R.string.potsdam)));
        entries.add(new Entry(216, 762, getString(R.string.wiesbaden)));
        entries.add(new Entry(547, 193, getString(R.string.schwerin)));
        entries.add(new Entry(390, 382, getString(R.string.hanover)));
        entries.add(new Entry(78, 565, getString(R.string.dsseldorf)));
        entries.add(new Entry(220, 774, getString(R.string.mainz)));
        entries.add(new Entry(83, 886, getString(R.string.saarbrcken)));
        entries.add(new Entry(807, 606, getString(R.string.dresden)));
        entries.add(new Entry(579, 427, getString(R.string.magdeburg)));
        entries.add(new Entry(429, 87, getString(R.string.kiel)));
        entries.add(new Entry(512, 619, getString(R.string.erfurt)));
        entries.add(new Entry(74, 600, getString(R.string.cologne)));
        entries.add(new Entry(271, 742, getString(R.string.frankfurt_am_main)));
        entries.add(new Entry(140, 509, getString(R.string.dortmund)));
        entries.add(new Entry(90, 521, getString(R.string.essen)));
        entries.add(new Entry(653, 558, getString(R.string.leipzig)));
        entries.add(new Entry(538, 847, getString(R.string.nuremberg)));
        Level level = new Level(id, name, entries, R.drawable.germany, R.drawable.thumb_germany, 918, 1208);
        return level;
    }

    private Level getLevelGermanyBundeslaender(int id) {
        String name = getString(R.string.german_regions_bundeslnder);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(303, 997, getString(R.string.badenwrttemberg)));
        entries.add(new Entry(583, 948, getString(R.string.bavaria)));
        entries.add(new Entry(737, 340, getString(R.string.berlin)));
        entries.add(new Entry(771, 425, getString(R.string.brandenburg)));
        entries.add(new Entry(299, 282, getString(R.string.bremen)));
        entries.add(new Entry(422, 212, getString(R.string.hamburg)));
        entries.add(new Entry(300, 669, getString(R.string.hesse)));
        entries.add(new Entry(668, 166, getString(R.string.mecklenburgvorpommern)));
        entries.add(new Entry(391, 355, getString(R.string.lower_saxony)));
        entries.add(new Entry(157, 538, getString(R.string.north_rhinewestphalia)));
        entries.add(new Entry(115, 765, getString(R.string.rhinelandpalatinate)));
        entries.add(new Entry(82, 865, getString(R.string.saarland)));
        entries.add(new Entry(743, 608, getString(R.string.saxony)));
        entries.add(new Entry(580, 461, getString(R.string.saxonyanhalt)));
        entries.add(new Entry(401, 122, getString(R.string.schleswigholstein)));
        entries.add(new Entry(493, 627, getString(R.string.thuringia)));

        Level level = new Level(id, name, entries, R.drawable.germany, R.drawable.thumb_germany, 918, 1208);
        return level;
    }

    private Level getLevelFranceCities(int id) {
        String name = getString(R.string.cities_of_france);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(223, 111, getString(R.string.paris)));
        entries.add(new Entry(317, 374, getString(R.string.marseille)));
        entries.add(new Entry(285, 256, getString(R.string.lyon)));
        entries.add(new Entry(154, 358, getString(R.string.toulouse)));
        entries.add(new Entry(378, 355, getString(R.string.nice)));
        entries.add(new Entry(86, 163, getString(R.string.nantes)));
        entries.add(new Entry(396, 124, getString(R.string.strasbourg)));
        entries.add(new Entry(253, 363, getString(R.string.montpellier)));
        entries.add(new Entry(99, 281, getString(R.string.bordeaux)));
        entries.add(new Entry(91, 119, getString(R.string.rennes)));
        entries.add(new Entry(163, 67, getString(R.string.le_havre)));
        entries.add(new Entry(239, 83, getString(R.string.reims)));
        entries.add(new Entry(252, 20, getString(R.string.lille)));
        Level level = new Level(id, name, entries, R.drawable.france, R.drawable.thumb_france, 415, 452);
        return level;
    }

    private Level getLevelFranceRegions(int id) {
        String name = getString(R.string.regions_of_france);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(388, 120, getString(R.string.alsace)));
        entries.add(new Entry(115, 308, getString(R.string.aquitaine)));
        entries.add(new Entry(239, 257, getString(R.string.auvergne)));
        entries.add(new Entry(54, 117, getString(R.string.brittany)));
        entries.add(new Entry(278, 174, getString(R.string.burgundy)));
        entries.add(new Entry(198, 168, getString(R.string.centre)));
        entries.add(new Entry(286, 118, getString(R.string.champagneardenne)));
        entries.add(new Entry(341, 184, getString(R.string.franchecomt)));
        entries.add(new Entry(222, 108, getString(R.string.ledefrance)));
        entries.add(new Entry(220, 385, getString(R.string.languedocroussillon)));
        entries.add(new Entry(192, 250, getString(R.string.limousin)));
        entries.add(new Entry(335, 102, getString(R.string.lorraine)));
        entries.add(new Entry(135, 89, getString(R.string.lower_normandy)));
        entries.add(new Entry(165, 348, getString(R.string.midipyrnes)));
        entries.add(new Entry(238, 26, getString(R.string.nordpasdecalais)));
        entries.add(new Entry(130, 153, getString(R.string.pays_de_la_loire)));
        entries.add(new Entry(235, 66, getString(R.string.picardy)));
        entries.add(new Entry(139, 221, getString(R.string.poitoucharentes)));
        entries.add(new Entry(347, 354, getString(R.string.provencealpescte_dazur)));
        entries.add(new Entry(315, 262, getString(R.string.rhnealpes)));
        entries.add(new Entry(186, 65, getString(R.string.upper_normandy)));
        entries.add(new Entry(393, 419, getString(R.string.corsica)));
        Level level = new Level(id, name, entries, R.drawable.france, R.drawable.thumb_france, 415, 452);
        return level;
    }

    private Level getLevelMountains(int id) {
        String name = getString(R.string.mountain_ranges);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(714, 239, getString(R.string.himalaya)));
        entries.add(new Entry(503, 178, getString(R.string.alps)));
        entries.add(new Entry(539, 177, getString(R.string.carpathians)));
        entries.add(new Entry(610, 199, getString(R.string.caucasus)));
        entries.add(new Entry(689, 244, getString(R.string.hindukush)));
        entries.add(new Entry(620, 94, getString(R.string.ural)));
        entries.add(new Entry(544, 199, getString(R.string.balkans)));
        entries.add(new Entry(473, 235, getString(R.string.atlas)));
        entries.add(new Entry(157, 195, getString(R.string.rocky_mountains)));
        entries.add(new Entry(291, 371, getString(R.string.andes)));
        entries.add(new Entry(253, 199, getString(R.string.appalachians)));
        entries.add(new Entry(604, 226, getString(R.string.zagros)));
        entries.add(new Entry(583, 331, getString(R.string.kilimanjaro)));

        Level level = new Level(id, name, entries, R.drawable.world2, R.drawable.thumb_world2, 1022, 616);
        return level;
    }

    private Level getLevelGuyanaGuinea(int id) {
        String name = getString(R.string.guyanaguinea);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(452, 303, getString(R.string.guinea)));
        entries.add(new Entry(435, 297, getString(R.string.guineabissau)));
        entries.add(new Entry(509, 335, getString(R.string.equatorial_guinea)));
        entries.add(new Entry(290, 305, getString(R.string.guyana)));
        entries.add(new Entry(295, 304, getString(R.string.suriname_dutch_guiana)));
        entries.add(new Entry(304, 304, getString(R.string.french_guiana)));
        entries.add(new Entry(895, 350, getString(R.string.papua_new_guinea)));

        Level level = new Level(id, name, entries, R.drawable.world2, R.drawable.thumb_world2, 1022, 616);
        return level;
    }

    private String getString(int id) {
        return activity.getString(id);
    }


    private Level getLevelEuropeCountriesAll(int id) {
        String name = getString(R.string.europe_countries_all);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(410, 439, getString(R.string.france)));
        entries.add(new Entry(497, 352, getString(R.string.germany)));
        entries.add(new Entry(377, 345, getString(R.string.england)));
        entries.add(new Entry(605, 339, getString(R.string.poland)));
        entries.add(new Entry(352, 539, getString(R.string.spain)));
        entries.add(new Entry(723, 390, getString(R.string.ukraine)));
        entries.add(new Entry(745, 229, getString(R.string.russia)));
        entries.add(new Entry(667, 454, getString(R.string.romania)));
        entries.add(new Entry(450, 337, getString(R.string.the_netherlands)));
        entries.add(new Entry(438, 367, getString(R.string.belgium)));
        entries.add(new Entry(647, 566, getString(R.string.greece)));
        entries.add(new Entry(550, 389, getString(R.string.czech_republic)));
        entries.add(new Entry(605, 434, getString(R.string.hungary)));
        entries.add(new Entry(290, 550, getString(R.string.portugal)));
        entries.add(new Entry(523, 500, getString(R.string.italy)));
        entries.add(new Entry(622, 480, getString(R.string.serbia)));
        entries.add(new Entry(705, 322, getString(R.string.belarus)));
        entries.add(new Entry(747, 559, getString(R.string.turkey)));
        entries.add(new Entry(312, 296, getString(R.string.northern_ireland)));
        entries.add(new Entry(493, 274, getString(R.string.denmark)));
        entries.add(new Entry(485, 157, getString(R.string.norway)));
        entries.add(new Entry(555, 424, getString(R.string.austria)));
        entries.add(new Entry(677, 509, getString(R.string.bulgaria)));
        entries.add(new Entry(560, 140, getString(R.string.sweden)));
        entries.add(new Entry(682, 122, getString(R.string.finland)));
        entries.add(new Entry(602, 404, getString(R.string.slowakia)));
        entries.add(new Entry(554, 452, getString(R.string.slowenia)));
        entries.add(new Entry(562, 474, getString(R.string.croatia)));
        entries.add(new Entry(478, 439, getString(R.string.switzerland)));
        entries.add(new Entry(345, 345, getString(R.string.wales)));
        entries.add(new Entry(594, 480, getString(R.string.bosnia_and_herzegowina)));
        entries.add(new Entry(607, 501, getString(R.string.montenegro)));
        entries.add(new Entry(182, 69, getString(R.string.island)));
        entries.add(new Entry(612, 526, getString(R.string.albania)));
        entries.add(new Entry(300, 327, getString(R.string.ireland)));
        entries.add(new Entry(340, 257, getString(R.string.scotland)));
        entries.add(new Entry(634, 521, getString(R.string.macedonia)));
        entries.add(new Entry(627, 507, getString(R.string.kosovo)));
        entries.add(new Entry(710, 429, getString(R.string.moldova)));
        entries.add(new Entry(457, 389, getString(R.string.luxembourg)));
        entries.add(new Entry(552, 607, getString(R.string.malta)));
        entries.add(new Entry(760, 621, getString(R.string.cyprus)));
        entries.add(new Entry(645, 284, getString(R.string.lithuania)));
        entries.add(new Entry(684, 253, getString(R.string.latvia)));
        entries.add(new Entry(680, 216, getString(R.string.estonia)));
        Level level = new Level(id, name, entries, R.drawable.europe, R.drawable.thumb_europe, 800, 640);
        return level;
    }

    private Level getLevelEuropeFood(int id) {
        String name = getString(R.string.food_from_europe);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(352, 365, getString(R.string.cheddar_cheese)));
        entries.add(new Entry(498, 323, getString(R.string.hamburg_hamburger)));
        entries.add(new Entry(491, 413, getString(R.string.black_forest_cake)));
        entries.add(new Entry(512, 474, getString(R.string.bologna_bolognese_pasta_sauce)));
        entries.add(new Entry(530, 338, getString(R.string.berlin_berliner_pastry)));
        entries.add(new Entry(576, 416, getString(R.string.vienna_wiener_sausage)));
        entries.add(new Entry(445, 433, getString(R.string.dijon_mustard)));
        entries.add(new Entry(490, 376, getString(R.string.frankfurt_sausage)));
        entries.add(new Entry(448, 332, getString(R.string.edam_edamer_cheese)));
        entries.add(new Entry(518, 445, getString(R.string.san_pellegrino_mineral_water)));
        entries.add(new Entry(550, 401, getString(R.string.budweis_beer)));
        entries.add(new Entry(427, 404, getString(R.string.champagne_sparklig_wine)));
        entries.add(new Entry(468, 439, getString(R.string.emmental_cheese)));
        entries.add(new Entry(419, 401, getString(R.string.brie_cheese)));
        entries.add(new Entry(439, 546, getString(R.string.mahon_mayonnaise)));
        Level level = new Level(id, name, entries, R.drawable.europe, R.drawable.thumb_europe, 800, 640);
        return level;
    }
    
    private Level getLevelMadagascar(int id) {
        String name = getString(R.string.madagascar);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 230,  333, "Antananarivo"));
        entries.add(new Entry( 221,  388, "Antsirabe"));
        entries.add(new Entry( 212,  465, "Fianarantsoa"));
        entries.add(new Entry( 330,  318, "Toamasina"));
        entries.add(new Entry( 184,  184, "Mahajanga"));
        entries.add(new Entry( 78,  545, "Toliary (Tuléar)"));
        entries.add(new Entry( 330,  10, "Antsiranana (Diego-Suarez)"));
        entries.add(new Entry( 106,  395, "Morondava"));
        Level level = new Level(id, name, entries, R.drawable.madagascar, R.drawable.thumb_madagascar, 430, 660);
        return level;
    }
    
    private Level getBiggestDeserts(int id) {
        String name = getString(R.string.largest_deserts);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 511,  275, "Sahara"));
        entries.add(new Entry( 605,  256, getString(R.string.arabian_desert)));
        entries.add(new Entry( 751,  214, getString(R.string.gobi_desert)));
        entries.add(new Entry( 542,  406, getString(R.string.kalahari_desert)));
        entries.add(new Entry( 277,  492, getString(R.string.patagonian_desert)));
        entries.add(new Entry( 840,  414, getString(R.string.great_victoria_desert)));
        entries.add(new Entry( 587,  233, getString(R.string.syrian_desert)));
        entries.add(new Entry( 148,  209, getString(R.string.great_basin_desert)));
        Level level = new Level(id, name, entries, R.drawable.world, R.drawable.thumb_world, 1022, 616);
        return level;
    }

    private Level getGermanIslands(int id) {
        String name = getString(R.string.german_islands);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 86,  405, "Borkum"));
        entries.add(new Entry( 133,  380, "Juist"));
        entries.add(new Entry( 167,  376, "Norderney"));
        entries.add(new Entry( 199,  370, "Baltrum"));
        entries.add(new Entry( 221,  364, "Langeoog"));
        entries.add(new Entry( 255,  361, "Spiekeroog"));
        entries.add(new Entry( 281,  358, "Wangerooge"));
        entries.add(new Entry( 312,  247, "Helgoland"));
        entries.add(new Entry( 364,  122, "Amrum"));
        entries.add(new Entry( 388,  101, "Föhr"));
        entries.add(new Entry( 365,  50, "Sylt"));

        Level level = new Level(id, name, entries, R.drawable.german_north_see, R.drawable.thumb_german_north_see, 600, 515);
        return level;
    }
    
    

    


}