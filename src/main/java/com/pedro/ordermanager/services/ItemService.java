package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.ItemDTO;
import com.pedro.ordermanager.model.Item;
import com.pedro.ordermanager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<ItemDTO> get(){
        return convertData(repository.findAll());
    }

    private List<ItemDTO> convertData(List<Item> items){
        return items.stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }
}
