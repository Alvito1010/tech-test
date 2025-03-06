package com.techtest.testbe.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtest.testbe.models.Negara;
import com.techtest.testbe.models.Provinsi;
import com.techtest.testbe.services.ProvinsiService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/provinsi")
public class ProvinsiController {
    @Autowired
    private ProvinsiService provinsiSvc;

    @GetMapping("")
    public ResponseEntity <?> getAll() {
        try {
            List <Provinsi> data = provinsiSvc.getAll();

            if (data.size()>0){
                return new ResponseEntity<List<Provinsi>>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Provinsi>>(data, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/negaraid/{negaraId}")
    public ResponseEntity <?> getByNegaraId(@PathVariable Integer negaraId) {
        try {
            Optional<List <Provinsi>> data = provinsiSvc.getByNegaraId(negaraId);

            if (data.isPresent()){
                return new ResponseEntity<Optional<List<Provinsi>>>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<Optional<List<Provinsi>>>(data, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
