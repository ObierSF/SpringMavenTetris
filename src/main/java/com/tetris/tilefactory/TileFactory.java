package com.tetris.tilefactory;

import com.tetris.Board;
import com.tetris.shapestrategy.*;
import com.tetris.tile.Tile;
import com.tetris.tile.move.Move;
import com.tetris.tile.rotationstrategy.RotationCreator;
import com.tetris.tile.rotationstrategy.RotationStrategy;
import com.tetris.tile.rotationvariantstrategy.HorizontalDownRotationStrategy;
import com.tetris.tile.rotationvariantstrategy.RotationVariant;
import com.tetris.tilefactory.startrotationstrategy.StartRotationCreator;
import lombok.Getter;

import java.util.*;

/**
 * Created by User on 06.03.2016.
 */
public class TileFactory {
    protected Random rand;
    protected Board board;
    @Getter protected Tile tile;
    @SuppressWarnings("unchecked")
    protected static final List<ShapeStrategy> shapeStrategy =
            Collections.unmodifiableList(Arrays.<ShapeStrategy>asList(
                    new IShapeStrategy(), new OShapeStrategy(), new TShapeStrategy(),
                    new LShapeStrategy(), new JShapeStrategy(),
                    new SShapeStrategy(), new ZShapeStrategy()));

    public TileFactory(Board board) {
        this.board = board;
        rand = new Random();
    }

    public void setLastTile() {
        tile.moveLastTileUp();
        tile.placeTile();
    }

    public void generateTile() {
        int shapeNumber = rand.nextInt(7);
        ShapeStrategy shape = shapeStrategy.get(shapeNumber);
        tile = shape.getTileShape(board);
    }

    public boolean isAddingTilePossible() {
        return tile.isAddingPossible();
    }
}