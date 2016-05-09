package com.tetris.tile;

import com.tetris.*;
import com.tetris.field.Field;
import com.tetris.field.Neighbour;
import com.tetris.tile.move.*;
import com.tetris.tile.rotationstrategy.RotationCreator;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.*;
import lombok.Getter;
import java.awt.Color;

import java.util.List;

/**
 * Created by User on 06.03.2016.
 */
public abstract class Tile {
    protected RotationVariantCreator rotationVariantCreator;
    protected RotationCreator rotationCreator;
    protected MoveCreator moveCreator;
    @Getter protected List<Field> fields;
    protected Board board;
    protected Color color;
    @Getter protected Shape shape;

    public Tile(Board board) {
        this.board = board;
        rotationVariantCreator = new RotationVariantCreator();
        rotationCreator = new RotationCreator();
        moveCreator = new MoveCreator();
        setUpFields();
    }

    public abstract void setUpFields();

    public boolean isAddingPossible() {
        for (Field field : fields) {
            if (field != null && !field.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean rotate(RotationSide side) {
        if (!shape.equals(Shape.O)) {
            try {
                RotationVariant rotationVariant = rotationVariantCreator.getRotationVariant(fields, side);
                RotationStrategy rotationStrategy = rotationCreator.getRotation(shape, rotationVariant);
                if (rotationStrategy.isPossible(fields)) {
                    rotationStrategy.rotate(fields);
                    makeFieldsPartOfTile();
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Rotation exception " + e);
            }
        }
        return false;
    }

    public void startRotate(RotationSide side) {
        if (!shape.equals(Shape.O)) {
            try {
                RotationVariant rotationVariant = rotationVariantCreator.getRotationVariant(fields, side);
                RotationStrategy rotationStrategy = rotationCreator.getRotation(shape, rotationVariant);
                rotationStrategy.startRotate(fields);

            } catch (Exception e) {
                System.out.println("Rotation exception " + e);
            }
        }
    }

    public boolean makeFieldsPartOfTile() {
        for (Field field : fields) {
            field.makePartOfTile(color);
        }
        return true;
    }

    public boolean isFallPossible() {
        for (Field field : fields) {
            if (field.getNeighbour(Neighbour.LOWER) == null || field.isNeighbourPlacedField(Neighbour.LOWER)) {
                return false;
            }
        }
        return true;
    }

    public boolean move(Move move) {
        try {
            MoveStrategy moveStrategy = moveCreator.getMove(move);
            if (moveStrategy.isPossible(fields)) {
                moveStrategy.move(fields);
                makeFieldsPartOfTile();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Move exception " + e);
        }
        return false;
    }

    public void fallForRotation() {
        MoveStrategy moveStrategy = new FallStrategy();
        moveStrategy.lastMove(fields);
    }

    public void moveTileToTop() {
        MoveStrategy moveStrategy = new UpStrategy();
        while (moveStrategy.isPossible(fields)) {
            moveStrategy.lastMove(fields);
        }
    }

    public void moveLastTileUp(){
        MoveStrategy moveStrategy = new UpStrategy();
        while(!isAddingPossible()) {
            moveStrategy.lastMove(fields);
        }
    }

    public void placeTile() {
        for (Field field : fields) {
            if (field != null) {
                field.placeField(color);
            }
        }
    }

    public int getFieldPosition(int n) {
        return fields.get(n).getPosition();
    }
}