package com.codegym.exam.service.impl;

import com.codegym.exam.model.City;
import com.codegym.exam.model.Nation;
import com.codegym.exam.repository.CityRepository;
import com.codegym.exam.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public Page<City> findAllByNameContainingOrDescriptionContaining(String name, String des, Pageable pageable) {
        return cityRepository.findAllByNameContainingOrDescriptionContaining(name, des, pageable);
    }

    @Override
    public Page<City> findAllByNation(Nation nation, Pageable pageable) {
        return cityRepository.findAllByNation(nation, pageable);
    }
}
