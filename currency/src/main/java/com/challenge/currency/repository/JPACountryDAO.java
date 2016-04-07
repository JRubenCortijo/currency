package com.challenge.currency.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.currency.domain.Country;

@Repository(value = "countryDAO")
public class JPACountryDAO implements CountryDAO{

	
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Country> getCountriesList() {
    	return em.createQuery("select c from Country c order by c.country").getResultList();
	}

    @Transactional(readOnly = true)
	public Country getCountry(int id) {
    	return (Country) em.createQuery("select c from Country c where c.id = :id)", Country.class).setParameter("id", id).getSingleResult();
    	
	}

}
