package com.tetris.database;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreDaoImpl implements ScoreDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Score score) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.getTransaction();
//        transaction.begin();
//        session.save(score);
//        transaction.commit();
        sessionFactory.getCurrentSession().save(score);
    }

    public List<Score> getTop10Scores() {
//        Query query = sessionFactory.openSession().createQuery("from Score order by score desc");
        Query query = sessionFactory.getCurrentSession().createQuery("from Score order by score desc");
        query.setMaxResults(10);
        return query.list();
    }
}
