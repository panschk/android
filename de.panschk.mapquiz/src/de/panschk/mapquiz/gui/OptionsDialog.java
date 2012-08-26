package de.panschk.mapquiz.gui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import de.panschk.mapquiz.Constants;
import de.panschk.mapquiz.MapActivity;
import de.panschk.mapquiz.R;

public class OptionsDialog extends Dialog {
    public OptionsDialog(final MapActivity context) {
        super(context);
        boolean trainingsMode = context.state.isTraingMode;
        this.setContentView(R.layout.optionsdialog);
        this.setTitle("Options");
        Button restartButton = (Button) findViewById(R.id.restart);
        restartButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(context, MapActivity.class);
                i.putExtra(Constants.LEVEL_KEY, context.state.levelId);
                i.putExtra(Constants.BONUS_LEVELS, context.state.isBonus);
                context.startActivity(i);
                context.finish();
            }
        });
        Button trainingButton = (Button) findViewById(R.id.training);
        if (trainingsMode) {
            trainingButton.setVisibility(View.INVISIBLE);
            trainingButton.setClickable(false);
        }
        trainingButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(context, MapActivity.class);
                i.putExtra(Constants.MAP_MODE, Constants.MAP_MODE_TRAINING);
                i.putExtra(Constants.BONUS_LEVELS, context.state.isBonus);
                i.putExtra(Constants.LEVEL_KEY, context.state.levelId);
                context.startActivity(i);
                context.finish();
            }
        });
        Button levelSelectButton = (Button) findViewById(R.id.level_select);
        levelSelectButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                context.finish();
            }
        });
        Button cancelButton = (Button) findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OptionsDialog.this.cancel();
            }
        });

    }

}
