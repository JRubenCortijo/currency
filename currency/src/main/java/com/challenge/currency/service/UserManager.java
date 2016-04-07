package com.challenge.currency.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.challenge.currency.domain.User;

public interface UserManager extends Serializable {

	public List<User> getUsers();
	
	public User getUser(String name, String password);
	
	public void saveUser(String name, String password, String email, Date dob, String street, String zipcode, String city, int country);

}
