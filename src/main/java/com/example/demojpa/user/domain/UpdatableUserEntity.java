package com.example.demojpa.user.domain;


public class UpdatableUserEntity extends UserEntity {
    
    private String name;
    private String surname1;
    private String surname2;
    private String role;

    public UpdatableUserEntity(String name, String surname1, String surname2, String role) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.role = role;
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
}