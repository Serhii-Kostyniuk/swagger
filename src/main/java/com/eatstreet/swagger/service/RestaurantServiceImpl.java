package com.eatstreet.swagger.service;

import com.eatstreet.swagger.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static int id = 1;

    @Override
    public Optional<Restaurant> findById(long id) {
        return Optional.of(getRestaurant());
    }

    @Override
    public Collection<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(getRestaurant());
        restaurants.add(getRestaurant());

        return restaurants;
    }

    private Restaurant getRestaurant() {
        Restaurant restaurant = new Restaurant();

        restaurant.setName("testName" + id);
        restaurant.setAddress("test");
        restaurant.setId(id++);
        restaurant.setPhone("+232323333");

        return restaurant;
    }
}
