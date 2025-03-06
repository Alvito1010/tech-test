package com.techtest.testbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtest.testbe.models.Pelajaran;

@Repository
public interface PelajaranRepository extends JpaRepository<Pelajaran, Integer> {

    Optional<Pelajaran> findByIdAndDeleted (Integer id, boolean deleted);

    Optional<List<Pelajaran>> findByDeleted (boolean deleted);
    
} 