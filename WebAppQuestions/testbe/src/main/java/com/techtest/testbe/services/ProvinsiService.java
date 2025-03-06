package com.techtest.testbe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techtest.testbe.models.Negara;
import com.techtest.testbe.models.Provinsi;
import com.techtest.testbe.repositories.ProvinsiRepository;

@Service
public class ProvinsiService {
    private ProvinsiRepository provinsiRepo;
    private Optional <Provinsi> provinsiExisting;

    public ProvinsiService(ProvinsiRepository provinsiRepo) {
        this.provinsiRepo = provinsiRepo;
    }

    public List<Provinsi> getAll(){
        try {
            return provinsiRepo.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }


    public Optional<List<Provinsi>> getByNegaraId(Integer negaraId){
        try {
            return provinsiRepo.findByNegaraId(negaraId);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }
}
