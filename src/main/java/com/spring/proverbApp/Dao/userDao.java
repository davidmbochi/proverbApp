package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.ProverbUser;

public interface userDao {
    ProverbUser findUser(String theUsername);
    void saveUser(ProverbUser proverbUser);
}
