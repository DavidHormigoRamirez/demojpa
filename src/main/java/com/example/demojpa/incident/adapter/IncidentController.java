package com.example.demojpa.incident.adapter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demojpa.core.exception.UserDoesNotExistsException;
import com.example.demojpa.incident.domain.IncidentDto;
import com.example.demojpa.incident.domain.IncidentEntity;
import com.example.demojpa.incident.service.IncidentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class IncidentController {

    private final IncidentService service;

    public IncidentController(IncidentService service) {
        this.service = service;
    }
    
    /*@PostMapping(path="/api/incidents", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<IncidentEntity> createIncident(@RequestPart("incident") IncidentEntity incident,@RequestPart("image") MultipartFile image) {

        try {
            InputStream is = image.getInputStream();
            byte[] fileArray = is.readAllBytes();
            String contentType = image.getContentType();

            incident.setImage(fileArray);
            incident.setImageType(contentType);
            IncidentEntity createdEntity = this.service.createIncident(incident);
            return new ResponseEntity<IncidentEntity>(createdEntity, HttpStatus.CREATED);



        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        
    }*/

    @PostMapping("/api/incidents")
    public IncidentEntity postMethodName(@Valid @RequestBody IncidentDto entity,Errors errors) {
  
        if (errors.hasErrors())
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Hay errores");
        }
        try {
            IncidentEntity newIncident = service.createIncident(entity);
            return newIncident;
        } catch (UserDoesNotExistsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"El usuario no existe");
        }
        

       
        
    }
    
    
}
