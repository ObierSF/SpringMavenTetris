package com.tetris.controller.keystrategy;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
@Service
public class KeyCreator {
    @SuppressWarnings("unchecked")
    private static final List<KeyStrategy> keyStrategy =
            Collections.unmodifiableList(Arrays.<KeyStrategy>asList(
                    new DownArrowStrategy(), new UpArrowStrategy(),
                    new LeftArrowStrategy(), new RightArrowStrategy(),
                    new SpacebarStrategy()));

    public KeyStrategy getKey(int pressedKey) throws Exception {
        for (KeyStrategy strategy : keyStrategy) {
            if (strategy.validate(pressedKey)) {
                return strategy;
            }
        }
        throw new KeyException();
    }
}
