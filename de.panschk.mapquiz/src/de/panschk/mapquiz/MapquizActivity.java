package de.panschk.mapquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.panschk.mapquiz.R;
import de.panschk.mapquiz.util.Settings;

public class MapquizActivity extends Activity {

    protected static final int ABOUT_DIALOG = 0;
    private Settings settings;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapquizApplication app = (MapquizApplication) this
                .getApplicationContext();
        settings = app.getSettings();
        settings.adjustLanguageConfig();
        setContentView(R.layout.main);
        setListeners();
    }

    private void setListeners() {
        getStartButton().setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(MapquizActivity.this,
                        LevelSelectActivity.class);
                startActivity(i);

            }
        });
        getSettingsButton().setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(MapquizActivity.this,
                        SettingsActivity.class);
                startActivity(i);

            }
        });
        getAboutButton().setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                showDialog(ABOUT_DIALOG);

            }
        });
    }

    public Button getStartButton() {
        return (Button) findViewById(R.id.startGame);
    }

    public Button getSettingsButton() {
        return (Button) findViewById(R.id.settings);
    }

    public Button getAboutButton() {
        return (Button) findViewById(R.id.about);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == ABOUT_DIALOG) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String message = "I hope you enjoy this little game!"+ "\n"+
                        "Credits: "+"\n"+
                        "Concept, implementation and \"art\" by panschk." + "\n"+
                        "Source code public at: " + "\n"+
                        "https://github.com/panschk/android" + "\n" +
                        "Sound effects shamelessly copied from: \n" +
                        "sad-trombone: http://www.freesound.org/people/Benboncan/sounds/73581/ \n"+
                        "whistle: http://www.freesound.org/people/chaosportal/sounds/137106/ \n"+
                        "wrong: http://www.freesound.org/people/Autistic%20Lucario/sounds/142608/\n"+
                        "right: http://www.freesound.org/people/lukechalaudio/sounds/151568/\n"+
                        "You can send me feedback at panschk@googlemail.com" + "\n";
                    
            builder.setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int id) {
                                }
                            });

            AlertDialog alert = builder.create();
            return alert;
        }
        return null;
    }
}