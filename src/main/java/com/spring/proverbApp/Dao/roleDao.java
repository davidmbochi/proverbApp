package com.spring.proverbApp.Dao;

import com.spring.proverbApp.entity.UserRole;

public interface roleDao {
    public UserRole findRole(String theRoleName);
}
