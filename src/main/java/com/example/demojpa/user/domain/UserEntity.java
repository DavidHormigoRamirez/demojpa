package com.example.demojpa.user.domain;

import java.util.Set;

import com.example.demojpa.incident.domain.IncidentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true,nullable = false,updatable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    private String surname1;
    private String surname2;
    private String role;
    @OneToMany(targetEntity = IncidentEntity.class,mappedBy = "user")
    private Set<IncidentEntity> incidents;
    private String password;

    

    public UserEntity(String email, String name, String surname1, String surname2, String role, String password) {
        this.email = email;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.role = role;
        this.password = password;
    }
    protected UserEntity() {

    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname1() {
        return surname1;
    }
    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }
    public String getSurname2() {
        return surname2;
    }
    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    
   /*  public Set<IncidentEntity> getIncidents() {
        return incidents;
    }*/
    
}


