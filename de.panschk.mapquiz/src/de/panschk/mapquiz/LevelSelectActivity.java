package de.panschk.mapquiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.objects.instances.LevelFactory;
import de.panschk.mapquiz.objects.instances.LevelFactory.LevelEnum;

public class LevelSelectActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        Button lastOne = null;
        for (LevelEnum levelEnum : values) {
            final int id = levelEnum.ordinal();
            LevelFactory levels = new LevelFactory(this);
            Level level = levels.getLevel(LevelEnum.values()[id]);
            if (level != null) {
                Button b = new Button(this);
                RelativeLayout.LayoutParams paramsButton = new RelativeLayout.LayoutParams(
                        LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                paramsButton.addRule(RelativeLayout.ALIGN_PARENT_LEFT,
                        RelativeLayout.TRUE);
                if (lastOne == null ) {
                    paramsButton.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

                } else {
                    paramsButton.addRule(RelativeLayout.BELOW, lastOne.getId());
                }
                b.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

                b.setLayoutParams(paramsButton);
                Drawable drawable = getResources().getDrawable(
                        level.pictereIdThumbnail);
                drawable.setBounds(0, 0, 100, 80);
                b.setCompoundDrawables(drawable, null, null, null);
                b.setText(level.name);
                b.setId(id);
                b.setOnClickListener(new OnClickListener() {

                    public void onClick(View v) {
                        Intent i = new Intent(LevelSelectActivity.this,
                                MapActivity.class);
                        i.putExtra(Constants.LEVEL_KEY, id);
                        startActivity(i);

                    }
                });
                r.addView(b);
                lastOne = b;
            }
        }
    }

}
