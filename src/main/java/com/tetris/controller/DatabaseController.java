package com.tetris.controller;

import com.tetris.controller.database.Score;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class DatabaseController {
    public void addScoreToDatabase(int scoreValue) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("scoreDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Score score = new Score();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        score.setScoreDate(reportDate);
        score.setScore(scoreValue);

        entityManager.getTransaction().begin();
        entityManager.persist(score);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
