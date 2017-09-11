package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findById(int id);

}
