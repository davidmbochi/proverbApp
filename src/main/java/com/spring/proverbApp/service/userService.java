package com.spring.proverbApp.service;

import com.spring.proverbApp.entity.ProverbUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface userService  extends UserDetailsService {
     ProverbUser findUser(String theUsername);
     void saveUser(ProverbUser proverbUser);
}
