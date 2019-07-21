package com.codegym.exam.service;

import com.codegym.exam.model.City;
import com.codegym.exam.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

    Page<City> findAllByNameContainingOrDescriptionContaining(String name, String des, Pageable pageable);

    Page<City> findAllByNation(Nation nation, Pageable pageable);

    Page<City> findAll(Pageable pageable);

    City findById(Long id);

    void save(City city);

    void remove(Long id);
}
