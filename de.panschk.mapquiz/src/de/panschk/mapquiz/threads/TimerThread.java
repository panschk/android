package de.panschk.mapquiz.threads;

import de.panschk.mapquiz.MapActivity;
import de.panschk.mapquiz.objects.Countdown;

public class TimerThread implements Runnable {

    public Countdown countdown;
    private ThreadHandler handler;


    public TimerThread(Countdown countdown, MapActivity activity) {
        this.countdown = countdown;
        this.handler = new ThreadHandler(activity, countdown);

    }

    public void run() {
        try {
            int timeLeft = (int) countdown.getTimeLeft();
            
            while (timeLeft > 0) {
                handler.sendEmptyMessage(timeLeft);
                this.wait(100);
            }
            
            handler.sendEmptyMessage(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    
    public static TimerThread startTimer(MapActivity activity) {
        Countdown countdown = new Countdown(System.currentTimeMillis());
        TimerThread thread = new TimerThread(countdown, activity);
        new Thread(thread).start();
        return thread;
    }

}
