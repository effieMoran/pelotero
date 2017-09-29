package com.metodologia.sistemas.repository;


import com.metodologia.sistemas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Usuario, Integer>
{
    Usuario findById(int id);

    @Query("select u from Usuario u where u.username = ?1")
    Usuario findByUsername(String username);
}
