package com.metodologia.sistemas.service.imp;


import com.metodologia.sistemas.entity.Combo;
import com.metodologia.sistemas.repository.ComboRepository;
import com.metodologia.sistemas.service.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComboServiceImplementation implements ComboService{

    @Autowired
    ComboRepository comboRepository;

    @Override
    public void save(Combo combo) {
        comboRepository.save(combo);
    }

    @Override
    public Combo findById(int id) {
        return comboRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        comboRepository.delete(id);
    }

    @Override
    public void update(int id, Combo combo) {
        comboRepository.save(combo);
    }

    @Override
    public List<Combo> findAll() {
        return comboRepository.findAll();
    }

}
