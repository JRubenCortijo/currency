package com.challenge.currency.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="historical") 
public class Historical implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="name")
    private User user;
    
    private String currency;
    
    private Double currencyValue;
    
    private Date dateCurrency;
    
    private Date dateQuery;

	

	public Historical() {
	}

	public Historical(String name, String currency, Double currencyValue, Date dateCurrency) {
		User user = new User(name);
		this.user = user;
		this.currency = currency;
		this.currencyValue = currencyValue;
		this.dateCurrency = dateCurrency;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(Double currencyValue) {
		this.currencyValue = currencyValue;
	}

	public Date getDateCurrency() {
		return dateCurrency;
	}

	public void setDateCurrency(Date dateCurrency) {
		this.dateCurrency = dateCurrency;
	}

	public Date getDateQuery() {
		return dateQuery;
	}

	public void setDateQuery(Date dateQuery) {
		this.dateQuery = dateQuery;
	}

	@Override
	public String toString() {
		return "Historical [currency=" + currency + ", currencyValue=" + currencyValue + ", dateCurrency="
				+ dateCurrency + "]";
	}

    
    
}
