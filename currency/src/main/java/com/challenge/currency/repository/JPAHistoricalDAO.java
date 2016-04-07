package com.challenge.currency.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.currency.domain.Historical;

@Repository(value = "historicalDAO")
public class JPAHistoricalDAO implements HistoricalDAO{
	
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Historical> getHistoricalList(String name) {
    	 return em.createQuery("select h from Historical h where h.user.name = :name order by h.dateQuery desc").setParameter("name", name).getResultList();
	}

    @Transactional(readOnly = false)
	public void saveHistorical(Historical historical) {
    	em.merge(historical);
		
	}

    @Transactional(readOnly = true)
	public Historical getHistorical(String name) {
    	return (Historical) em.createQuery("select h from Historical h where h.name = ?");
	}

    @Transactional(readOnly = true)
	public Historical getMaxHistorical(String name) {
		return (Historical) em.createQuery("select h from Historical h where h.dateQuery = (select max(h1.dateQuery) from Historical h1 where h1.user.name = :name group by h1.user)", Historical.class).setParameter("name", name).getSingleResult();
	}
    
}
