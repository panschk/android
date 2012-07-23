package de.panschk;

import de.panschk.mapquiz.R;
import android.app.Activity;
import android.os.Bundle;

public class MapActivity extends Activity{
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.europe);
        setListeners();
    }

	private void setListeners() {
		// TODO Auto-generated method stub
		
	}


}
