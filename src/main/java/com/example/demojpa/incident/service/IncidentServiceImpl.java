package com.example.demojpa.incident.service;

import org.springframework.stereotype.Service;

import com.example.demojpa.incident.domain.IncidentEntity;
import com.example.demojpa.incident.domain.IncidentRepository;

@Service
public class IncidentServiceImpl implements IncidentService {


    private final IncidentRepository repository;

    public IncidentServiceImpl(IncidentRepository repository) {
        this.repository = repository;
    }
    @Override
    public IncidentEntity createIncident(IncidentEntity newIncident) {
        
        return this.repository.save(newIncident);
        
    }
    
}
