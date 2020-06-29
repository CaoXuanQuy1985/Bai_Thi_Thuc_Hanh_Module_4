package com.codegym.cunkin.repository;

import com.codegym.cunkin.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
/*    List<City> findAllByName(String name_city, Pageable pageable);*/
}
