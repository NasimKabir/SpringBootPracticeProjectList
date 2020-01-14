package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Country;
import com.spring.service.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;

	
	@GetMapping("/")
    public String showPage(Model model) {
       List<Country> country=countryService.getCountryList();
       model.addAttribute("country", country);
        return "index";
    }

    @PostMapping("/save")
    public String save(Country country) {
    	countryService.saveCountry(country);
        return "redirect:/";
    }

    @RequestMapping(value="/edit",method = {RequestMethod.POST,RequestMethod.GET})
   // @PostMapping("/edit")
    public String update(Country country) {
    	countryService.saveCountry(country);
        return "redirect:/";
    }
    
    //@DeleteMapping("/delete")
    @RequestMapping(value="/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteCountry(long id) {
    	countryService.deleteCountry(id);
        return "redirect:/";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Optional<Country> findOne(long id) {
        return countryService.FindByID(id);
    }
}
