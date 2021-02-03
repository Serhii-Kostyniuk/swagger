package com.eatstreet.swagger.controller;

import com.eatstreet.swagger.exeption.ZoneNotFoundException;
import com.eatstreet.swagger.model.Zone;
import com.eatstreet.swagger.service.ZoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/v2/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;


    @Operation(summary = "Find a zone", description = "Find a zone by id")
    @ApiResponse(content = @Content(mediaType = "text/plain", schema = @Schema(type = "zone")))
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "404", description = "Zone not found")
    @Tag(name = "Zone")
    @GetMapping("/{id}")
    public Zone findById(@PathVariable Integer id) {
        return zoneService.findById(id)
                .orElseThrow(() -> new ZoneNotFoundException());
    }

    @Tag(name = "Zone")
    @GetMapping("/")
    public Collection<Zone> findAll() {
        return zoneService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Zone updateZone(
            @PathVariable("id") final Integer id, @RequestBody final Zone Zone) {
        return Zone;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Zone saveZone(@RequestBody final Zone Zone) {
        return Zone;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer deleteZone(@PathVariable("id") final Integer id) {
        return id;
    }
}