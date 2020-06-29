package com.codegym.cunkin.service.impl;

import com.codegym.cunkin.model.City;
import com.codegym.cunkin.repository.CityRepository;
import com.codegym.cunkin.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        Iterable<City> cities = cityRepository.findAll();
        return cities;
    }

    @Override
    public Page<City> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 1);
        return cityRepository.findAll(pageable);
    }

    @Override
    public City findById(Long id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        City city;
        if (optionalCity.isPresent()) {
            city = optionalCity.get();
        } else {
            city = null;
        }
        return city;
    }

    @Override
    @Transactional
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        City deleteCity = findById(id);
        cityRepository.delete(deleteCity);
    }

/*    public List<City> findAllByName(String name_city, java.awt.print.Pageable pageable) {
        return cityRepository.findAllByName(name_city,pageable);
    }*/
}
