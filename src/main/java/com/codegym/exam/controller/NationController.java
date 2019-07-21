package com.codegym.exam.controller;

import com.codegym.exam.model.Nation;
import com.codegym.exam.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NationController {

    @Autowired
    private NationService nationService;

    @GetMapping("/nations")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/nation/list");
        modelAndView.addObject("nations", nationService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-nation")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        return modelAndView;
    }

    @PostMapping("/create-nation")
    public ModelAndView createNation(@ModelAttribute("nation") Nation nation) {
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        modelAndView.addObject("message",
                "New nation was created successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-nation/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Nation nation = nationService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/nation/edit");
        modelAndView.addObject("nation", nation);
        return modelAndView;
    }

    @PostMapping("/edit-nation")
    public ModelAndView edit(@ModelAttribute("nation") Nation nation) {
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/edit");
        modelAndView.addObject("message", "Nation was updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-nation/{id}")
    public ModelAndView showDelete(@PathVariable("id") Long id) {
        Nation nation = nationService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/nation/delete");
        modelAndView.addObject("nation", nation);
        return modelAndView;
    }

    @PostMapping("/delete-nation")
    public String delete(@ModelAttribute("type") Nation nation) {
        nationService.remove(nation.getId());
        return "redirect:/nations";
    }

}
