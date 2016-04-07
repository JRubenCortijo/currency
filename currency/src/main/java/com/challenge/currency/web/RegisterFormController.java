package com.challenge.currency.web;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.challenge.currency.domain.Country;
import com.challenge.currency.service.CheckRegister;
import com.challenge.currency.service.CountryManager;
import com.challenge.currency.service.UserManager;

@Controller
@RequestMapping(value="/register.htm")
public class RegisterFormController {

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private UserManager userManager;
    
    @Autowired
    private CountryManager countryManager;
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CheckRegister checkRegister, BindingResult result){
    	if (result.hasErrors()) {
            return "register";
        }
    	String name = checkRegister.getName();
    	String password = checkRegister.getPassword();
    	String email = checkRegister.getEmail();
    	Date dob = checkRegister.getDob();
    	String street = checkRegister.getStreet();
    	String zipcode = checkRegister.getZipcode();
    	String city = checkRegister.getCity();
    	int country = checkRegister.getCountry();
    	
    	userManager.saveUser(name, password, email, dob, street, zipcode, city, country);
    	return "redirect:/login.htm";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) { 
        CheckRegister checkRegister = new CheckRegister();    
        model.put("registerForm", checkRegister);
        
        Map<Integer,String> countryList = new LinkedHashMap<Integer,String>();
        
        for (Country country : countryManager.getCountries()) {
        	countryList.put(country.getId(), country.getCountry());
        }      
        model.put("countryList", countryList);  
     
        return "register";
    }
    
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }    
}
