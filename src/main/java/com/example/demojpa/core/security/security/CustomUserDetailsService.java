package com.example.demojpa.core.security.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demojpa.user.domain.UserEntity;
import com.example.demojpa.user.domain.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity userEntity = this.repository.findByEmail(username).orElseThrow(
            () -> new UsernameNotFoundException(username)
        );

        UserDetails userDetails = User.builder()
                                      .username(userEntity.getEmail())
                                      .password(userEntity.getPassword())
                                      //.roles("ADMIN")
                                      .roles(userEntity.getRole())
                                     .build();
        return userDetails;


    }
    
}
