package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.ItemDTO;
import com.pedro.ordermanager.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping
    public List<ItemDTO> getItems(){
        return service.get();
    }
}
