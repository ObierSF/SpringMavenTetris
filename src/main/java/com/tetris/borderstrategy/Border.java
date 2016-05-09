package com.tetris.borderstrategy;

import com.tetris.Board;
import com.tetris.field.SurroundingFields;

/**
 * Created by User on 07.03.2016.
 */
public enum Border {
    LEFTTOPCORNER {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = null;
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = null;
            return surroundingFields;
        }
    },
    RIGHTTOPCORNER {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = null;
            surroundingFields.right = null;
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    LEFTBOTTOMCORNER {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = null;
            surroundingFields.left = null;
            return surroundingFields;
        }
    },
    RIGHTBOTTOMCORNER {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = null;
            surroundingFields.lower = null;
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    LEFT {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = null;
            return surroundingFields;
        }
    },
    RIGHT {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = null;
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    TOP {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = null;
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    BOTTOM {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = null;
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    },
    NONBORDER {
        @Override
        public SurroundingFields determineTheSurroundingFields(Board board, int position) {
            SurroundingFields surroundingFields = new SurroundingFields();
            surroundingFields.upper = board.getField(position - width);
            surroundingFields.right = board.getField(position + 1);
            surroundingFields.lower = board.getField(position + width);
            surroundingFields.left = board.getField(position - 1);
            return surroundingFields;
        }
    };

    final int width = 10;
    final int height = 16;
    public abstract SurroundingFields determineTheSurroundingFields(Board board, int position);
}
