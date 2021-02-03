package com.eatstreet.swagger.service;

import com.eatstreet.swagger.model.Zone;

import java.util.Collection;
import java.util.Optional;

public interface ZoneService {
    Optional<Zone> findById(long id);

    Collection<Zone> getAll();
}
