package com.sjsu.vansbackend.security;

import com.sjsu.vansbackend.userModel.UserEntity;
import com.sjsu.vansbackend.userModel.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = Optional.ofNullable(userService.getUser(email));

        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.map(UserInfoDetails::new).get();


    }
}
