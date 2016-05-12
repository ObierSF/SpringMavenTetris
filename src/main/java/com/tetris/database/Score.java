package com.tetris.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private long id;
    @Column
    @Getter @Setter private String scoreDate;
    @Column
    @Getter @Setter private int score;
}
