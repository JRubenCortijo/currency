package com.challenge.currency.service;

import java.io.Serializable;
import java.util.List;

import com.challenge.currency.domain.Country;

public interface CountryManager extends Serializable{
	
	public List<Country> getCountries();
}
