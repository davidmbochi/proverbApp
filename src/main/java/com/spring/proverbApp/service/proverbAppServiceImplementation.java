package com.spring.proverbApp.service;

import com.spring.proverbApp.Dao.proverbAppDao;
import com.spring.proverbApp.entity.Proverbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class proverbAppServiceImplementation implements proverbAppService {
    @Autowired
    private proverbAppDao proverbAppDao;

    @Override
    public void saveProverb(Proverbs theproverb) {

        proverbAppDao.saveProverb(theproverb);

    }
}
