package de.panschk.mapquiz.threads;

import de.panschk.mapquiz.MapActivity;
import de.panschk.mapquiz.objects.Countdown;
import android.os.Handler;
import android.os.Message;

public class ThreadHandler extends Handler {
    
    private MapActivity activity;
    private Countdown countdown;

    public ThreadHandler(MapActivity activity, Countdown countdown) {
        this.activity = activity;
        this.countdown = countdown;
        
    }

    public void handleMessage(Message msg) {
        int timeLeft = (int) countdown.getTimeLeft();
//        activity.drawTimer(timeLeft);

    }
}
