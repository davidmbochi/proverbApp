package com.spring.proverbApp.service;

import com.spring.proverbApp.entity.Proverbs;

import java.util.List;

public interface proverbAppService {
    public void saveProverb(Proverbs theproverb);
    public List<Proverbs> getProverbs();
    public Proverbs getProverb(int theId);
    public void deleteProverb(int theId);
}
