package com.example.demojpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demojpa.core.exception.UserAlreadyExistsException;
import com.example.demojpa.user.domain.UserEntity;
import com.example.demojpa.user.service.UserService;

@SpringBootApplication
public class DemojpaApplication implements CommandLineRunner {

	
	private final UserService service;

	public DemojpaApplication(UserService service) {
		this.service = service;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		UserEntity admin = new UserEntity("dhorram948@g.educaand.es", "David", "Hormigo", "Ramírez", "ADMIN","secret");
	try {
		this.service.create(admin);
	} catch (UserAlreadyExistsException e) {
		// TODO: handle exception
	}
		
	}

}
