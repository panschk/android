package de.panschk.mapquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactory;

public class MapActivity extends Activity {

    private int lives = 3;
    private Level level;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }

    private void initGame() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Object levelKey = extras.get(Constants.LEVEL_KEY);
        LevelFactory levels = new LevelFactory(this);
        this.level = levels.getLevel((Integer) levelKey);


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
            return true;
        } else {
            return false;
        }
    }

    public void nextLevel() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Good job!")
                .setCancelable(false)
                .setPositiveButton("Next Level!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MapActivity.this.finish();
                            }
                        });
        AlertDialog alert = builder.create();

    }

    public void errorMsg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This was not " + level.entriesToDo.get(0).name)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MapActivity.this.finish();
                    }
                });
        AlertDialog alert = builder.create();

    }

    public void setText(Entry newEntry) {
        TextView questionText = (TextView) findViewById(R.id.questionText);
        if (questionText != null) {
            String prefix = getResources().getString(R.string.clickinstruction);
            questionText.setText(prefix + newEntry.name);
        }

    }

    public void removeLife() {
        lives--;
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

}
