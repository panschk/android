package de.panschk.mapquiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity {

    boolean vibrate;
    boolean sound;
    String mapSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPrefs();
    }

    private void getPrefs() {
        // Get the xml/preferences.xml preferences
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        vibrate = prefs.getBoolean("vibrate", true);
        sound = prefs.getBoolean("sound", true);
        mapSize = prefs.getString("mapsize", "nr1");
    }
}
