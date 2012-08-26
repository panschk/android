package de.panschk.mapquiz.objects;

import de.panschk.mapquiz.util.Settings.Difficulty;

public class GameState {
    
    public int lives = 0;
    public int mistakes = 0;
    public Level level;
    public Difficulty difficulty;
    public Hint hint;
    public Countdown countdown;
    public long startTime;
    public Integer levelId;
    public int score;
    public boolean isTraingMode = false;
    public boolean isBonus;
    public Entry lastWrongGuess;
    public long timeOfLastGuess;

}
