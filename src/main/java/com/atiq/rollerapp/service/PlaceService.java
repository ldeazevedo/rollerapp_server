package com.atiq.rollerapp.service;

import com.atiq.rollerapp.model.Place;
import com.atiq.rollerapp.repository.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final Logger log = LoggerFactory.getLogger(PlaceService.class);
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository streetRepository) {
        this.placeRepository = streetRepository;
    }

    public List<Place> getAllPlaces() {
        List<Place> streets = placeRepository.findAll();
        log.info("Places count: {}", streets.size());
        return streets;
    }
}