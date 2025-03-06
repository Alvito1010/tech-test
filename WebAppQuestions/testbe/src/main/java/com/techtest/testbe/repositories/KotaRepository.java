package com.techtest.testbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtest.testbe.models.Kota;

@Repository
public interface KotaRepository extends JpaRepository<Kota, Integer>{

    List<Kota> findAll ();
    Page<Kota> findAll(Pageable pageable);
    Optional<List<Kota>> findByProvinsiId(Integer provinsiId);
} 