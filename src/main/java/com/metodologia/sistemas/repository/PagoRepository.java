package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    Pago findById(int id);
}
