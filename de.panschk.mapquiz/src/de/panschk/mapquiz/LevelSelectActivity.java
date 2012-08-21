package de.panschk.mapquiz;

import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactory;
import de.panschk.mapquiz.objects.instances.LevelFactory.LevelEnum;
import de.panschk.mapquiz.util.HighscoreHelper;
import de.panschk.mapquiz.util.HighscoreHelper.HSEntry;
import de.panschk.mapquiz.util.Settings;

public class LevelSelectActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapquizApplication app = (MapquizApplication) this
                .getApplicationContext();
        Settings settings = app.getSettings();
        settings.adjustLanguageConfig();
        RelativeLayout r = new RelativeLayout(this);
        ScrollView s =new ScrollView(this);
        
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);
        r.setLayoutParams(params);
        addButtons(r);
        s.addView(r);
        setContentView(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_level_select, menu);
        return true;
    }

    private void addButtons(RelativeLayout r) {

        LevelEnum[] values = LevelEnum.values();
        LinearLayout lastOne = null;
        for (LevelEnum levelEnum : values) {
            final int id = levelEnum.ordinal();
            LevelFactory levels = new LevelFactory(this);
            Level level = levels.getLevel(LevelEnum.values()[id]);
            if (level != null) {
                boolean isAvailable = isAvailable(id);
                
                LinearLayout container = new LinearLayout(this);
                container.setId(id + 1);
                RelativeLayout.LayoutParams paramsContainer = new RelativeLayout.LayoutParams(
                        LayoutParams.FILL_PARENT, 100);
                paramsContainer.addRule(RelativeLayout.ALIGN_PARENT_LEFT,
                        RelativeLayout.TRUE);
                if (lastOne == null ) {
                    paramsContainer.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                } else {
                    paramsContainer.addRule(RelativeLayout.BELOW, lastOne.getId());
                }
                container.setLayoutParams(paramsContainer);
                r.addView(container);
                lastOne = container;
                
                
                Button b = new Button(this);
                b.setGravity(Gravity.LEFT);
                LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                        LayoutParams.FILL_PARENT, 100);
                paramsButton.weight = 0.8f;
                b.setLayoutParams(paramsButton);
                Drawable drawable;
                if (isAvailable) {
                    drawable = getResources().getDrawable(
                            level.pictereIdThumbnail);

                    b.setText(level.name);
                } else {
                    drawable = getResources().getDrawable(
                            R.drawable.thumb_unknown);
                    b.setText("???");
                }
                drawable.setBounds(0, 0, 100, 80);
                b.setCompoundDrawables(drawable, null, null, null);
                b.setClickable(isAvailable);
                b.setId(Constants.ID_OFFSET_BUTTON + id);
                b.setOnClickListener(new OnClickListener() {

                    public void onClick(View v) {
                        Intent i = new Intent(LevelSelectActivity.this,
                                MapActivity.class);
                        i.putExtra(Constants.LEVEL_KEY, id);
                        startActivity(i);

                    }
                });
                container.addView(b);
                
                Button highscore = new Button(this);
                highscore.setGravity(Gravity.RIGHT );
                LinearLayout.LayoutParams paramsHS = new LinearLayout.LayoutParams(100, 100);
                paramsHS.weight = 0.2f;
                highscore.setLayoutParams(paramsHS);
                Drawable star = getResources().getDrawable(R.drawable.star);
                star.setBounds(0, 0, 48, 48);
                highscore.setCompoundDrawables(star, null, null, null);
                highscore.setId(Constants.ID_OFFSET_HIGHSCORE + id);
                highscore.setOnClickListener(new OnClickListener() {

                    public void onClick(View v) {
                        
                        showDialog(Constants.ID_OFFSET_HIGHSCORE + id);


                    }
                });
                container.addView(highscore);

            }
        }
    }
    
    private boolean isAvailable(int id) {
        if (Constants.DEBUG_ALL_LEVELS) {
            return true;
        }
        if (id == 0) {
            return true;
        }
        List<HSEntry> hs = HighscoreHelper.getHS(id - 1, this);
        if (hs != null && hs.size() > 0 ){
            return true;
        }
        return false;
    }

    protected Dialog onCreateDialog(int id) {
        
        if (id >= Constants.ID_OFFSET_HIGHSCORE) {
            return HighscoreHelper.createHighscoreDialog(id, this, false);
        }
        
        return super.onCreateDialog(id);
        
    }

    
    
    

}
