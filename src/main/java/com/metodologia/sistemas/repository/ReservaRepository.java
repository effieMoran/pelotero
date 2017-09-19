package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
