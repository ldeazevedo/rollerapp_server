package com.atiq.rollerapp.controller;

import com.atiq.rollerapp.model.Place;
import com.atiq.rollerapp.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/place")
public class PlaceController {

    private final Logger log = LoggerFactory.getLogger(PlaceController.class);
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Place>> getAllPlaces() {
        log.info("About to get all places...");
        List<Place> places = placeService.getAllPlaces();
        log.info("Done!");
        return ResponseEntity.ok(places);
    }
}