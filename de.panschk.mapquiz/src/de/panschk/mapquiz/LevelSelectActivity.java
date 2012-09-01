package de.panschk.mapquiz;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactory;
import de.panschk.mapquiz.objects.instances.LevelFactory.LevelEnum;
import de.panschk.mapquiz.objects.instances.LevelFactoryBonus;
import de.panschk.mapquiz.objects.instances.LevelFactoryBonus.LevelEnumBonus;
import de.panschk.mapquiz.util.DisplayStringHelper;
import de.panschk.mapquiz.util.HighscoreHelper;
import de.panschk.mapquiz.util.HighscoreHelper.HSEntry;
import de.panschk.mapquiz.util.Settings;

public class LevelSelectActivity extends Activity {

    protected static final int ENTER_SECRET_CODE = 0;
    protected static final int CODE_RIGHT = 1;
    protected static final int CODE_WRONG = 2;
    private Drawable star;
    private Drawable starGrey;
    private Drawable unknown;

    boolean isBonus = false;
    boolean bonusLevelsAvailable = false;
    private Settings settings;

    @Override
    protected void onResume() {
        super.onResume();
        MapquizApplication app = (MapquizApplication) this.getApplicationContext();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            isBonus = extras.getBoolean(Constants.BONUS_LEVELS);
        }
        settings = app.getSettings();
        bonusLevelsAvailable = settings.bonusLevelsAvailable();
        if (!bonusLevelsAvailable) {
            bonusLevelsAvailable = checkBonusLevelsAvailable(settings);
        }
        settings.adjustLanguageConfig();
        RelativeLayout r = new RelativeLayout(this);
        ScrollView s = new ScrollView(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);
        star = getResources().getDrawable(R.drawable.star);
        star.setBounds(0, 0, 48, 48);
        starGrey = getResources().getDrawable(R.drawable.star_grey);
        starGrey.setBounds(0, 0, 48, 48);
        unknown = getResources().getDrawable(R.drawable.thumb_unknown);

        r.setLayoutParams(params);
        addButtons(r);
        s.addView(r);
        setContentView(s);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private boolean checkBonusLevelsAvailable(Settings settings) {
        LevelEnum[] values = LevelEnum.values();
        for (LevelEnum levelEnum : values) {
            List<HSEntry> hs = HighscoreHelper.getHS(levelEnum.ordinal(), this);
            if (!(hs != null && hs.size() > 0)) {
                return false;
            }
        }
        settings.setBonusLevelsAvailable(true);
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_level_select, menu);
        return true;
    }

    private void addButtons(RelativeLayout r) {
        LevelFactory levels;
        Enum[] values;
        if (isBonus) {
            levels = new LevelFactoryBonus(this);
            values = LevelEnumBonus.values();
        } else {
            levels = new LevelFactory(this);
            values = LevelEnum.values();
        }

        View lastOne = null;
        if (isBonus) {
            int idForTxt = 99826;
            LinearLayout container = new LinearLayout(this);
            container.setId(idForTxt);
            RelativeLayout.LayoutParams paramsContainer = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, 100);
            paramsContainer.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            paramsContainer.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            container.setLayoutParams(paramsContainer);
            r.addView(container);
            lastOne = container;
            TextView info = new TextView(this);
            info.setGravity(Gravity.LEFT);
            LinearLayout.LayoutParams paramsTxt = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 100);
            paramsTxt.weight = 0.6f;
            info.setLayoutParams(paramsTxt);
            container.addView(info);
            if (bonusLevelsAvailable) {
                info.setText(getString(R.string.the_secret_code_is_) + Constants.SECRET_CODE);
            } else {
                info.setText(getString(R.string.you_have_to_complete_the_regular_levels_first_or_just_enter_the_secret_code_));
                Button tryCodeBttn = new Button(this);
                LinearLayout.LayoutParams paramsSB = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 100);
                paramsSB.weight = 0.4f;
                tryCodeBttn.setLayoutParams(paramsSB);
                tryCodeBttn.setText(R.string.enter_code);
                tryCodeBttn.setOnClickListener(new OnClickListener() {

                    public void onClick(View v) {
                        showDialog(ENTER_SECRET_CODE);

                    }
                });
                container.addView(tryCodeBttn);
            }

        }

        for (Enum enumInst : values) {
            final int id = enumInst.ordinal();

            Level level;
            if (isBonus) {
                level = levels.getLevel(LevelEnumBonus.values()[id]);
            } else {
                level = levels.getLevel(LevelEnum.values()[id]);
            }
            if (level != null) {
                final boolean isAvailable = isAvailable(id);

                LinearLayout container = new LinearLayout(this);
                container.setId(id + 1);
                RelativeLayout.LayoutParams paramsContainer = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT,
                        100);
                paramsContainer.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                if (lastOne == null) {
                    paramsContainer.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                } else {
                    paramsContainer.addRule(RelativeLayout.BELOW, lastOne.getId());
                }
                container.setLayoutParams(paramsContainer);
                r.addView(container);
                lastOne = container;

                Button b = new Button(this);
                b.setGravity(Gravity.LEFT);
                LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 100);
                paramsButton.weight = 0.8f;
                b.setLayoutParams(paramsButton);
                Drawable drawable;
                if (isAvailable) {
                    drawable = getResources().getDrawable(level.pictereIdThumbnail);

                    b.setText(level.name);
                } else {
                    drawable = unknown;
                    b.setText("???");
                }
                drawable.setBounds(0, 0, 100, 80);
                b.setCompoundDrawables(drawable, null, null, null);
                b.setClickable(isAvailable);
                b.setId(Constants.ID_OFFSET_BUTTON + id);
                b.setOnClickListener(new OnClickListener() {

                    public void onClick(View v) {
                        if (isAvailable) {
                            Intent i = new Intent(LevelSelectActivity.this, MapActivity.class);
                            i.putExtra(Constants.LEVEL_KEY, id);
                            i.putExtra(Constants.BONUS_LEVELS, isBonus);
                            startActivity(i);
                        }

                    }
                });
                container.addView(b);

                Button highscore = new Button(this);
                highscore.setGravity(Gravity.RIGHT);
                LinearLayout.LayoutParams paramsHS = new LinearLayout.LayoutParams(100, 100);
                paramsHS.weight = 0.2f;
                highscore.setLayoutParams(paramsHS);

                highscore.setCompoundDrawables(hasCompleted(id) ? star : starGrey, null, null, null);
                final int highScoreOffset = Constants.ID_OFFSET_HIGHSCORE
                        + (isBonus ? HighscoreHelper.BONUS_LEVELS_OFFSET : 0);
                highscore.setId(Constants.ID_OFFSET_HIGHSCORE + id);
                highscore.setOnClickListener(new OnClickListener() {

                    public void onClick(View v) {

                        showDialog(highScoreOffset + id);
                    }
                });
                container.addView(highscore);

            }
        }

        Button back = new Button(this);
        back.setText(getString(R.string.back));
        RelativeLayout.LayoutParams paramsBB = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, 100);
        paramsBB.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        paramsBB.addRule(RelativeLayout.BELOW, lastOne.getId());
        back.setLayoutParams(paramsBB);
        back.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                LevelSelectActivity.this.finish();
            }
        });
        r.addView(back);

    }

    private boolean isAvailable(int id) {

        if (Constants.DEBUG_ALL_LEVELS) {
            return true;
        }
        if (isBonus) {
            return bonusLevelsAvailable;
        }
        if (id == 0) {
            return true;
        }
        List<HSEntry> hs = HighscoreHelper.getHS(id - 1, this);
        if (hs != null && hs.size() > 0) {
            return true;
        }
        return false;
    }

    private boolean hasCompleted(int id) {
        if (isBonus) {
            id = id + HighscoreHelper.BONUS_LEVELS_OFFSET;
        }
        List<HSEntry> hs = HighscoreHelper.getHS(id, this);
        if (hs != null && hs.size() > 0) {
            return true;
        }
        return false;
    }

    protected Dialog onCreateDialog(int id) {

        if (id >= Constants.ID_OFFSET_HIGHSCORE) {
            return HighscoreHelper.createHighscoreDialog(id, this, false);
        }
        if (id == ENTER_SECRET_CODE) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.enter_code).setCancelable(true);
            final EditText editView = new EditText(this);
            builder.setView(editView);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Editable text = editView.getText();
                    String textContent = text.toString();
                    if (Constants.SECRET_CODE.equalsIgnoreCase(textContent.trim())) {
                        settings.setBonusLevelsAvailable(true);
                        showDialog(CODE_RIGHT);
                    } else {
                        showDialog(CODE_WRONG);
                    }
                }
            });

            AlertDialog alert = builder.create();
            return alert;
        }
        if (id == CODE_RIGHT) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(null)
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent i = new Intent(LevelSelectActivity.this,
                                            LevelSelectActivity.class);
                                    i.putExtra(Constants.BONUS_LEVELS, true);
                                    startActivity(i);
                                    LevelSelectActivity.this.finish();
                                }
                            });
            builder.setIcon(R.drawable.happyearth);
            builder.setTitle(DisplayStringHelper.getRndCorrectSolutionString(this));
            AlertDialog alert = builder.create();
            return alert;
        }
        if (id == CODE_WRONG) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.wrong_)
                    .setCancelable(true);
            builder.setPositiveButton(android.R.string.ok, null);
            AlertDialog alert = builder.create();
            return alert;
        }

        return super.onCreateDialog(id);

    }

}
