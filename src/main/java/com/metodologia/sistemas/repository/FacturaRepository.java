package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer>{
    Factura findById(int id);
}
