package com.techtest.testbe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techtest.testbe.models.Kota;
import com.techtest.testbe.models.Provinsi;
import com.techtest.testbe.repositories.KotaRepository;
import com.techtest.testbe.repositories.KotaRepository;

@Service
public class KotaService {
    private KotaRepository kotaRepo;
    private Optional <Kota> kotaExisting;

    public KotaService(KotaRepository kotaRepo) {
        this.kotaRepo = kotaRepo;
    }

    public List<Kota> getAll(){
        try {
            return kotaRepo.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Page<Kota> getAllPaginated(Pageable pageable){
        try {
            return kotaRepo.findAll(pageable);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }


    public Optional<List<Kota>> getByProvinsiId(Integer provinsiId){
        try {
            return kotaRepo.findByProvinsiId(provinsiId);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }
}
