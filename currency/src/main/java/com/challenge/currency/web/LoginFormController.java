package com.challenge.currency.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.challenge.currency.domain.User;
import com.challenge.currency.service.CheckLogin;
import com.challenge.currency.service.UserManager;

@Controller
@RequestMapping(value="/login.htm")
public class LoginFormController {

	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
			
    @Autowired
    private UserManager userManager;
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CheckLogin checkLogin, BindingResult result){
    	if (result.hasErrors()) {
            return "login";
        }
    	
    	String name = checkLogin.getName();
    	String password = checkLogin.getPassword();
    	User user = userManager.getUser(name, password);
    	
    	
    	
    	
    	if (user == null){
    		result.addError(new ObjectError("error.name","Username unregistered"));
    		return "redirect:/login.htm";
    	}
    	else {
    		return "redirect:/rates.htm"+"?name="+name;
    	}
    	
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected CheckLogin formBackingObject(HttpServletRequest request) throws ServletException {
    	CheckLogin checkLogin = new CheckLogin();
        checkLogin.setName("");
        return checkLogin;
    }
    
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }
}
