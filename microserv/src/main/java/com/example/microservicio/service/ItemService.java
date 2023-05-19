package com.example.microservicio.service;

import com.example.microservicio.dao.ItemRepository;
import com.example.microservicio.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getTitles(Double rating) {
        List<Item> items = itemRepository.findItemsWithAverageRatingLowerThan(rating);
        List<String> titles = new ArrayList<>();

        for (Item item : items) {
            titles.add(item.getTitle());
        }
//fin
        return titles;
    }
}
