package com.challenge.currency.repository;

import java.util.List;

import com.challenge.currency.domain.Country;

public interface CountryDAO {

	public List<Country> getCountriesList();
	
	public Country getCountry(int id);
}
