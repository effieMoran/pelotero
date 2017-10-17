package com.metodologia.sistemas.service.imp;

import com.metodologia.sistemas.entity.Rol;
import com.metodologia.sistemas.entity.Usuario;
import com.metodologia.sistemas.repository.RolRepository;
import com.metodologia.sistemas.repository.UserRepository;
import com.metodologia.sistemas.service.RolService;
import com.metodologia.sistemas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplementation implements RolService{

        @Autowired
        RolRepository rolRepository;

    @Override
    public Rol findByRolname(String rolname) {
        return null;
    }

    @Override
    public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public Rol findById(int id) {
        return rolRepository.findById(id);
    }

    @Override
    public void deleteRol(int id) {
        rolRepository.delete(id);
    }

    @Override
    public void updateRol(int id, Rol rol) {
        rol.setId(id);
        rolRepository.save(rol);
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

}
