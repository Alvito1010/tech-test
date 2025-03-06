package com.techtest.testbe.controllers;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtest.testbe.models.Pelajaran;
import com.techtest.testbe.services.PelajaranService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("api/pelajaran")
public class PelajaranController {
    @Autowired
    private PelajaranService pelajaranSvc;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            List<Pelajaran> data = pelajaranSvc.getAll();

            if (data.size()>0){
                return new ResponseEntity<List<Pelajaran>>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Pelajaran>>(data, HttpStatus.NO_CONTENT);

            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<Pelajaran> data = pelajaranSvc.getById(id);

            if (data.isPresent()){
                return new ResponseEntity<Pelajaran>(data.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<Pelajaran>(data.get(), HttpStatus.NO_CONTENT);

            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody final Pelajaran data) {
        try {
            Pelajaran newPelajaran = pelajaranSvc.create(data);
            return new ResponseEntity<Pelajaran> (newPelajaran, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity <String> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("")
    public ResponseEntity <?> update(@RequestBody final Pelajaran data){
        try {
                return new ResponseEntity <Pelajaran> (pelajaranSvc.update(data), HttpStatus.OK);
            
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity <String> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> delete(@PathVariable Integer id){
        try {
            Pelajaran data = pelajaranSvc.delete(id);

            if (data.isDeleted()){
                return new ResponseEntity<Pelajaran>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Failed to delete pelajaran", HttpStatus.BAD_REQUEST);

            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }

    
}
