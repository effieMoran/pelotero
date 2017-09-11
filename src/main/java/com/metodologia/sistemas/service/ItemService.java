package com.metodologia.sistemas.service;

import com.metodologia.sistemas.entity.Item;

import java.util.List;

public interface ItemService {
    void save(Item item);
    Item findById(int id);
    void delete(int id);
    void update(int id, Item item);
    List<Item> findAll();

}
