package com.techtest.testbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtest.testbe.models.Provinsi;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer>{

    Optional <List<Provinsi>> findByNegaraId(Integer negaraId);
    List<Provinsi> findAll();
}
