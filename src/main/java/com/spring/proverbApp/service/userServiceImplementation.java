package com.spring.proverbApp.service;

import com.spring.proverbApp.Dao.roleDao;
import com.spring.proverbApp.Dao.userDao;
import com.spring.proverbApp.entity.ProverbUser;
import com.spring.proverbApp.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class userServiceImplementation implements userService {

    @Autowired
    private userDao userDao;

    @Autowired
    private roleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public ProverbUser findUser(String theUsername) {
        return userDao.findUser(theUsername);
    }

    @Override
    @Transactional
    public void saveUser(ProverbUser proverbUser) {
        ProverbUser proverbUser1 = new ProverbUser();

        proverbUser1.setUsername(proverbUser.getUsername());
        proverbUser1.setPassword(bCryptPasswordEncoder.encode(proverbUser.getPassword()));
        proverbUser1.setFirstName(proverbUser.getFirstName());
        proverbUser1.setLastName(proverbUser.getLastName());
        proverbUser1.setEmail(proverbUser.getEmail());
        proverbUser1.setUserRoles(Arrays.asList(roleDao.findRole("ROLE_EMPLOYEE")));

        userDao.saveUser(proverbUser1);


    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ProverbUser user= userDao.findUser(userName);

        if(user == null){
            throw  new UsernameNotFoundException("invalid username or password");
        }

        return new User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getUserRoles()) );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> userRoles){
        return userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getName())).collect(Collectors.toList());
    }
}
