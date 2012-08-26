package de.panschk.mapquiz.util;

import de.panschk.mapquiz.R;
import android.app.Activity;

public class DisplayStringHelper {
    
    public static String getRndCorrectSolutionString(Activity activity) {
        int rnd = (int) (Math.random()*18);
        
        switch (rnd) {
        case 0:
            return activity.getString(R.string.correct);
        case 1:
            return activity.getString(R.string.excellent_);
        case 2:
            return activity.getString(R.string.that_s_right_);
        case 3:
            return activity.getString(R.string.well_guessed_);
        case 4:
            return activity.getString(R.string.that_s_it);
        case 5:
            return activity.getString(R.string.right_);
        case 6:
            return activity.getString(R.string.correct_answer);
        case 7:
            return activity.getString(R.string.magnificient_);
        case 8:
            return activity.getString(R.string.yes_right);
        case 9:
            return activity.getString(R.string.that_was_too_easy_right_);
        case 10:
            return activity.getString(R.string.well_done_);
        default:
            return activity.getString(R.string.correct);

        }
        
    }
    

}
