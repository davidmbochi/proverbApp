package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class roleDaoImplementation implements roleDao {

    @Autowired
    @Qualifier("localSessionFactoryBeanSecurity")
    SessionFactory sessionFactory;

    @Override
    public UserRole findRole(String theRoleName) {

        Session currentSession= sessionFactory.getCurrentSession();

        Query<UserRole> theQuery=currentSession.createQuery("from UserRole where name =:roleName",UserRole.class);

        theQuery.setParameter("roleName",theRoleName);

        UserRole theUserRole= null;
        try {
            theUserRole = theQuery.getSingleResult();
        }catch (Exception e){
            theUserRole=null;
        }

        return theUserRole;

    }
}
