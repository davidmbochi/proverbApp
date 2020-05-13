package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.Proverbs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class proverbAppDaoImplementation implements proverbAppDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveProverb(Proverbs theProverb) {
        Session currentSession=sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theProverb);

    }
}
