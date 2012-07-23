package de.panschk;

import de.panschk.mapquiz.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapquizActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setListeners();
    }
    
    private void setListeners() {
		getStartButton().setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent i = new Intent(MapquizActivity.this, MapActivity.class);
				startActivity(i);
				
			}
		});
	}
	
	public Button getStartButton() {
		return (Button) findViewById(R.id.startGame);

	}
}