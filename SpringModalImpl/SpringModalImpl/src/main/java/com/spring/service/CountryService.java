package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Country;
import com.spring.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getCountryList() {
		return (List<Country>) countryRepository.findAll();
	}
	
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}
	
	public Optional<Country> FindByID(long id) {
		return countryRepository.findById(id);
	}
	
	public void deleteCountry(long id) {
		countryRepository.findById(id).get();
		countryRepository.deleteById(id);
	}
}
