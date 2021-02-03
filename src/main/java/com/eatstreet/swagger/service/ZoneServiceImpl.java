package com.eatstreet.swagger.service;

import com.eatstreet.swagger.model.Zone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements ZoneService {

    private static int id = 1;

    @Override
    public Optional<Zone> findById(long id) {
        return Optional.of(getZone());
    }

    @Override
    public Collection<Zone> getAll() {
        List<Zone> zones = new ArrayList<>();
        zones.add(getZone());
        zones.add(getZone());

        return zones;
    }

    private Zone getZone() {
        Zone zone = new Zone();

        zone.setName("testName" + id);
        zone.setRadius(id++);
        zone.setId(id++);

        return zone;
    }
}
