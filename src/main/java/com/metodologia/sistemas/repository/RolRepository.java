package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<Rol, Integer>{

    Rol findById(int id);

    @Query("select u from Rol u where u.name = ?1")
    Rol findByRolname(String name);

}
