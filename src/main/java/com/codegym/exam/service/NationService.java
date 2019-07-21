package com.codegym.exam.service;

import com.codegym.exam.model.Nation;

public interface NationService {
    Iterable<Nation> findAll();

    Nation findById(Long id);

    void save(Nation nation);

    void remove(Long id);
}
