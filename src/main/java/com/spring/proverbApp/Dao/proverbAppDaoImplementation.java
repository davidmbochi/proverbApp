package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.Proverbs;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class proverbAppDaoImplementation implements proverbAppDao {
    @Override
    @Transactional
    public void saveProverb(Proverbs theProverb) {

    }
}
