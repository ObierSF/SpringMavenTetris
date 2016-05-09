package com.tetris;

import com.tetris.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Controller controller = context.getBean("controller", Controller.class);
        controller.run();
    }
}
