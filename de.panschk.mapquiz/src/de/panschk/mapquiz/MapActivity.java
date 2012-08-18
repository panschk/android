package de.panschk.mapquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactory;
import de.panschk.mapquiz.objects.instances.LevelFactory.LevelEnum;

public class MapActivity extends Activity {

    public static final int DIALOG_FAILED = 1;
    public static final int DIALOG_WON = 2;
    
    private int lives = 3;
    private Level level;

    public Sound sound;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sound = new Sound(this);
        initGame();
        setContentView(R.layout.maplayout);
        Button mainMenu = (Button) findViewById(R.id.buttonMainMenu);
        mainMenu.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(MapActivity.this,
                        LevelSelectActivity.class);
                startActivity(i);

            }
        });
        MapView mapView = (MapView) findViewById(R.id.mapView);

        LayoutParams layoutParams = mapView.getLayoutParams();
        layoutParams.height = mapView.height;
        layoutParams.width = mapView.width;
        mapView.setLayoutParams(layoutParams);
        
        RelativeLayout container = (RelativeLayout) findViewById(R.id.scene_container);
        layoutParams = container.getLayoutParams();
        layoutParams.height = mapView.height;
        layoutParams.width = mapView.width;
        container.setLayoutParams(layoutParams);

    }
    
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DIALOG_FAILED:
            return createFailedDialog();
        case DIALOG_WON:
            return createWonDialog();
        default:
            return null;
        }
    }

    private Dialog createWonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.good_job_you_solved_the_level_+level.name+"!")
               .setCancelable(false)
               .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       Intent i = new Intent(MapActivity.this,
                               LevelSelectActivity.class);
                       startActivity(i);
                       MapActivity.this.finish();
                   }
               });
               
        AlertDialog alert = builder.create();
        return alert;
    }

    private Dialog createFailedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.level_failed_retry_))
               .setCancelable(false)
               .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       Intent i = new Intent(MapActivity.this,
                               MapActivity.class);
                       i.putExtra(Constants.LEVEL_KEY, level.levelId);
                       startActivity(i);
                       MapActivity.this.finish();
                   }
               })
               .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       MapActivity.this.finish();
                   }
               });
        AlertDialog alert = builder.create();
        return alert;
    }

    private void initGame() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Object levelKey = extras.get(Constants.LEVEL_KEY);
        LevelFactory levels = new LevelFactory(this);
        this.level = levels.getLevel(LevelEnum.values()[(Integer) levelKey]);

    }

    public Level getLevel() {
        return level;
    }

    public boolean nextEntry() {
        final TextView scoreText = (TextView) findViewById(R.id.scoreText);
        if (scoreText != null) {
            AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setAnimationListener(new AnimationListener() {

                public void onAnimationStart(Animation animation) {
                    scoreText.setBackgroundColor(Color.argb(255, 0, 255, 0));

                }

                public void onAnimationRepeat(Animation animation) {
                    // TODO Auto-generated method stub

                }

                public void onAnimationEnd(Animation animation) {
                    scoreText.setBackgroundColor(Color.BLACK);

                }
            });
            animation.setDuration(400);
            scoreText.setAnimation(animation);

        }
        if (level.entriesToDo.size() > 0) {
            Entry removed = level.entriesToDo.remove(0);
            level.entriesDone.add(removed);
        }
        if (level.entriesToDo.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void nextLevel() {
       showDialog(DIALOG_WON);
    }

    public void removeLife() {
        lives--;
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 300 milliseconds
        v.vibrate(new long[]{0, 100, 50, 100}, -1);
        if (lives < 0 ) {
            sound.playSound(Sound.FAIL);
            showDialog(DIALOG_FAILED);
        } else {
            sound.playSound(Sound.WRONG);
            final TextView livesText = (TextView) findViewById(R.id.livesText);
            if (livesText != null) {
                AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setAnimationListener(new AnimationListener() {
    
                    public void onAnimationStart(Animation animation) {
                        livesText.setBackgroundColor(Color.WHITE);
    
                    }
    
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub
    
                    }
    
                    public void onAnimationEnd(Animation animation) {
                        livesText.setBackgroundColor(Color.BLACK);
    
                    }
                });
                animation.setDuration(600);
                livesText.setAnimation(animation);
    
            }
            drawLives();
            Entry toSwitch = level.entriesToDo.remove(0);
            level.entriesToDo.add(toSwitch);
            drawQuestion();
            
        }
    }

    public void drawLives() {
        String str = "";
        int i = 0;
        while (i < lives) {
            str += getResources().getString(R.string.heart);
            i++;
        }
        TextView livesText = (TextView) findViewById(R.id.livesText);
        if (livesText != null) {
            livesText.setText(str);
        }
    }

    public void addLife() {
        lives++;
        drawLives();
    }

    public void drawScore() {

        TextView scoreText = (TextView) findViewById(R.id.scoreText);
        if (scoreText != null) {
            scoreText.setText(level.entriesDone.size() + "/"
                    + level.getTotalEntries());
        }
    }
    
    public void drawQuestion() {
        Entry newEntry = level.entriesToDo.get(0);
        TextView questionText = (TextView) findViewById(R.id.questionText);
        if (questionText != null) {
            String prefix = getResources().getString(R.string.clickinstruction);
            questionText.setText(prefix + newEntry.name);
        }
    }

}
