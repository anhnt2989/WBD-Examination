package com.codegym.exam.repository;

import com.codegym.exam.model.City;

import com.codegym.exam.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Page<City> findAllByNameContainingOrDescriptionContaining(
            String name, String des, Pageable pageable);

    Page<City> findAllByNation(Nation nation, Pageable pageable);
}
