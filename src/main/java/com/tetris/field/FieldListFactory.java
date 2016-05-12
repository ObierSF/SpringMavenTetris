package com.tetris.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FieldListFactory implements ApplicationContextAware {
    private ApplicationContext context;

    public List<Field> getFilledBoard(int fieldsNumber) {
        List<Field> board = new ArrayList<Field>();
        for (int i=0; i<fieldsNumber; i++) {
            board.add(context.getBean("field", Field.class));
            board.get(i).init(i);
        }
        return board;
    }

    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }
}

