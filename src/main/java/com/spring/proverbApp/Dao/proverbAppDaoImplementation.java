package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.Proverbs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class proverbAppDaoImplementation implements proverbAppDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveProverb(Proverbs theProverb) {
        Session currentSession=sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theProverb);

    }

    @Override
    public List<Proverbs> getProverbs() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Proverbs> theQuery=currentSession.createQuery("from Proverbs",Proverbs.class);

        List<Proverbs> proverbs = theQuery.getResultList();

        return proverbs;
    }

    @Override
    public Proverbs getProverb(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Proverbs proverbs = currentSession.get(Proverbs.class,theId);

        return proverbs;



    }

    @Override
    public void deleteProverb(int theId) {
        Session currentSession= sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Proverbs where id=:proverbId");

        theQuery.setParameter("proverbId",theId);

        theQuery.executeUpdate();

    }
}
