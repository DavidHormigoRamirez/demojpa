package com.example.demojpa.incident.service;

import com.example.demojpa.incident.domain.IncidentDto;
import com.example.demojpa.incident.domain.IncidentEntity;

public interface IncidentService {

    
    public IncidentEntity createIncident(IncidentDto newIncident);
    public boolean userExists(int id);
    
}