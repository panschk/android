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
import de.panschk.mapquiz.objects.Entry;
import de.panschk.mapquiz.objects.Level;
import de.panschk.mapquiz.threads.TimerThread;

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
	private Bitmap dotSolveBitmap;
    
    
	private float lastX;
	private float lastY;
	boolean firstDraw = true;
	private int offset = 7;
    public int height;
    public int width;


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
				R.drawable.dot);
		dotGreyBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.dot_green);
		dotSolveBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.dot_solve);
        
		this.width = mapBitmap.getWidth();
		this.height = mapBitmap.getHeight();
        

	}

	/**
	 * 
	 */
	@Override
	protected void onDraw(Canvas canvas) {
	    if (firstDraw) {
	        activity.onFirstDraw();
	        firstDraw = false;
	        offset = dotBitmap.getHeight() / 2;
	        
	    }
	    canvas.drawBitmap(mapBitmap, 0, 0, mPaint);

		List<Entry> entries = level.entriesToDo;

		for (Entry entry : entries) {
			int realX = realX(entry);
			int realY = realY(entry);
			int xAdjusted = Math.max(0, realX - offset);
			int yAdjusted = Math.max(0, realY - offset);

			canvas.drawBitmap(dotBitmap, xAdjusted, yAdjusted, mPaint);
		}
	
        entries = level.entriesDone;

        for (Entry entry : entries) {
            int realX = realX(entry);
            int realY = realY(entry);
            int xAdjusted = Math.max(0, realX - offset);
            int yAdjusted = Math.max(0, realY - offset);

            canvas.drawBitmap(dotGreyBitmap, xAdjusted, yAdjusted, mPaint);
        }
        if (activity.hint != null && activity.hint.getTTL() > 0 ) {
            int realX = realX(activity.hint.entry);
            int realY = realY(activity.hint.entry);
            int xAdjusted = Math.max(0, realX - offset);
            int yAdjusted = Math.max(0, realY - offset);

            canvas.drawBitmap(dotSolveBitmap, xAdjusted, yAdjusted, mPaint);
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
		//otherwise will get exceptions
		if (level.entriesToDo.size() < 1) {
		    return;
		}
		Entry entry = level.entriesToDo.get(0);
		int realX = realX(entry);
		int realY = realY(entry);

		if ((Math.abs(realX - x) < 25) && Math.abs(realY - y) < offset * 2) {
			if (activity.nextEntry()) {
			    activity.sound.playSound(Sound.RIGHT);
			    activity.drawQuestion();
			} else {
			    activity.sound.playSound(Sound.WIN);
				activity.nextLevel();
			}
		} else {
			// iterate through the other ones, if there was an error
			for (int i = 1; i < level.entriesToDo.size(); i++) {
				Entry otherEntry = level.entriesToDo.get(i);
				int realX2 = realX(otherEntry);
				int realY2 = realY(otherEntry);
				if ((Math.abs(realX2 - x) < 25) && Math.abs(realY2 - y) < offset * 2) {
				    activity.removeLife();
				}
			}
		}

		invalidate();

	}
}