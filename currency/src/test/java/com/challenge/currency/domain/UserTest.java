package com.challenge.currency.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void testSetAndGetName() {
        String testName = "aName";
        assertNull(user.getName());
        user.setName(testName);
        assertEquals(testName, user.getName());
    }

    @Test
    public void testSetAndGetPassword() {
        String testPassword = "pass";
        assertNull(user.getPassword());   
        user.setPassword(testPassword);
        assertEquals(testPassword, user.getPassword(), 0);
    }
}
