package com.metodologia.sistemas.repository;


import com.metodologia.sistemas.entity.Combo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComboRepository extends JpaRepository<Combo, Integer> {

    Combo findById(int id);
}
