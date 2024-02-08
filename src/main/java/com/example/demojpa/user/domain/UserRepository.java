package com.example.demojpa.user.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {

    public Optional<UserEntity> findByEmail(String email);


    public boolean existsByEmail(String email);

    public UserEntity findByNameAndSurname1IgnoreCase(String name, String surname1);

}
