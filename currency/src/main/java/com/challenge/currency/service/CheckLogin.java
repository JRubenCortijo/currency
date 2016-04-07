package com.challenge.currency.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CheckLogin {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private String name;
    
    private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
