package com.challenge.currency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.currency.domain.Country;
import com.challenge.currency.repository.CountryDAO;

@Component
public class SimpleCountryManager implements CountryManager{

	private static final long serialVersionUID = 1L;
	
    @Autowired
    private CountryDAO countryDAO;
    
	public List<Country> getCountries() {
		return countryDAO.getCountriesList();
	}

}
