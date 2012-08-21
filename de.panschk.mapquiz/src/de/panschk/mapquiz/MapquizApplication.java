package de.panschk.mapquiz;

import android.app.Application;
import de.panschk.mapquiz.util.Settings;

public class MapquizApplication extends Application {
 
    private Settings settings;
 
    @Override
    public void onCreate() {
        settings = new Settings(this);
 
    }
 
    public Settings getSettings() {
        return settings;
    }
 
}