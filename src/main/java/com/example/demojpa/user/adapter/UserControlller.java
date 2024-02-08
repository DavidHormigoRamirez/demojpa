package com.example.demojpa.user.adapter;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demojpa.core.exception.UserAlreadyExistsException;
import com.example.demojpa.user.domain.UpdatableUserEntity;
import com.example.demojpa.user.domain.UserEntity;
import com.example.demojpa.user.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("api/users")
public class UserControlller {

    private UserService service;

    public UserControlller(UserService service) {
        this.service = service;
    }

    
    @GetMapping()
    public Iterable<UserEntity> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserDetails(@PathVariable int id) {
        return this.service.getOne(id);
    }
    

    @PostMapping()
    public UserEntity createUser(@RequestBody UserEntity entity) {
        
        UserEntity newUser;
        try {
           newUser= service.create(entity);
            
        } catch (UserAlreadyExistsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Ya existe el correo para otro usuario");

        }
        return newUser;
        
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.delete(id);
    }


    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable int id, @RequestBody UpdatableUserEntity entity) {
        try {
            return service.update(id, entity);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el usuario con el id");
        }
        
    }

    
    
}
