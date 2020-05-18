package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.ProverbUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class userDaoImplementation implements userDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProverbUser findUser(String theUsername) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<ProverbUser> theQuery= currentSession.createQuery("from ProverbUser where userName=:uName",ProverbUser.class);

        theQuery.setParameter("uName",theUsername);

        ProverbUser theUser= null;

        try {
            theUser = theQuery.getSingleResult();
        }catch (Exception e){
            theUser =null;
        }

        return theUser;


    }

    @Override
    public void saveUser(ProverbUser proverbUser) {
    Session currentSession= sessionFactory.getCurrentSession();

    currentSession.saveOrUpdate(proverbUser);
    }
}
