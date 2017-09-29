package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Fiesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;


public interface FiestaRespository extends JpaRepository<Fiesta, Integer>{

    Fiesta findById(int id);

    @Query(value = "SELECT FROM FIESTA WHERE FECHA.MONTH = ?0", nativeQuery = true)
    Fiesta findByFecha(Date fecha);
}
