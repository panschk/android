package de.panschk.mapquiz;

import java.lang.ref.WeakReference;

import us.gorges.viewaclue.TwoDScrollView;
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
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import de.panschk.mapquiz.gui.OptionsDialog;
import de.panschk.mapquiz.objects.Countdown;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.GameState;
import de.panschk.mapquiz.objects.Hint;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactory;
import de.panschk.mapquiz.objects.instances.LevelFactory.LevelEnum;
import de.panschk.mapquiz.objects.instances.LevelFactoryBonus;
import de.panschk.mapquiz.objects.instances.LevelFactoryBonus.LevelEnumBonus;
import de.panschk.mapquiz.util.DisplayStringHelper;
import de.panschk.mapquiz.util.HighscoreHelper;
import de.panschk.mapquiz.util.Settings;
import de.panschk.mapquiz.util.Settings.Difficulty;

public class MapActivity extends Activity {
    
    public GameState state;

    public static final int DIALOG_FAILED = 1;
    public static final int DIALOG_WON = 2;
    public static final int DIALOG_OPTIONS = 3;
    public static final int DIALOG_RIGHT = 4;
    public static final int DIALOG_WRONG = 5;
    public static final int DIALOG_MADE_HIGHSCORE = 6;
    
    
    public Sound sound;
    public Settings settings;

    
    
    
    MAHandler handler=new MAHandler(this);

    private MapView mapView;
    
    static class MAHandler extends Handler {
        WeakReference<MapActivity> wrActivity;
        public MAHandler (MapActivity m) {
            super();
            wrActivity = new WeakReference<MapActivity>(m);
        }
        @Override
        public void handleMessage(Message msg) {
            if (wrActivity != null && wrActivity.get()!=null) {
                wrActivity.get().drawTimer();
            }
        };
    }


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance(); 
        


        sound = new Sound(this);
        MapquizApplication app = (MapquizApplication) this
                .getApplicationContext();

        settings = app.getSettings();
        settings.adjustLanguageConfig();
        if (lastNonConfigurationInstance instanceof GameState) {
            this.state =  (GameState) lastNonConfigurationInstance;
        } else {
            initGame();
        }
        setContentView(R.layout.maplayout);
        
        ImageButton optionsButton = (ImageButton) findViewById(R.id.optionsButton);
        optionsButton.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
                showDialog(DIALOG_OPTIONS);
                
            }
        });
        
        mapView = (MapView) findViewById(R.id.mapView);

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
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            showDialog(DIALOG_OPTIONS);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        
        switch (id) {
        case DIALOG_RIGHT:
            ((AlertDialog) dialog).setMessage(DisplayStringHelper.getRndCorrectSolutionString(this));
            break;
        case DIALOG_WRONG:
            ((AlertDialog) dialog).setMessage(getString(R.string.wrong_)+ getString(R.string.you_clicked_on_)+state.lastWrongGuess.name+".");
            break;

        default:
            break;
        }
        
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DIALOG_FAILED:
            return createFailedDialog();
        case DIALOG_WON:
            return createWonDialog();
        case DIALOG_MADE_HIGHSCORE:
            return createMadeHSDialog();
        case DIALOG_OPTIONS:
            return createOptionsDialog();
        case DIALOG_WRONG:
            return createGuessWrongDialog();
        case DIALOG_RIGHT:
            return createGuessRightDialog();
                
        default:
            if (id >= Constants.ID_OFFSET_HIGHSCORE) {
                return HighscoreHelper.createHighscoreDialog(id, this, true);
            }
            return null;
        }
    }

    private Dialog createGuessRightDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(DisplayStringHelper.getRndCorrectSolutionString(this))
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });

        AlertDialog alert = builder.create();
        return alert;
    }

    private Dialog createGuessWrongDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.wrong_+ R.string.you_clicked_on_+state.lastWrongGuess.name+".")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });

        AlertDialog alert = builder.create();
        return alert;
    }

    private Dialog createOptionsDialog() {
        return new OptionsDialog(this);
        
    }

    private Dialog createWonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(
                getString(R.string.good_job_you_solved_the_level_) + state.level.name
                        + "!")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
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
                                int offset;
                                if (state.isBonus) {
                                    offset = HighscoreHelper.BONUS_LEVELS_OFFSET;
                                } else {
                                    offset = 0;
                                }
                                HighscoreHelper.putHSList(state.score, input.getText().toString(), state.levelId + offset, MapActivity.this);
                                MapActivity.this.finish();
                            }
                        });
        builder.setNeutralButton("Show Highscore List",  new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                int offset;
                                if (state.isBonus) {
                                    offset = HighscoreHelper.BONUS_LEVELS_OFFSET;
                                } else {
                                    offset = 0;
                                }
                                HighscoreHelper.putHSList(state.score, input.getText().toString(), state.levelId + offset, MapActivity.this);
                                showDialog(Constants.ID_OFFSET_HIGHSCORE + state.levelId);
                                
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
                                i.putExtra(Constants.LEVEL_KEY, state.level.levelId);
                                i.putExtra(Constants.BONUS_LEVELS, state.isBonus);
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
        state = new GameState();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer levelKey = extras.getInt(Constants.LEVEL_KEY);
        state.isBonus = extras.getBoolean(Constants.BONUS_LEVELS);
        state.levelId =(Integer) levelKey;
        if (state.isBonus) {
            LevelFactory levels = new LevelFactoryBonus(this);
            state.level = levels.getLevel(LevelEnumBonus.values()[state.levelId]);
        } else {
            LevelFactory levels = new LevelFactory(this);
            state.level = levels.getLevel(LevelEnum.values()[state.levelId]);
        }
        String mode = extras.getString(Constants.MAP_MODE);
        if (mode!=null && mode.equals(Constants.MAP_MODE_TRAINING)) {
            state.isTraingMode = true;
            state.difficulty = Difficulty.TRAINING;
            state.lives = 0;
        } else {
            state.difficulty = settings.getDifficulty();
            if (state.difficulty == Difficulty.EASY) {
                state.lives = 5;
            } else if (state.difficulty == Difficulty.MEDIUM) {
                state.lives = 3;
            } else if (state.difficulty == Difficulty.HARD) {
                state.lives = 1;
            } else if (state.difficulty == Difficulty.EXTREME) {
                state.lives = 0;
            }
        }

    }

    public Level getLevel() {
        return state.level;
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
        if (settings.showDialogAfterCorrectGuess()) {
            showDialog(DIALOG_RIGHT);
        }
        if (state.level.entriesToDo.size() > 0) {
            Entry removed = state.level.entriesToDo.remove(0);
            state.level.entriesDone.add(removed);
        }
        if (state.level.entriesToDo.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void completeLevel() {
        state.score = calculateScore();
        int offset;
        if (state.isBonus) {
            offset = HighscoreHelper.BONUS_LEVELS_OFFSET;
        } else {
            offset = 0;
        }
        if (HighscoreHelper.madeHSList(state.score, offset + state.levelId, this)) {
            showDialog(DIALOG_MADE_HIGHSCORE);
        } else {
            showDialog(DIALOG_WON);
        }
    }

    private int calculateScore() {
        
        long duration = System.currentTimeMillis() - state.startTime;
        
        int timeScore = 40000 / (((int)(duration +1)/1000) + 1);
        
        int mistakeScore = (5 - state.mistakes) * 200;
        return timeScore + mistakeScore;
    }

    public void removeLife() {
        state.mistakes++;
        state.lives--;
        if (settings.getVibrateEnabled()) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 300 milliseconds
            v.vibrate(new long[] { 0, 100, 50, 100 }, -1);
        }
        if (state.lives < 0) {
            sound.playSound(Sound.FAIL);
            state.countdown = null;
            showDialog(DIALOG_FAILED);
        } else {
            sound.playSound(Sound.WRONG);

            state.hint = new Hint(state.level.entriesToDo.get(0),
                    System.currentTimeMillis());
            int realX = mapView.realX(state.hint.entry);
            int realY = mapView.realY(state.hint.entry);
            
            TwoDScrollView scrollView = (TwoDScrollView) findViewById(R.id.scene_scroller);
            scrollView.scrollTo(realX, realY-70);

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
            if (settings.showDialogAfterWrongGuess()) {
                showDialog(DIALOG_WRONG);
            }
            Entry toSwitch = state.level.entriesToDo.remove(0);
            state.level.entriesToDo.add(toSwitch);
            drawQuestion();

        }
    }

    public void drawLives() {
        String str = "";
        int i = 0;
        while (i < state.lives) {
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
            scoreText.setText(state.level.entriesDone.size() + "/"
                    + state.level.getTotalEntries());
        }
    }

    public void drawQuestion() {

        Entry newEntry = state.level.entriesToDo.get(0);
        TextView questionText = (TextView) findViewById(R.id.questionText);
        if (questionText != null) {
            if (state.isTraingMode) {
                questionText.setText(R.string.click_on_any_dot);
            }
            else {
                String prefix = getResources().getString(R.string.clickinstruction);
                questionText.setText(prefix + newEntry.name);
            }
        }
        if (state.difficulty == Difficulty.EXTREME && state.lives >= 0) {
            state.countdown = new Countdown(System.currentTimeMillis());
        }

    }

    public void drawTimer() {
        TextView timerText = (TextView) findViewById(R.id.timeText);
        if (timerText != null && state.countdown != null) {
            int time = (int) state.countdown.getTimeLeft();
            if (time < 0) {
                sound.playSound(Sound.FAIL);
                state.countdown = null;
                showDialog(DIALOG_FAILED);
            } else {
                float time2 = (time/100) / 10.0f;
                timerText.setText(time2 + " s");
            }
        }

    }

    public void onFirstDraw() {
        state.startTime = System.currentTimeMillis();
        drawQuestion();
        drawLives();
        // create a thread for updating the timer
        if (state.difficulty == Difficulty.EXTREME) {
            Thread background = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (!MapActivity.this.isFinishing()) {
                            Thread.sleep(100);
                            handler.sendMessage(handler.obtainMessage());
                            if (state.countdown != null && state.countdown.getTimeLeft() < 0) {
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
    

    
    public Object onRetainNonConfigurationInstance () {
        return state;
    }

    public void showTraingingModeText(Entry e) {
        TextView questionText = (TextView) findViewById(R.id.questionText);
        questionText.setText(e.name);
        //remove the old "selected entry"
        if (state.level.entriesDone.size() > 0) {
            Entry remove = state.level.entriesDone.remove(0);
            state.level.entriesToDo.add(remove);
        }
        // add new "selected entry"
        state.level.entriesDone.add(e);
        state.level.entriesToDo.remove(e);
        
        
    }
}
