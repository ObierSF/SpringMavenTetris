package com.tetris;

import com.tetris.field.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public class Board {
    private List<Field> board;
    private int fieldsNumber;

    public Board(int fieldsNumber) {
        this.fieldsNumber = fieldsNumber;
        board = new ArrayList<Field>(fieldsNumber);
        createBoard(fieldsNumber);
        setSurroundingFieldsForFields();
    }

    private void createBoard(int fieldsNumber) {
        for (int i=0; i<fieldsNumber; i++) {
            board.add(new Field(i));
        }
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