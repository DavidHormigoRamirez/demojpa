package com.example.demojpa.incident.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demojpa.core.exception.UserDoesNotExistsException;
import com.example.demojpa.incident.domain.IncidentDto;
import com.example.demojpa.incident.domain.IncidentEntity;
import com.example.demojpa.incident.domain.IncidentRepository;
import com.example.demojpa.user.domain.UserEntity;
import com.example.demojpa.user.domain.UserRepository;

@Service
public class IncidentServiceImpl implements IncidentService {


    private final IncidentRepository incidentRepository;
    private final UserRepository userRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository, UserRepository userRepository) {
        this.incidentRepository = incidentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public IncidentEntity createIncident(IncidentDto newIncident) {

        int userId = newIncident.getUserId();
        UserEntity userEntity = this.userRepository.findById(userId).orElseThrow(() -> new UserDoesNotExistsException());

        IncidentEntity incidentEntity = new IncidentEntity();
        BeanUtils.copyProperties(newIncident, incidentEntity,"userId");
        incidentEntity.setUser(userEntity);

        
        return this.incidentRepository.save(incidentEntity);
        
    }
    @Override
    public boolean userExists(int id) {
        
        return this.userRepository.existsById(id);
    }
    
}
