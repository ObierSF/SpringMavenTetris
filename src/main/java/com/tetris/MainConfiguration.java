package com.tetris;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  "com.tetris.controller, com.tetris.view")
public class MainConfiguration {
}
