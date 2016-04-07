package com.challenge.currency.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.currency.domain.Country;
import com.challenge.currency.domain.User;
import com.challenge.currency.repository.CountryDAO;
import com.challenge.currency.repository.UserDAO;

@Component
public class SimpleUserManager implements UserManager{
	
	private static final long serialVersionUID = 1L;
	
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private CountryDAO countryDAO;
	
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

	public List<User> getUsers() {
		return userDAO.getUserList();
	}

	public User getUser(String name, String password) {
		User user = new User(name, password);
		List<User> users = userDAO.getUserList();
		if (users.contains(user)){
			return users.get(users.indexOf(user));
		}
		return null;
	}
	
	public void saveUser(String name, String password, String email, Date dob, String street, String zipcode, String city, int id){
		Country country = countryDAO.getCountry(id);
		User user = new User(name,  password,  email,  dob,  street,  zipcode,  city,  country);
		userDAO.saveUser(user);
	}

}
