package com.tetris.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreDao scoreDao;

    @Transactional
    public void add(Score score) {
        scoreDao.add(score);
    }

    @Transactional
    public List<Score> getTop10Scores(){
        return scoreDao.getTop10Scores();
    }
}
