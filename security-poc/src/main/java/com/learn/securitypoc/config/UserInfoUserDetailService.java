package com.learn.securitypoc.config;

import com.learn.securitypoc.entity.UserEntity;
import com.learn.securitypoc.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userInfoRepository.findByName(username);
        return user.map(UserInfoUserDetail::new)
                .orElseThrow( () -> new UsernameNotFoundException("user not found with name"+ username));


    }
}
