package com.codegym.exam.repository;

import com.codegym.exam.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NationRepository extends PagingAndSortingRepository<Nation, Long> {
}
