package com.techtest.testbe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtest.testbe.models.Negara;

@Repository
public interface NegaraRepository extends JpaRepository<Negara, Integer> {

}
