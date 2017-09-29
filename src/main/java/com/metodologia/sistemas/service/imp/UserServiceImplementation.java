package com.metodologia.sistemas.service.imp;

import com.metodologia.sistemas.entity.Usuario;
import com.metodologia.sistemas.repository.UserRepository;
import com.metodologia.sistemas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(Usuario user) {
        userRepository.save(user);
    }

    @Override
    public Usuario findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    @Override
    public void updateUser(int id, Usuario user) {
        //TODO: UPDATE USER
    }

    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean passwordMatch(String password, String username) {
        return true;
        //return password.equals(userRepository.findByUsername(username).getPassword());
    }

    @Override
    public Usuario findByUsername(String username) {
        //return null;
        return userRepository.findByUsername(username);
    }
}
