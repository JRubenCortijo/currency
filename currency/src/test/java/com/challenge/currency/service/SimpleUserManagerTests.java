package com.challenge.currency.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.challenge.currency.domain.User;

public class SimpleUserManagerTests {

	    private SimpleUserManager userManager;
	  
	    private List<User> users;
	    
	    private static int USER_COUNT = 2;
	    
	    private static String USER1_NAME = "Pepe";
	    private static String USER1_PASSWORD= "pass";
	    
	    private static String USER2_NAME= "Tomas";
	    private static String USER2_PASSWORD = "pass2"; 
	    
	    @Before
	    public void setUp() throws Exception {
	    	userManager = new SimpleUserManager();
	        users = new ArrayList<User>();
	        
	        User user = new User();
	        user.setName(USER1_NAME);
	        user.setPassword(USER1_PASSWORD);
	        users.add(user);
	        
	        user = new User();
	        user.setName(USER2_NAME);
	        user.setPassword(USER2_PASSWORD);
	        users.add(user);
	        
	       // userManager.setUsers(users);
	    }

	    @Test
	    public void testGetUsersWithNoUsers() {
	        userManager = new SimpleUserManager();
	        assertNull(userManager.getUsers());
	    }
	    
	    @Test
	    public void testGetUsers() {
	        List<User> users = userManager.getUsers();
	        assertNotNull(users);        
	        assertEquals(USER_COUNT, userManager.getUsers().size());
	    
	        User user = users.get(0);
	        assertEquals(USER1_NAME, user.getName());
	        assertEquals(USER1_PASSWORD, user.getPassword());
	        
	        user = users.get(1);
	        assertEquals(USER2_NAME, user.getName());
	        assertEquals(USER2_PASSWORD, user.getPassword());      
	    }
}
