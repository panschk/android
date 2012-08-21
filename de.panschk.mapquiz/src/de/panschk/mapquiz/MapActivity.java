package de.panschk.mapquiz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.InputType;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import de.panschk.mapquiz.objects.Countdown;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Hint;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactory;
import de.panschk.mapquiz.objects.instances.LevelFactory.LevelEnum;
import de.panschk.mapquiz.util.HighscoreHelper;
import de.panschk.mapquiz.util.Settings;
import de.panschk.mapquiz.util.Settings.Difficulty;

public class MapActivity extends Activity {

    public static final int DIALOG_FAILED = 1;
    public static final int DIALOG_WON = 2;
    public static final int DIALOG_MADE_HIGHSCORE = 5;
    
    private int lives = 0;
    private int mistakes = 0;
    private Level level;

    public Sound sound;
    public Settings settings;
    private Difficulty difficulty;

    public Hint hint;
    public Countdown countdown;
    
    public long startTime;
    
    
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            MapActivity.this.drawTimer();
        };
    };
    private Integer levelId;
    private int score;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sound = new Sound(this);
        MapquizApplication app = (MapquizApplication) this
                .getApplicationContext();

        settings = app.getSettings();
        settings.adjustDrawableConfig();
        settings.adjustLanguageConfig();

        initGame();
        setContentView(R.layout.maplayout);
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
        case DIALOG_MADE_HIGHSCORE:
            return createMadeHSDialog();
        default:
            if (id >= Constants.ID_OFFSET_HIGHSCORE) {
                return HighscoreHelper.createHighscoreDialog(id, this, true);
            }
            return null;
        }
    }

    private Dialog createWonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(
                getString(R.string.good_job_you_solved_the_level_) + level.name
                        + "!")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
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
    
    private Dialog createMadeHSDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT );
        input.setText(HighscoreHelper.getLastName(this));
        builder.setView(input);
        builder.setMessage(getString(R.string.you_made_the_highscore_list_enter_your_name_));
        builder.setCancelable(false)
        .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                HighscoreHelper.putHSList(score, input.getText().toString(), levelId, MapActivity.this);
                                Intent i = new Intent(MapActivity.this,
                                        LevelSelectActivity.class);
                                startActivity(i);
                                MapActivity.this.finish();
                            }
                        });
        builder.setNeutralButton("Show Highscore List",  new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                HighscoreHelper.putHSList(score, input.getText().toString(), levelId, MapActivity.this);
                                showDialog(Constants.ID_OFFSET_HIGHSCORE + levelId);
                                
                            }
                        });

        AlertDialog alert = builder.create();
        return alert;
    }


    private Dialog createFailedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(
                getResources().getString(R.string.level_failed_retry_))
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(MapActivity.this,
                                        MapActivity.class);
                                i.putExtra(Constants.LEVEL_KEY, level.levelId);
                                startActivity(i);
                                MapActivity.this.finish();
                            }
                        })
                .setNegativeButton(android.R.string.no,
                        new DialogInterface.OnClickListener() {
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
        levelId =(Integer) levelKey;
        this.level = levels.getLevel(LevelEnum.values()[levelId]);
        this.difficulty = settings.getDifficulty();
        if (difficulty == Difficulty.EASY) {
            lives = 5;
        } else if (difficulty == Difficulty.MEDIUM) {
            lives = 3;
        } else if (difficulty == Difficulty.HARD) {
            lives = 1;
        } else if (difficulty == Difficulty.EXTREME) {
            lives = 0;
        }

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
        String name ="panschk_test";
        score = calculateScore();
        if (HighscoreHelper.madeHSList(score, levelId, this)) {
            showDialog(DIALOG_MADE_HIGHSCORE);
        } else {
            showDialog(DIALOG_WON);
        }
    }

    private int calculateScore() {
        
        long duration = System.currentTimeMillis() - startTime;
        
        int timeScore = 40000 / (((int)(duration +1)/1000) + 1);
        
        int mistakeScore = (5 - mistakes) * 200;
        return timeScore + mistakeScore;
    }

    public void removeLife() {
        mistakes++;
        lives--;
        if (settings.getVibrateEnabled()) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 300 milliseconds
            v.vibrate(new long[] { 0, 100, 50, 100 }, -1);
        }
        if (lives < 0) {
            sound.playSound(Sound.FAIL);
            countdown = null;
            showDialog(DIALOG_FAILED);
        } else {
            sound.playSound(Sound.WRONG);

            if (difficulty == Difficulty.EASY) {
                this.hint = new Hint(level.entriesToDo.get(0),
                        System.currentTimeMillis());
            }

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
        if (difficulty == Difficulty.EXTREME && lives >= 0) {
            this.countdown = new Countdown(System.currentTimeMillis());
        }

    }

    public void drawTimer() {
        TextView timerText = (TextView) findViewById(R.id.timeText);
        if (timerText != null && countdown != null) {
            int time = (int) countdown.getTimeLeft();
            if (time < 0) {
                sound.playSound(Sound.FAIL);
                countdown = null;
                showDialog(DIALOG_FAILED);
            } else {
                float time2 = (time/100) / 10.0f;
                timerText.setText(time2 + " s");
            }
        }

    }

    public void onFirstDraw() {
        startTime = System.currentTimeMillis();
        drawQuestion();
        drawLives();
        // create a thread for updating the timer
        Thread background = new Thread(new Runnable() {
            public void run() {
                try {
                    while (!MapActivity.this.isFinishing()) {
                        Thread.sleep(100);
                        handler.sendMessage(handler.obtainMessage());
                        if (MapActivity.this.countdown != null && MapActivity.this.countdown.getTimeLeft() < 0) {
                            return;
                        }
                    }
                }
                catch (Throwable t) {
                }
            }
        });
        background.start();
    }

}
