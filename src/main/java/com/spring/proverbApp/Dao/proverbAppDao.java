package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.Proverbs;

import java.util.List;

public interface proverbAppDao {
    public  void saveProverb(Proverbs theProverb);
    public List<Proverbs> getProverbs();
    public Proverbs updateProverb(int theId);
    public void deleteProverb(int theId);
}
