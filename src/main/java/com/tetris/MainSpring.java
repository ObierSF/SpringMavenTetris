package com.tetris;

import com.tetris.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        MainController mainController = context.getBean("mainController", MainController.class);
        mainController.run();
    }
}
