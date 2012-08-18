package de.panschk.mapquiz.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
	public List<Entry> entriesToDo;
	public List<Entry> entriesDone;
	public String name;
	
	public int pictureIdOfMap;
	public int pictereIdThumbnail;
	
	public int width;
	public int height;
	public int levelId;
	
	public Level(int levelId, String name, List<Entry> entries, int pictureId, int thumbId, int width, int height) {
		this.levelId = levelId;
        this.name = name;
		this.entriesToDo = new ArrayList<Entry>();
		for (Entry entry : entries) {
            entriesToDo.add(entry);
        }
		Collections.shuffle(entriesToDo);
		this.entriesDone = new ArrayList<Entry>();
		this.pictureIdOfMap = pictureId;
		this.pictereIdThumbnail = thumbId;
		this.width = width;
		this.height = height;
	}
	
	
	public int getTotalEntries() {
	    return entriesDone.size() + entriesToDo.size();
	}

}
