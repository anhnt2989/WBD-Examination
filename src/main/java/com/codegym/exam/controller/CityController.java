package com.codegym.exam.controller;

import com.codegym.exam.model.City;
import com.codegym.exam.model.Nation;
import com.codegym.exam.service.CityService;
import com.codegym.exam.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private NationService nationService;

    @ModelAttribute("nations")
    public Iterable<Nation> nations() {
        Iterable<Nation> nations = nationService.findAll();
        return nationService.findAll();
    }

    @GetMapping("/cities")
    public ModelAndView showAll(@RequestParam("nation") Optional<Long> nation, @RequestParam("s") Optional<String> s, @PageableDefault(size = 5) Pageable pageable) {
        Page<City> cities;
        if (s.isPresent()) {
            cities = cityService.findAllByNameContainingOrDescriptionContaining(s.get(), s.get(), pageable);
        } else if (nation.isPresent()) {
            Nation type1 = nationService.findById(nation.get());
            cities = cityService.findAllByNation(type1, pageable);
        } else {
            cities = cityService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView create(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/city/create");
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city was created successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit-city")
    public ModelAndView edit(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/city/edit");
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("message", "City was updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDelete(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/delete");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/delete-city")
    public String delete(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:/cities";
    }

    @GetMapping("/view-city/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/view");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

}
