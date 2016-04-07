package com.challenge.currency.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.currency.service.SimpleUserManager;


public class CurrencyControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        CurrencyController controller = new CurrencyController();
        controller.setUserManager(new SimpleUserManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }

}