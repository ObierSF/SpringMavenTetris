package com.tetris.view;

import com.tetris.Board;
import com.tetris.controller.BoardController;
import com.tetris.view.fieldview.CompositeFieldView;
import com.tetris.view.fieldview.ChildFieldView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 24.04.2016.
 */
@Service
public class GameView extends JPanel {
    private static final int dimensionWidth = 400;
    private static final int dimensionHeight = 640;
    @Value("${startProperties.width}")
    private int width = 10;
    @Value("${startProperties.height}")
    private int height = 16;
    private CompositeFieldView compositeFieldView;
    @Autowired
    private BoardController boardController;

    @PostConstruct
    public void init() {
        compositeFieldView = new CompositeFieldView();
        for (int fieldNumber=0; fieldNumber<width*height; fieldNumber++) {
            int column = fieldNumber % width;
            int row = fieldNumber / width;
            compositeFieldView.addField(new ChildFieldView(column, row, boardController.getField(fieldNumber)));
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        compositeFieldView.draw(graphics);
    }

    public Dimension getPreferredSize() {
        return new Dimension(dimensionWidth, dimensionHeight);
    }
}