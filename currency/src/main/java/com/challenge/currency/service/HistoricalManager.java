package com.challenge.currency.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.challenge.currency.domain.Historical;

public interface HistoricalManager extends Serializable{

	public List<Historical> getHitoricals(String name);
	
	public void saveHistorical(Historical historical);
	
	public void saveHistorical(String name, String currency, Double currencyValue, Date dateCurrency);
	
	public Historical getMaxHistorical(String name);
}
