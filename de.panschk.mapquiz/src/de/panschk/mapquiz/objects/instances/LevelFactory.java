package de.panschk.mapquiz.objects.instances;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import de.panschk.mapquiz.R;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;

public class LevelFactory {
    
    public static final int LEVEL_EUROPE_COUNTRIES = 1;
    public static final int LEVEL_SOUTH_AFRICA_COUNTRIES = 2;
    private Activity activity;
    
    
    
    public LevelFactory(Activity activity) {
        this.activity = activity;
        
    }
    
    public Level getLevel(int levelId) {
        switch (levelId) {
        case LEVEL_EUROPE_COUNTRIES:
            return getLevelEuropeCountries();
        case LEVEL_SOUTH_AFRICA_COUNTRIES:
            return getSouthAfricaCountries();
        default:
            break;
        }
        
        return null;
        
    }

    private Level getSouthAfricaCountries() {
        String name = "Africa(south)";
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 502, 857, "South Africa"));
        entries.add(new Entry( 1017, 850, "Madagascar"));
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

    private Level getLevelEuropeCountries() {

        String name = getString(R.string.europe);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry( 410, 439, getString(R.string.france)));
        entries.add(new Entry( 497, 352, getString(R.string.germany)));
        entries.add(new Entry( 377, 345, getString(R.string.england)));
        entries.add(new Entry( 605, 339, getString(R.string.poland)));
        entries.add(new Entry( 352, 539, getString(R.string.spain)));
        entries.add(new Entry( 182, 69,  getString(R.string.island)));
        entries.add(new Entry( 312, 296, getString(R.string.north_ireland)));
        entries.add(new Entry( 300, 327, getString(R.string.ireland)));
        entries.add(new Entry( 340, 257, getString(R.string.scotland)));
        entries.add(new Entry( 345, 345, getString(R.string.wales)));
        entries.add(new Entry( 290, 550, getString(R.string.portugal)));
        entries.add(new Entry( 523, 500, getString(R.string.italy)));
        entries.add(new Entry( 478, 439, getString(R.string.switzerland)));
        entries.add(new Entry( 457, 389, getString(R.string.luxembourg)));
        entries.add(new Entry( 438, 367, getString(R.string.belgium)));
        entries.add(new Entry( 450, 337, getString(R.string.the_netherlands)));
        entries.add(new Entry( 493, 274, getString(R.string.denmark)));
        entries.add(new Entry( 485, 157, getString(R.string.norway)));
        entries.add(new Entry( 560, 140, getString(R.string.sweden)));
        entries.add(new Entry( 682, 122, getString(R.string.finland)));
        entries.add(new Entry( 555, 424, getString(R.string.austria)));
        entries.add(new Entry( 550, 389, getString(R.string.czech_republic)));
        entries.add(new Entry( 602, 404, getString(R.string.slowakia)));
        entries.add(new Entry( 605, 434, getString(R.string.hungary)));
        entries.add(new Entry( 554, 452, getString(R.string.slowenia)));
        entries.add(new Entry( 562, 474, getString(R.string.croatia)));
        entries.add(new Entry( 594, 480, getString(R.string.bosnia_and_herzegowina)));
        entries.add(new Entry( 622, 480, getString(R.string.serbia)));
        entries.add(new Entry( 607, 501, getString(R.string.montenegro)));
        entries.add(new Entry( 612, 526, getString(R.string.albania)));
        entries.add(new Entry( 647, 566, getString(R.string.greece)));
        entries.add(new Entry( 634, 521, getString(R.string.macedonia)));
        entries.add(new Entry( 627, 507, getString(R.string.kosovo)));
        entries.add(new Entry( 677, 509, getString(R.string.bulgaria)));
        entries.add(new Entry( 667, 454, getString(R.string.romania)));
        entries.add(new Entry( 710, 429, getString(R.string.moldova)));
        entries.add(new Entry( 723, 390, getString(R.string.ukraine)));
        entries.add(new Entry( 705, 322, getString(R.string.belarus)));        
        entries.add(new Entry( 552, 607, getString(R.string.malta)));        
        entries.add(new Entry( 747, 559, getString(R.string.turkey)));        
        entries.add(new Entry( 760, 621, getString(R.string.cyprus)));        
        entries.add(new Entry( 645, 284, getString(R.string.lithuania)));        
        entries.add(new Entry( 684, 253, getString(R.string.latvia)));        
        entries.add(new Entry( 680, 216, getString(R.string.estonia)));        
        entries.add(new Entry( 745, 229, getString(R.string.russia)));        
        
        Level level = new Level(name, entries, R.drawable.europe, 800, 640);
        return level;
    }
    
    
    private String getString(int id) {
        return activity.getResources().getString(id);
    }

}
