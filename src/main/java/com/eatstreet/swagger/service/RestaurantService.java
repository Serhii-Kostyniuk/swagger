package com.eatstreet.swagger.service;

import com.eatstreet.swagger.model.Restaurant;

import java.util.Collection;
import java.util.Optional;

public interface RestaurantService {
    Optional<Restaurant> findById(long id);

    Collection<Restaurant> getAll();
}
