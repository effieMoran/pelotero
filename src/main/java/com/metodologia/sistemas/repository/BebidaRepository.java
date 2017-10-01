package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Integer> {
    Bebida findById(int id);
}
