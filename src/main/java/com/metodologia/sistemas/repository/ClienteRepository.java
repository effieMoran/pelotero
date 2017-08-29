package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
