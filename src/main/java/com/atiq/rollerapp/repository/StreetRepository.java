package com.atiq.rollerapp.repository;

import com.atiq.rollerapp.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {

    List<Street> getAllByIdGreaterThan(Long streetId);
}