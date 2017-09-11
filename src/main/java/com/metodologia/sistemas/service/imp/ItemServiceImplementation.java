package com.metodologia.sistemas.service.imp;


import com.metodologia.sistemas.entity.Item;
import com.metodologia.sistemas.repository.ItemRepository;
import com.metodologia.sistemas.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImplementation implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        itemRepository.delete(id);
    }

    @Override
    public void update(int id, Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }


}
