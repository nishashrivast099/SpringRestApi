package com.njclabs.SpringRestApi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.njclabs.SpringRestApi.model.Country;
import com.njclabs.SpringRestApi.repository.CountryRepository;
import com.njclabs.SpringRestApi.service.exception.CountryNotFoundException;

@RestController
public class CountryController{

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping("getCountries")
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}
	
    @PostMapping(path="addCountry")
	public void addCountry(@RequestBody Country c) {
		countryRepository.save(c);
	}
	
	
	@GetMapping("getCountry/{countryCode}")
	public Country findCountryByCode(@PathVariable String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if(!result.isPresent()) {
			throw new CountryNotFoundException("Country Not Found");
		}
		return result.get();
	}
}
