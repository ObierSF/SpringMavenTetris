package com.tetris.database;

import java.util.List;

public interface ScoreDao {
    public void add(Score score);
    public List<Score> getTop10Scores();
}
