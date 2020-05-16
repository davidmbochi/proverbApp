package com.spring.proverbApp.service;

import com.spring.proverbApp.Dao.proverbAppDao;
import com.spring.proverbApp.entity.Proverbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class proverbAppServiceImplementation implements proverbAppService {
    @Autowired
    private proverbAppDao proverbAppDao;

    @Override
    @Transactional
    public void saveProverb(Proverbs theproverb) {

        proverbAppDao.saveProverb(theproverb);

    }

    @Override
    @Transactional
    public List<Proverbs> getProverbs() {
        return proverbAppDao.getProverbs();
    }

    @Override
    @Transactional
    public Proverbs getProverb(int theId) {
        return proverbAppDao.getProverb(theId);
    }

    @Override
    @Transactional
    public void deleteProverb(int theId) {
       proverbAppDao.deleteProverb(theId);
    }
}
