package com.challenge.currency.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.currency.domain.Historical;
import com.challenge.currency.repository.HistoricalDAO;

@Component
public class SimpleHistoricalManager implements HistoricalManager{

private static final long serialVersionUID = 1L;
	
    @Autowired
    private HistoricalDAO historicalDAO;
    

	public List<Historical> getHitoricals(String name) {
		return historicalDAO.getHistoricalList(name);
	}


	public void saveHistorical(Historical historical) {
		historicalDAO.saveHistorical(historical);
		
	}

	public void saveHistorical(String name, String currency, Double currencyValue, Date dateCurrency) {
		Historical hist = new Historical (name, currency, currencyValue, dateCurrency);
		historicalDAO.saveHistorical(hist);
	}
	
	public Historical getMaxHistorical(String name){
		return historicalDAO.getMaxHistorical(name);
	}

}
