package com.example.demojpa.user.service;
import org.springframework.lang.NonNull;

import com.example.demojpa.user.domain.UserEntity;

public interface UserService {

    public Iterable<UserEntity> getAll();
    public UserEntity getOne(int id);
    public UserEntity create(UserEntity entity);
    public void delete(int id);
    public UserEntity update(int id, @NonNull UserEntity entity);
    
}
