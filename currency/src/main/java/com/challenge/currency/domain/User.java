package com.challenge.currency.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users") 
public class User implements Serializable, Comparable<User> {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "name")
    private String name;
    private String password;
    private String email;
    private Date dob;
    private String street;
    private String zipcode;
    private String city;
    
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="country")
    private Country country;
       
    
	public User() {
	}

	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}



	public User(String name, String password, String email, Date dob, String street, String zipcode, String city, Country country) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
	}

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
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public int compareTo(User o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


    
    
    
}
