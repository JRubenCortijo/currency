package com.challenge.currency.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {

    private Integer timestamp;
    private String base;
    private Map<String, Double> rates;

    /**
     * 
     * @return
     *     The timestamp
     */
    public Integer getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp
     *     The timestamp
     */
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Rates withTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * 
     * @return
     *     The base
     */
    public String getBase() {
        return base;
    }

    /**
     * 
     * @param base
     *     The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    public Rates withBase(String base) {
        this.base = base;
        return this;
    }

    /**
     * 
     * @return
     *     The rates
     */
    public Map<String, Double> getRates() {
        return rates;
    }

    /**
     * 
     * @param rates
     *     The rates
     */
    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

	@Override
	public String toString() {
		return "Rates [timestamp=" + timestamp + ", base=" + base + ", rates=" + rates + "]";
	}

}
