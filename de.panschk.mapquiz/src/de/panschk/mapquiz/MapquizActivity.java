package de.panschk.mapquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.panschk.mapquiz.R;
import de.panschk.mapquiz.util.Settings;

public class MapquizActivity extends Activity {

    private Settings settings;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapquizApplication app = (MapquizApplication) this
                .getApplicationContext();
        settings = app.getSettings();
        settings.adjustLanguageConfig();
        settings.adjustDrawableConfig();
        setContentView(R.layout.main);
        setListeners();
    }

    private void setListeners() {
        getStartButton().setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(MapquizActivity.this,
                        LevelSelectActivity.class);
                startActivity(i);

            }
        });
        getSettingsButton().setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(MapquizActivity.this,
                        SettingsActivity.class);
                startActivity(i);

            }
        });
    }

    public Button getStartButton() {
        return (Button) findViewById(R.id.startGame);
    }

    public Button getSettingsButton() {
        return (Button) findViewById(R.id.settings);
    }

}