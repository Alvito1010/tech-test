package com.techtest.testbe.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techtest.testbe.models.Negara;
import com.techtest.testbe.models.Pelajaran;
import com.techtest.testbe.repositories.PelajaranRepository;

@Service
public class PelajaranService {
    private PelajaranRepository pelajaranRepo;
    private Optional <Pelajaran> pelajaranExisting;

    public PelajaranService(PelajaranRepository pelajaranRepo) {
        this.pelajaranRepo = pelajaranRepo;
    }

    public List<Pelajaran> getAll(){
        try {
            return pelajaranRepo.findByDeleted(false).get();
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Optional<Pelajaran> getById(Integer id){
        try {
            return pelajaranRepo.findByIdAndDeleted(id, false);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Pelajaran create(Pelajaran data) throws Exception {
            return pelajaranRepo.save(data);
            
        
    }

    public Pelajaran update(Pelajaran data) throws Exception{
       pelajaranExisting = pelajaranRepo.findById(data.getId());
        if (pelajaranRepo.findById(data.getId()).isPresent()){

            return pelajaranRepo.save(data);
        } else {

            // TODO Auto-generated method stub
            throw new Exception("Pelajaran doesn't exist!");
        }
    }

    public Pelajaran delete(int id) throws Exception{
        pelajaranExisting = pelajaranRepo.findById(id);
        
       if(pelajaranExisting.isPresent()){
        pelajaranExisting.get().setDeleted(true);
        return pelajaranRepo.save(pelajaranExisting.get());
       } else {
        throw new Exception("doesnt exist");
       }
    }
}
