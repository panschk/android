package de.panschk.mapquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.panschk.mapquiz.objects.instances.LevelFactory;

public class LevelSelectActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_level_select, menu);
        return true;
    }

    private void setListeners() {
        addListener(R.id.level_europe_countries,
                LevelFactory.LEVEL_EUROPE_COUNTRIES);
        addListener(R.id.level_south_africa_countries,
                LevelFactory.LEVEL_SOUTH_AFRICA_COUNTRIES);
        

    }

    private void addListener(final int buttonId, final int id) {
        Button b = (Button) findViewById(buttonId);
        b.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(LevelSelectActivity.this,
                        MapActivity.class);
                i.putExtra(Constants.LEVEL_KEY, id);
                startActivity(i);

            }
        });

    }
}
