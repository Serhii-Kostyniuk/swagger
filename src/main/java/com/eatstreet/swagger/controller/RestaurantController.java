package com.eatstreet.swagger.controller;

import com.eatstreet.swagger.exeption.RestaurantNotFoundException;
import com.eatstreet.swagger.model.Restaurant;
import com.eatstreet.swagger.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v2/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable Integer id) {
        return restaurantService.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException());
    }

    @GetMapping("/")
    public Collection<Restaurant> findAll() {
        return restaurantService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant updateRestaurant(
            @PathVariable("id") final Integer id, @RequestBody final Restaurant restaurant) {
        return restaurant;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant saveRestaurant(@RequestBody final Restaurant restaurant) {
        return restaurant;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer deleteRestaurant(@PathVariable("id") final Integer id) {
        return id;
    }
}