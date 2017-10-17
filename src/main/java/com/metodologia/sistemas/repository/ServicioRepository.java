package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    Servicio findById(int id);
}
