package com.example.demojpa.incident.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class IncidentDto {

    private int id;
    @NotEmpty
    private String title;
    @NotNull
    private int userId;
    public IncidentDto(int id, String title, int userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
