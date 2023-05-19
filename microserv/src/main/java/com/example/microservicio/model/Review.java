package com.example.microservicio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Review {
    private int idReview;
    private Double rating;
    private User user;

    public Review() {

    }
}
