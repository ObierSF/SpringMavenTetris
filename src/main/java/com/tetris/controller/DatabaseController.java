package com.tetris.controller;

import com.tetris.controller.database.Score;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DatabaseController {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("scoreDatabase");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addScoreToDatabase(int scoreValue) {
        Score score = new Score();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        score.setScoreDate(reportDate);
        score.setScore(scoreValue);

        entityManager.getTransaction().begin();
        entityManager.persist(score);
        entityManager.getTransaction().commit();
    }

    public List<Score> getScoreTable() {
        TypedQuery<Score> query = entityManager.createQuery("SELECT s FROM Score s ORDER BY score DESC", Score.class);
        query.setMaxResults(10);
        List<Score> scores = query.getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return scores;
    }
}
