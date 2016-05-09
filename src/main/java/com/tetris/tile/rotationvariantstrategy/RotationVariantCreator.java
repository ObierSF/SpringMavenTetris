package com.tetris.tile.rotationvariantstrategy;

import com.tetris.field.Field;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 30.03.2016.
 */
public class RotationVariantCreator {
    @SuppressWarnings("unchecked")
    private static final List<RotationVariantStrategy> rotationVariantStrategy =
            Collections.unmodifiableList(Arrays.<RotationVariantStrategy>asList(
                    new HorizontalDownRotationStrategy(),new HorizontalUpRotationStrategy(),
                    new VerticalDownRotationStrategy(), new VerticalUpRotationStrategy()));

    public RotationVariant getRotationVariant(List<Field> fields, RotationSide side) throws Exception {
        for (RotationVariantStrategy strategy : rotationVariantStrategy) {
            if (strategy.validate(fields, side)) {
                return strategy.getRotationVariant();
            }
        }
        throw new RotationVariantException();
    }
}
