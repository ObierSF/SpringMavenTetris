package com.tetris.field;

import com.tetris.Board;
import com.tetris.borderstrategy.*;
import lombok.Getter;
import lombok.Setter;
import java.awt.Color;

/**
 * Created by User on 06.03.2016.
 */
public class Field {
    private final int height = 16;
    private final int width = 10;
    @Getter private boolean partOfTile;
    @Getter private boolean placedField;
    @Getter private int position;
    @Getter private Color color;
    @Getter private Border border;
    @Getter @Setter private SurroundingFields surroundingFields;


    public Field(int position) {
        this.position = position;
        partOfTile = false;
        placedField = false;
        color = Color.WHITE;
        BorderCreator borderCreator = new BorderCreator();
        try {
            border = borderCreator.getBorder(width, height, position, border);
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void placeField(Color color) {
        this.color = color;
        partOfTile = false;
        placedField = true;
    }

    public boolean makePartOfTile(Color color) {
        if (isEmpty()) {
            this.color = color;
            partOfTile = true;
            placedField = false;
            return true;
        }
        return false;
    }

    public void empty() {
        color = Color.WHITE;
        partOfTile = false;
        placedField = false;
    }

    public void columnFall() {
        if (isFallPossible()) {
            fall();
            if (getNeighbour(Neighbour.UPPER) != null) {
                getNeighbour(Neighbour.UPPER).columnFall();
            }
        }
    }

    public boolean isFallPossible() {
        return getNeighbour(Neighbour.LOWER) != null && !isNeighbourPlacedField(Neighbour.LOWER);
    }

    public void fall() {
        if (!isEmpty()) {
            getNeighbour(Neighbour.LOWER).placeField(color);
        }
        empty();
    }

    public void determineSurroundingFields(Board board) {
        surroundingFields = border.determineTheSurroundingFields(board, position);
    }

    public boolean isEmpty() {
        return !placedField && !partOfTile;
    }

    public Field getNeighbour(Neighbour neighbour) {
        return surroundingFields.getNeighbour(neighbour);
    }

    public boolean isNeighbourPlacedField(Neighbour neighbour) {
        return getNeighbour(neighbour).isPlacedField();
    }

    public boolean isSideOfRowFull(Neighbour neighbour) {
        if (getNeighbour(neighbour) == null) {
            return true;
        }
        else if (isNeighbourPlacedField(neighbour) || getNeighbour(neighbour).isPartOfTile()) {
            return getNeighbour(neighbour).isSideOfRowFull(neighbour);
        }
        return false;
    }

    public void clearRow() {
        empty();
        if (getNeighbour(Neighbour.RIGHT) != null) {
            getNeighbour(Neighbour.RIGHT).clearRow();
        }
    }
}