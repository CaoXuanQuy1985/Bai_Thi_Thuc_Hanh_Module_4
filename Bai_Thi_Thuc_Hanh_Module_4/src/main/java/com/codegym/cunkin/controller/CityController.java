package com.codegym.cunkin.controller;

import com.codegym.cunkin.model.City;
import com.codegym.cunkin.model.Country;
import com.codegym.cunkin.service.ICityService;
import com.codegym.cunkin.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @GetMapping("/")
    public ModelAndView showAddNewForm() {
        City city = new City();
        Iterable<Country> countryIterable = countryService.findAll();
        Iterator<Country> countryIterator = countryIterable.iterator();
        List<Country> countryList = new ArrayList<>();
        countryIterator.forEachRemaining(countryList::add);
        ModelAndView modelAndView = new ModelAndView("add-city-form");
        modelAndView.addObject("city", city);
        modelAndView.addObject("countryList", countryList);
        return modelAndView;
    }

    @PostMapping("/add-city")
    public ModelAndView addCustomer(@ModelAttribute("city") City city) {
        ModelAndView modelAndView = new ModelAndView("city-list");
        cityService.save(city);
        return modelAndView;
    }

    @GetMapping("/city-list")
    public ModelAndView showCityList() {
        ModelAndView modelAndView = new ModelAndView("city-list");
        Iterable<City> cityIterable = cityService.findAll();
        Iterator<City> cityIterator = cityIterable.iterator();
        List<City> cityList = new ArrayList<>();
        cityIterator.forEachRemaining(cityList::add);

        modelAndView.addObject("cityList", cityList);
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView editCity(@PathVariable("id") Long id) {
        City oldCity = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit-city");

        Iterable<Country> countryIterable = countryService.findAll();
        Iterator<Country> countryIterator = countryIterable.iterator();
        List<Country> countryList = new ArrayList<>();
        countryIterator.forEachRemaining(countryList::add);

        modelAndView.addObject("oldCity", oldCity);
        modelAndView.addObject("countryList", countryList);
        return modelAndView;
        /*String newName = newCity.getName();
        Float newArea = newCity.getArea();
        Float newPopulation = newCity.getPopulation();
        Float newGDP = newCity.getGdp();
        String newNameCountry = newCity.getName_country();
        Country newCountry = newCity.getCountry();
        String newIntroduce = newCity.getIntroduce();

        oldCity.setName(newName);
        oldCity.setArea(newArea);
        oldCity.setPopulation(newPopulation);
        oldCity.setGdp(newGDP);
        oldCity.setName_country(newNameCountry);
        oldCity.setCountry(newCountry);
        oldCity.setIntroduce(newIntroduce);

        cityService.save(oldCity);

        ModelAndView modelAndView = new ModelAndView("city-list");
        return modelAndView;*/
    }

    @PostMapping("/edit-city")
    public ModelAndView showEditForm(@ModelAttribute("oldCity") City oldCity) {
        cityService.save(oldCity);
        ModelAndView modelAndView = new ModelAndView("/edit-city");
        modelAndView.addObject("oldCity", oldCity);
        modelAndView.addObject("message", "Cập Nhật Thành Phố Thành  Công!!!");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id) {
        City deleteCity = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete-city");

        Iterable<Country> countryIterable = countryService.findAll();
        Iterator<Country> countryIterator = countryIterable.iterator();
        List<Country> countryList = new ArrayList<>();
        countryIterator.forEachRemaining(countryList::add);

        modelAndView.addObject("deleteCity", deleteCity);
        modelAndView.addObject("countryList", countryList);
        return modelAndView;
    }

    @PostMapping("/delete-city")
    public ModelAndView deleteCity(@ModelAttribute("deleteCity") City city) {
        Long city_id = city.getId();
        cityService.remove(city_id);

        ModelAndView modelAndView = new ModelAndView("city-list");
        return modelAndView;
    }

}
