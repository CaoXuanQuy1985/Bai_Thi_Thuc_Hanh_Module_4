package com.codegym.cunkin.service.impl;

import com.codegym.cunkin.model.City;
import com.codegym.cunkin.model.Country;
import com.codegym.cunkin.repository.CountryRepository;
import com.codegym.cunkin.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        Iterable<Country> countries = countryRepository.findAll();
        return countries;
    }

    @Override
    public Page<Country> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 1);
        return countryRepository.findAll(pageable);
    }

    @Override
    public Country findById(Long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        Country country;
        if (optionalCountry.isPresent()) {
            country = optionalCountry.get();
        } else {
            country = null;
        }
        return country;
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        Country deleteCountry = findById(id);
        countryRepository.delete(deleteCountry);
    }
}
