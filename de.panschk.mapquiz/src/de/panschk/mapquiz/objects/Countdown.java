package de.panschk.mapquiz.objects;

public class Countdown {
    
    public long startTime;
    public int durationMillis = 5000;

    public Countdown(long currentTime) {
        this.startTime = currentTime;
    }
    
    
    public long getTimeLeft() {
        long currentTimeMillis = System.currentTimeMillis();
        return startTime + durationMillis - currentTimeMillis;
    }

}
