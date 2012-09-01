package de.panschk.mapquiz.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import de.panschk.mapquiz.Constants;
import de.panschk.mapquiz.R;

public class HighscoreHelper {
    
    private static String DELIMITER_ENTRY = "p%%i";
    private static String DELIMITER_SCORE = "§t§°";
    
    public static int HIGHSCORE_MAX_ENTRIES = 3;
    public static final String LAST_NAME ="LAST_NAME";
    public static final int BONUS_LEVELS_OFFSET = 500;
    
    
    public static List<HSEntry> getHS(int levelId, Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences(Constants.HIGHSCOREKEY, Context.MODE_PRIVATE);
        String rawScore = prefs.getString(Constants.LEVEL + levelId, "");
        return rawToList(rawScore);
        
    }
    
    
    private static List<HSEntry> rawToList(String rawScore) {
        List<HSEntry> list = new ArrayList<HSEntry>();
        if (rawScore != null && rawScore.contains(DELIMITER_SCORE)) {
            String[] split = rawScore.split(DELIMITER_ENTRY);
            for (String entrystr : split) {
                String[] split2 = entrystr.split(DELIMITER_SCORE);
                String name = split2[0];
                int score = Integer.parseInt(split2[1]);
                HSEntry entry = new HSEntry(name, score);
                list.add(entry);
            }
        }
        return list;
    }
    
    private static void saveHS(List<HSEntry> list, Activity activity, int levelId, String lastName) {
        String toSave = listToRaw(list);
        SharedPreferences prefs = activity.getSharedPreferences(Constants.HIGHSCOREKEY, Context.MODE_PRIVATE);
        Editor editor = prefs.edit();
        editor.putString(Constants.LEVEL + levelId, toSave);
        editor.putString(LAST_NAME, lastName);
        editor.commit();
    }
    
    
    public static boolean madeHSList(int score, int levelId, Activity activity) {
        List<HSEntry> hs = getHS(levelId, activity);
        if (hs.size() < HIGHSCORE_MAX_ENTRIES) {
            return true;
        }
        for (HSEntry hsEntry : hs) {
            if (score > hsEntry.score) {
                return true;
            }
        }
        return false;
    }
    
    
    public static void putHSList(int score, String name, int levelId, Activity activity) {
        List<HSEntry> hs = getHS(levelId, activity);
        HSEntry newEntry = new HSEntry(name, score);
        boolean wasAdded = false;
        for (int i = 0; i < hs.size(); i++) {
            HSEntry hsEntry = hs.get(i);
            if (score > hsEntry.score) {
                hs.add(i, newEntry);
                wasAdded = true;
                break;
            }
        }
        if (!wasAdded) {
            hs.add(newEntry);
        }
        saveHS(hs, activity, levelId, name);
        
        
    }
    
    private static String listToRaw(List<HSEntry> list) {
        String str = "";
        for (int i = 0; i < Math.min(HIGHSCORE_MAX_ENTRIES, list.size()); i++) {
            if (i != 0){
                str+=DELIMITER_ENTRY;
            }
            HSEntry entry = list.get(i);
            str += entry.name+DELIMITER_SCORE+entry.score;
        }
        
        return str;
    }


    public static class HSEntry {
        public String name;
        public int score;
        
        public HSEntry(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
    }
    
    public static String toDisplayString(List<HSEntry> list) {
        String str = "";
        for (int i = 0; i < Math.min(HIGHSCORE_MAX_ENTRIES, list.size()); i++) {
            str+="\n";
            HSEntry entry = list.get(i);
            str += (i+1)+".) "+entry.name+" ( "+ entry.score + " ) ";
            
        }
        
        return str;
    }
    

    public static Dialog createHighscoreDialog(int id, final Activity activity, final boolean closeActivity) {
        int levelId = id - Constants.ID_OFFSET_HIGHSCORE;
        List<HSEntry> highscore = HighscoreHelper.getHS(levelId, activity);
        String hsString;
        if (highscore == null || highscore.size() ==0) {
            hsString ="\n "+"no one yet";
        } else {
            hsString = HighscoreHelper.toDisplayString(highscore);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setMessage(
                activity.getString(R.string.highscore)+hsString)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (closeActivity) {
                                    activity.finish();
                                }
                            }
                        });
        AlertDialog alert = builder.create();
        return alert;
    }
    
    
    public static String getLastName(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences(Constants.HIGHSCOREKEY, Context.MODE_PRIVATE);
        String name = prefs.getString(LAST_NAME, "player_name");
        return name;
    }

}
