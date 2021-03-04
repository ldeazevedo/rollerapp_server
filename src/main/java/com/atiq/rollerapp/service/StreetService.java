package com.atiq.rollerapp.service;

import com.atiq.rollerapp.model.Street;
import com.atiq.rollerapp.repository.StreetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    private final Logger log = LoggerFactory.getLogger(StreetService.class);
    private final StreetRepository streetRepository;

    public StreetService(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    public List<Street> getAllStreets() {
        List<Street> streets = streetRepository.findAll();
        log.info("Streets count: {}", streets.size());
        return streets;
    }

    public List<Street> getAllStreetsGreaterThan(Long streetId) {
        List<Street> streets = streetRepository.getAllByIdGreaterThan(streetId);
        log.info("Streets count: {}", streets.size());
        return streets;
    }
}
