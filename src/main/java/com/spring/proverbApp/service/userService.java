package com.spring.proverbApp.service;

import com.spring.proverbApp.entity.ProverbUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface userService  extends UserDetailsService {
     public ProverbUser findUser(String theUsername);
     public void saveUser(ProverbUser proverbUser);
}
