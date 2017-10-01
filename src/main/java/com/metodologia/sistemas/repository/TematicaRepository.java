package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Tematica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TematicaRepository extends JpaRepository<Tematica, Integer> {
    Tematica findById(int id);
}
