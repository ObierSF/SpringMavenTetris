package com.tetris.view;

import com.tetris.controller.DatabaseController;
import com.tetris.database.Score;
import com.tetris.database.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class TableCreator {
    @Autowired
    private DatabaseController databaseController;

    public JTable createTableFromScoreList() {
        String[] columnNames = new String[]{"No.", "Score", "Date"};
        int i=0;
        List<Score> scoreList = databaseController.getScoreTable();
        Object[][] data = new Object[10][3];
        for (Score score : scoreList) {
            data[i][0] = i + 1;
            data[i][1] = score.getScore();
            data[i][2] = score.getScoreDate();
            i++;
        }
        return new JTable(data, columnNames);
    }
}
