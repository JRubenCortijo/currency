package com.challenge.currency.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.currency.domain.User;

@Repository(value = "userDAO")
public class JPAUserDAO implements UserDAO{
	
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<User> getUserList() {
    	 return em.createQuery("select u from User u order by u.name").getResultList();
	}

    @Transactional(readOnly = false)
	public void saveUser(User user) {
    	em.merge(user);
		
	}

    @Transactional(readOnly = true)
	public User getUser(String name) {
    	return (User) em.createQuery("select u from User u where u.name = ?");
	}

}
