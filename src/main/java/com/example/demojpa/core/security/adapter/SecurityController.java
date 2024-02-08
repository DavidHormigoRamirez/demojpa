package com.example.demojpa.core.security.adapter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.user.domain.UserEntity;
import com.example.demojpa.user.service.UserService;



@RestController
public class SecurityController {
    
    private final UserService service;
    //@Autowired
    private PasswordEncoder encoder;
    public SecurityController(UserService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity entity) {
        //String encodedPassword = this.encoder.encode(entity.getPassword());
        //System.out.println("La contraseña codificada es " + encodedPassword);
        //entity.setPassword(encodedPassword);
        return service.create(entity);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(CsrfToken token) {
        return token;
    }
    
    
}
