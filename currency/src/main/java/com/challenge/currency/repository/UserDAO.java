package com.challenge.currency.repository;

import java.util.List;

import com.challenge.currency.domain.User;

public interface UserDAO {

    public List<User> getUserList();

    public void saveUser(User user);
    
    public User getUser(String name);
    
}
