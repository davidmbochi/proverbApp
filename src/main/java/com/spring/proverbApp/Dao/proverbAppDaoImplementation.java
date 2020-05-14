package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.Proverbs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class proverbAppDaoImplementation implements proverbAppDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveProverb(Proverbs theProverb) {
        Session currentSession=sessionFactory.getCurrentSession();

        currentSession.save(theProverb);

    }

    @Override
    public List<Proverbs> getProverbs() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Proverbs> theQuery=currentSession.createQuery("from Proverbs",Proverbs.class);

        List<Proverbs> proverbs = theQuery.getResultList();

        return proverbs;
    }
}
