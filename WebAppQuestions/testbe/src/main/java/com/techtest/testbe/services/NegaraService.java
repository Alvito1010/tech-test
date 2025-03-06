package com.techtest.testbe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techtest.testbe.models.Negara;
import com.techtest.testbe.repositories.NegaraRepository;

@Service
public class NegaraService {
    private NegaraRepository negaraRepo;
    private Optional <Negara> negaraExisting;

    public NegaraService(NegaraRepository negaraRepo) {
        this.negaraRepo = negaraRepo;
    }

    public List<Negara> getAll(){
        try {
            return negaraRepo.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }
}
