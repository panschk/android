package de.panschk.mapquiz.objects;


public class Hint {

    
    
    public long creationTime;
    public Entry entry;
    public boolean hasBeenShown = false;
    
    public Hint(Entry entry, long creationTime) {
        super();
        this.entry = entry;
        this.creationTime = creationTime;
    }
    
       
    public long getTTL() {
        final int LIVE_MILLISEC = 2000;
        long currentTime = System.currentTimeMillis();
        return creationTime + LIVE_MILLISEC - currentTime; 

    }
    
    
    

}
