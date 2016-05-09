package com.tetris.tile.move;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 06.04.2016.
 */
public class MoveCreator {
    @SuppressWarnings("unchecked")
    private static final List<MoveStrategy> moveStrategy =
            Collections.unmodifiableList(Arrays.<MoveStrategy>asList(
                    new LeftStrategy(), new RightStrategy(),
                    new FallStrategy(), new UpStrategy()));

    public MoveStrategy getMove(Move move) throws Exception {
        for (MoveStrategy strategy : moveStrategy) {
            if (strategy.validate(move)) {
                return strategy;
            }
        }
        throw new MoveException();
    }
}
