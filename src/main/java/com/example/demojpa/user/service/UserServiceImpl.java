package com.example.demojpa.user.service;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demojpa.core.exception.UserAlreadyExistsException;
import com.example.demojpa.core.exception.UserDoesNotExistsException;
import com.example.demojpa.user.domain.UserEntity;
import com.example.demojpa.user.domain.UserRepository;

@Service
public class UserServiceImpl implements UserService  {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository,PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public Iterable<UserEntity> getAll() {
        
        return repository.findAll();
    }

    
    @Override
    public UserEntity create(UserEntity entity) throws UserAlreadyExistsException {
        
        if (repository.existsByEmail(entity.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        String encodedPassword = this.encoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        return repository.save(entity);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    
    @Override
    public UserEntity update(int id, @NonNull UserEntity updatedUser) {
    
       UserEntity oldUser = repository.findById(id).orElseThrow(
        () -> new UserDoesNotExistsException()
       );
      
       BeanUtils.copyProperties(updatedUser,oldUser,"email","id");

       return repository.save(oldUser);
    }


    @Override
    public UserEntity getOne(int id) {
        return this.repository.findById(id).orElseThrow(
            () -> new UserDoesNotExistsException());
    }

}
