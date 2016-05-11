package com.tetris.controller;

import com.tetris.Board;
import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Observable;

/**
 * Created by User on 20.04.2016.
 */
@Service
public class BoardController extends Observable {
    @Value("${startProperties.width}")
    private int width;
    @Value("${startProperties.height}")
    private int height;
    @Getter private Board board;

    @PostConstruct
    public void init() {
        board = new Board(width * height);
    }

    public void searchForFullRows(List<Field> fields) {
        for (Field field : fields) {
            if (field.isSideOfRowFull(Neighbour.LEFT) && field.isSideOfRowFull(Neighbour.RIGHT)) {
                setChanged();
                notifyObservers(field.getPosition());
            }
        }
    }

    public void clearFullRows(List<Integer> rows) {
        for (Integer row : rows) {
            board.getField(row * width).clearRow();
            clearRow(row);
        }
        rows.clear();
    }

    public void clearRow(int rowNumber) {
        int row = (rowNumber-1) * width;
        for (int i=0; i<width; i++) {
            board.getField(i+row).columnFall();
        }
    }

    public Field getField(int fieldNumber) {
        return board.getField(fieldNumber);
    }
}
