package com.tetris;

import com.tetris.field.Field;
import com.tetris.field.FieldListFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class Board {
    private List<Field> board;
    @Autowired
    private FieldListFactory fieldListFactory;
    @Value("${startProperties.fieldsNumber}")
    private int fieldsNumber;

    @PostConstruct
    private void init() {
        board = fieldListFactory.getFilledBoard(fieldsNumber);
        setSurroundingFieldsForFields();
    }

    public Field getField(int fieldPosition) {
        return board.get(fieldPosition);
    }

    private void setSurroundingFieldsForFields() {
        for (Field field : board) {
            field.determineSurroundingFields(this);
        }
    }

    public void printBoard() {
        int counter = 0;
        for (Field field : board) {
            if (field.isPlacedField()) {
                System.out.print("p ");
            } else if (field.isPartOfTile()) {
                System.out.print("t ");
            } else {
                System.out.print("e ");
            }
            if (++counter%10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
}