package de.panschk.mapquiz;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;

/**
 * The FingerprintsView draws the background and any finger prints present from
 * a list it maintains. It listens for new finger press events and adds these
 * new ones to its list.
 */
public class MapView extends ImageView {
	private final Paint mPaint = new Paint();
	private Bitmap mapBitmap;
	private MapActivity activity;
	private Level level;
	private Bitmap dotBitmap;
	private Bitmap dotGreyBitmap;
    
	private float lastX;
	private float lastY;
	boolean firstDraw = true;

	/**
	 * Create the MapView
	 * 
	 * @param context
	 *            Context to use
	 */
	public MapView(Context context, AttributeSet set) {
		super(context, set);
		this.activity = (MapActivity) context;
		this.level = activity.getLevel();

		// Create the bitmaps
		mapBitmap = BitmapFactory.decodeResource(getResources(),
				level.pictureIdOfMap);
		dotBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.dot_small);
		dotGreyBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.dot_grey_small);
        

	}

	/**
	 * Draw the finger prints over the flower field
	 */
	@Override
	protected void onDraw(Canvas canvas) {
//        RelativeLayout container = (RelativeLayout) activity.findViewById(R.id.scene_container);
//        container.setMinimumHeight(level.height);
//        container.setMinimumWidth(level.width);
//        this.setMinimumHeight(level.height);
//        this.setMinimumWidth(level.width);
	    if (firstDraw) {

	        activity.setText(level.entriesToDo.get(0));
	        firstDraw = false;
	    }
	    canvas.drawBitmap(mapBitmap, 0, 0, mPaint);

		List<Entry> entries = level.entriesToDo;

		for (Entry entry : entries) {
			int realX = realX(entry);
			int realY = realY(entry);
			int xAdjusted = Math.max(0, realX - 7);
			int yAdjusted = Math.max(0, realY - 7);

			canvas.drawBitmap(dotBitmap, xAdjusted, yAdjusted, mPaint);
		}
	
        entries = level.entriesDone;

        for (Entry entry : entries) {
            int realX = realX(entry);
            int realY = realY(entry);
            int xAdjusted = Math.max(0, realX - 7);
            int yAdjusted = Math.max(0, realY - 7);

            canvas.drawBitmap(dotGreyBitmap, xAdjusted, yAdjusted, mPaint);
        }
        activity.drawScore();



	}

	private int realY(Entry entry) {
		int realY = mapBitmap.getHeight() * entry.y / level.height;
		return realY;
	}

	private int realX(Entry entry) {
		int realX = mapBitmap.getWidth() * entry.x / level.width;
		return realX;
	}

	/**
	 * Add a new finger print to the list on a finger press event
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			lastX = event.getX();
			lastY = event.getY();
			break;
		case MotionEvent.ACTION_UP:
			float currentX = event.getX();
			float currentY = event.getY();
			if (Math.abs(lastX - currentX) < 5 && Math.abs(lastY - currentY) < 5) {
				onClick();
			}
			
		default:
			break;
		}
		
		
		
		return false;

	}


	public void onClick() {

		float x = lastX;
		float y = lastY;

		Entry entry = level.entriesToDo.get(0);
		int realX = realX(entry);
		int realY = realY(entry);

		if ((Math.abs(realX - x) < 25) && Math.abs(realY - y) < 25) {
			if (activity.nextEntry()) {
				Entry newEntry = level.entriesToDo.get(0);
				activity.setText(newEntry);
			} else {
				activity.nextLevel();
			}
		} else {
			// iterate through the other ones, if there was an error
			for (int i = 1; i < level.entriesToDo.size(); i++) {
				Entry otherEntry = level.entriesToDo.get(i);
				int realX2 = realX(otherEntry);
				int realY2 = realY(otherEntry);
				if ((Math.abs(realX2 - x) < 25) && Math.abs(realY2 - y) < 25) {
				    activity.removeLife();
					activity.errorMsg();
				}
			}
		}

		invalidate();

	}
}