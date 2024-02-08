package com.example.demojpa.incident.adapter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demojpa.incident.domain.IncidentEntity;
import com.example.demojpa.incident.service.IncidentService;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;


@RestController
public class IncidentController {

    private final IncidentService service;

    public IncidentController(IncidentService service) {
        this.service = service;
    }
    
    @PostMapping(path="/api/incidents", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
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
        
    }
    
}
