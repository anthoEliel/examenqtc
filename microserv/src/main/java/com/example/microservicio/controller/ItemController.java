package com.example.microservicio.controller;

import java.util.List;

import com.example.microservicio.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/titles")
    public List<String> getTitles(@RequestParam("rating") Double rating) {
        return itemService.getTitles(rating);
    }
}
