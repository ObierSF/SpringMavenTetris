package com.tetris.controller.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by User on 10.05.2016.
 */
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    @Getter @Setter private long id;
    @Getter @Setter private String scoreDate;
    @Getter @Setter private int score;
}
