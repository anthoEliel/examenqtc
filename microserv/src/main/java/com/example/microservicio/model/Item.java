package com.example.microservicio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Item {
    private int idItem;
    private double rating;
    private String title;
    private Review review;

    public Item() {

    }
}
