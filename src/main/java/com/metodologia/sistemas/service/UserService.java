package com.metodologia.sistemas.service;

import com.metodologia.sistemas.entity.Usuario;

import java.util.List;

public interface UserService {

    void saveUser(Usuario user);
    Usuario findById(int id);
    void deleteUser(int id);
    void updateUser(int id, Usuario user);
    List<Usuario> findAll();
    boolean passwordMatch(String password, String username);
    Usuario findByUsername(String username);
}
