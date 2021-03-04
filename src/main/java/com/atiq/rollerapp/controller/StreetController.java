package com.atiq.rollerapp.controller;

import com.atiq.rollerapp.model.Street;
import com.atiq.rollerapp.service.StreetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/street")
public class StreetController {

    private final Logger log = LoggerFactory.getLogger(StreetController.class);

    private final StreetService streetService;

    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Street>> getAllStreets() {
        log.info("About to get all streets...");
        List<Street> allStreets = streetService.getAllStreets();
        log.info("Done!");
        return ResponseEntity.ok(allStreets);
    }

    @GetMapping("greaterthan/{street_id}")
    public ResponseEntity<List<Street>> getAllStreetsGreaterThan(@PathVariable("street_id") Long streetId) {
        log.info("About to get streets greater than {} ...", streetId);
        List<Street> allStreets = streetService.getAllStreetsGreaterThan(streetId);
        log.info("Done!");
        return ResponseEntity.ok(allStreets);
    }
}