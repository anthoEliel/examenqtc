package com.example.microservicio.dao;

import com.example.microservicio.model.Item;
import com.example.microservicio.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {
    private List<Item> items;
    private List<Review> reviews;

    public ItemRepository() {
        items = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public List<Item> findItemsWithAverageRatingLowerThan(Double rating) {
        List<Item> result = new ArrayList<>();

        for (Item item : items) {
            double itemRating = calculateItemRating(item);
            if (itemRating < rating) {
                result.add(item);
            }
        }

        return result;
    }

    //Promedio rating en review
    private double calculateItemRating(Item item) {
        List<Review> itemReviews = getItemReviews(item);
        if (itemReviews.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        int reviewCount = 0;
        for (Review review : itemReviews) {
            totalRating += review.getRating();
            reviewCount++;
        }

        return totalRating / reviewCount;
    }

    private List<Review> getItemReviews(Item item) {
        List<Review> itemReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getIdReview() == item.getIdItem()) {
                itemReviews.add(review);
            }
        }
        return itemReviews;
    }
}
