package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.LineaDeFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaFacturaRepository extends JpaRepository<LineaDeFactura, Integer> {
    LineaDeFactura findById(int id);
}
