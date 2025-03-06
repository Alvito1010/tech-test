package com.techtest.testbe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtest.testbe.models.Negara;
import com.techtest.testbe.services.NegaraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("*")
@RequestMapping("api/negara")
public class NegaraController {
    @Autowired
    private NegaraService negaraSvc;

    @GetMapping("")
    public ResponseEntity <?> getAll() {
        try {
            List <Negara> data = negaraSvc.getAll();

            if (data.size()>0){
                return new ResponseEntity<List<Negara>>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Negara>>(data, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    
}
