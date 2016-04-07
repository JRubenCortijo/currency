package com.challenge.currency.repository;

import java.util.List;

import com.challenge.currency.domain.Historical;

public interface HistoricalDAO {

    public List<Historical> getHistoricalList(String name);

    public void saveHistorical(Historical historical);
    
    public Historical getHistorical(String name);

	public Historical getMaxHistorical(String name);
}
