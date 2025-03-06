package com.techtest.testbe.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtest.testbe.models.Kota;
import com.techtest.testbe.services.KotaService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/kota")
public class KotaController {
    @Autowired
    private KotaService kotaSvc;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            List<Kota> data = kotaSvc.getAll();

            if (!data.isEmpty()) {
                return new ResponseEntity<>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/paginated/{page}/{size}")
    public ResponseEntity<?> getAllPaginated(@PathVariable int page, @PathVariable int size) {
        try {
            final Page<Kota> data = kotaSvc.getAllPaginated(PageRequest.of(page, size));

                return new ResponseEntity<Page<Kota>>(data, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/provinsiid/{provinsiId}")
    public ResponseEntity<?> getByProvinsiId(@PathVariable Integer provinsiId) {
        try {
            Optional<List<Kota>> data = kotaSvc.getByProvinsiId(provinsiId);

            if (!data.isEmpty()) {
                return new ResponseEntity<>(data, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
