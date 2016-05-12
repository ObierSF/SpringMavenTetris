package com.tetris.controller;

import com.tetris.database.Score;
import com.tetris.database.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DatabaseController {
    @Autowired
    private ScoreService scoreService;

    public void addScoreToDatabase(int scoreValue) {
        Score score = new Score();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        score.setScoreDate(reportDate);
        score.setScore(scoreValue);

        scoreService.add(score);
    }

    public List<Score> getScoreTable() {
        return scoreService.getTop10Scores();
    }
}
