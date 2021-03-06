package com.metodologia.sistemas.service;

import com.metodologia.sistemas.entity.Combo;

import java.util.List;

public interface ComboService {
    void save(Combo combo);
    Combo findById(int id);
    void delete(int id);
    void update(int id, Combo combo);
    List<Combo> findAll();
}
