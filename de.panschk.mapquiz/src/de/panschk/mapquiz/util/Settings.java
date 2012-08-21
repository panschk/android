package de.panschk.mapquiz.util;

import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import de.panschk.mapquiz.R;

/**
 * @author Shriram Shri Shrikumar
 * @author panschk
 * 
 *         This class stores and manages all the preferences for the
 *         application.
 * 
 */
public class Settings {

    public static final String LANGUAGE_DEFAULT = "default";
    public static final String DIFFICULTY_DEFAULT = "medium";

    private final SharedPreferences settings;
    private Context app;

    /**
     * @param act
     *            The context from which to pick SharedPreferences
     */
    public Settings(Context app) {
        this.app = app;
        settings = PreferenceManager.getDefaultSharedPreferences(app);
    }

    /**
     * @return volume 0 to 10
     */
    public int getVolume() {
        return settings.getInt(getString(R.string._volume), 5);
    }

    public boolean getSoundEnabled() {
        return settings.getBoolean(getString(R.string._sound), true);
    }

    public boolean getVibrateEnabled() {
        return settings.getBoolean(getString(R.string._vibrate), true);
    }

    public String getLanguage() {
        return settings.getString(getString(R.string._language),
                LANGUAGE_DEFAULT);
    }

//    public ImageSize getImageSize() {
//        String val = settings.getString(getString(R.string._image_size_key),
//                getString(R.string._image_size_device));
//
//        if (getString(R.string._image_size_small).equals(val)) {
//            return ImageSize.SMALL;
//        }
//        if (getString(R.string._image_size_normal).equals(val)) {
//            return ImageSize.MEDIUM;
//        }
//        if (getString(R.string._image_size_large).equals(val)) {
//            return ImageSize.LARGE;
//        }
//
//        return ImageSize.DEVICE;
//
//    }

    public Difficulty getDifficulty() {
        String diffStr = settings.getString(getString(R.string._difficulty),
                DIFFICULTY_DEFAULT);
        if (getString(R.string._difficulty_easy).equalsIgnoreCase(diffStr)) {
            return Difficulty.EASY;
        }
        if (getString(R.string._difficulty_hard).equalsIgnoreCase(diffStr)) {
            return Difficulty.HARD;
        }
        if (getString(R.string._difficulty_extreme).equalsIgnoreCase(diffStr)) {
            return Difficulty.EXTREME;
        }
        return Difficulty.MEDIUM;
        
    }

    private Resources getResource() {
        return app.getResources();
    }

    private String getString(int id) {
        return getResource().getString(id);
    }



//    public void adjustDrawableConfig() {
//        Configuration conf = app.getResources().getConfiguration();
//        ImageSize imageSize = getImageSize();
//        int valueToAdd = 0;
//
//        switch (imageSize) {
//        case LARGE:
//            valueToAdd = Configuration.SCREENLAYOUT_SIZE_LARGE;
//            break;
//        case MEDIUM:
//            valueToAdd = Configuration.SCREENLAYOUT_SIZE_NORMAL;
//            break;
//        case SMALL:
//            valueToAdd = Configuration.SCREENLAYOUT_SIZE_SMALL;
//            break;
//        default:
//            valueToAdd = 0;
//            break;
//        }
//        if (imageSize != ImageSize.DEVICE) {
//            int toSubstract = 0;
//            boolean wasLarge = (conf.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE;
//            boolean wasNormal = (conf.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL;
//            boolean wasSmall = (conf.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL;
//
//            if (wasLarge) {
//                toSubstract = Configuration.SCREENLAYOUT_SIZE_LARGE;
//            } else if (wasNormal) {
//                toSubstract = Configuration.SCREENLAYOUT_SIZE_NORMAL;
//            } else if (wasSmall) {
//                toSubstract = Configuration.SCREENLAYOUT_SIZE_SMALL;
//            }
//
//            conf.screenLayout = conf.screenLayout - toSubstract + valueToAdd;
//            app.getResources().updateConfiguration(conf,
//                    app.getResources().getDisplayMetrics());
//
//        }
//    }

    public void adjustLanguageConfig() {
        String language = getLanguage();
        if (language != null && language.length() > 0
                && !getString(R.string._language_default).equals(language)) {
            Resources res = app.getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = app.getResources().getConfiguration();
            conf.locale = new Locale(language.toLowerCase());
            res.updateConfiguration(conf, dm);

        }

    }
    
    public static enum ImageSize {
        DEVICE, SMALL, MEDIUM, LARGE
    }
    
    public static enum Difficulty {
        EASY, MEDIUM, HARD, EXTREME
    }

}