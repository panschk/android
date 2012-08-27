package de.panschk.mapquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import de.panschk.mapquiz.util.Settings;

public class SettingsActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {

    boolean vibrate;
    boolean sound;
    String mapSize;
    private MapquizApplication app;

    @Override
    protected void onDestroy() {
        super.onPause();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(app);
        defaultSharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPrefs();
        app = (MapquizApplication) this.getApplicationContext();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(app);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        Settings settings = app.getSettings();
        settings.adjustLanguageConfig();
        addPreferencesFromResource(R.xml.preferences);

    }

    private void getPrefs() {
        // Get the xml/preferences.xml preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        vibrate = prefs.getBoolean("vibrate", true);
        sound = prefs.getBoolean("sound", true);
        mapSize = prefs.getString("mapsize", "nr1");
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if ((getString(R.string._language)).equalsIgnoreCase(key)) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            this.finish();
        }
    }

}
