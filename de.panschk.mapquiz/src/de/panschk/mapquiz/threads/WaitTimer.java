package de.panschk.mapquiz.threads;

import android.os.AsyncTask;
import de.panschk.mapquiz.MapActivity;

public class WaitTimer extends AsyncTask<MapActivity, Void, MapActivity> {

    protected MapActivity doInBackground(MapActivity... params) {
        try {
            wait (100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return params[0];
    }
    
    protected void onPostExecute(MapActivity result) {
        super.onPostExecute(result);
        result.drawTimer();
    }

}
