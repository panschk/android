package de.panschk.mapquiz;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;
import android.util.SparseIntArray;

public class Sound {

    public static int WIN = 0;
    public static int FAIL = 1;
    public static int RIGHT = 2;
    public static int WRONG = 3;
    
    
    private SparseIntArray idMap = new SparseIntArray();
    
    private SoundPool soundPool;
    boolean loaded = false;
    private Activity activity;

    /** Called when the activity is first created. */
    
    public Sound(Activity activity) {
        this.activity = activity;
        onCreate();
    }

    public void onCreate() {
        // Set the hardware buttons to control the music
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                    int status) {
                loaded = true;
            }
        });
        int soundID = soundPool.load(activity, R.raw.sad_trombone, 1);
        idMap.put(FAIL, soundID);
        soundID = soundPool.load(activity, R.raw.whistle, 1);
        idMap.put(WIN, soundID);
        soundID = soundPool.load(activity, R.raw.right, 1);
        idMap.put(RIGHT, soundID);
        soundID = soundPool.load(activity, R.raw.wrong, 1);
        idMap.put(WRONG, soundID);
        

    }

    public void playSound(int soundId) {
        if (loaded) {
            // Getting the user sound settings
        AudioManager audioManager = (AudioManager) activity
                .getSystemService(Activity.AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        int idToPlay = idMap.get(soundId);
            soundPool.play(idToPlay, volume, volume, 1, 0, 1f);
            Log.d("Test", "Played sound");
        }
    }
}
