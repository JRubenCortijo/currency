package com.challenge.currency.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.challenge.currency.generic.EnumCurrency;
import com.challenge.currency.model.Rates;
import com.challenge.currency.service.CheckCurrency;
import com.challenge.currency.service.HistoricalManager;

@Controller
@RequestMapping(value = "/rates")
public class JSONController {
	
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private HistoricalManager historicalManager;
    

    public void setHistoricalManager(HistoricalManager historicalManager) {
        this.historicalManager = historicalManager;
    }
	
  
	@RequestMapping(method = RequestMethod.GET)
    public String viewCurrencies(@RequestParam("name") String nameLog, @RequestParam(value="dateCurrency", required=false) String dateCurrency,@RequestParam(value="currency", required=false) String currency, @RequestParam(value="change", required=false) String change, Map<String, Object> model) {
        CheckCurrency checkCurrency = new CheckCurrency();    
        model.put("currencyForm", checkCurrency);
         
        Map<String,String> currencyList = new LinkedHashMap<String,String>();
        
        for (EnumCurrency userType : EnumCurrency.values()) {
        	currencyList.put(userType.getValue(), userType.getDescription());
        }      
        model.put("currencyList", currencyList);  
        model.put("change", change);
        model.put("currency", currency);
        model.put("dateCurrency", dateCurrency);
        
        List<?> historicals = historicalManager.getHitoricals(nameLog);
        
        if (historicals.size()>0) {
        		model.put("historicals", historicals.subList(0,Math.min(10,historicals.size())));
        		model.put("actual", historicalManager.getMaxHistorical(nameLog));
        } else {
        	model.put("actual",null);
        }
        
        return "rates";
    }
	
	
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CheckCurrency checkCurrency, BindingResult result, ModelMap model,@RequestParam("name") String nameLog){

    	String currency = checkCurrency.getCurrency();
    	Date date = checkCurrency.getDate();
    	Date now = new Date();
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date first = new Date();
    	try {
			first = df.parse("1999-01-01");
		} catch (ParseException e) {

		}
    	
    	if (nameLog != null && nameLog.endsWith(","))
    		nameLog = nameLog.substring(0, nameLog.length()-1);
    	
    	if (date != null && date.before(now) && date.after(first)){
	    	
	    	String dateString = df.format(date);
	    	
	    	RestTemplate restTemplate = new RestTemplate();
	        Rates rates = restTemplate.getForObject("https://openexchangerates.org/api/historical/" + dateString + ".json?app_id=61778b4946644a3bb65af755fe47564e", Rates.class);
	        
	        Double value = rates.getRates().get(currency);
	    	
	    	historicalManager.saveHistorical(nameLog, currency, value, date);	    	
	    	model.addAttribute("change", value);
	    	model.addAttribute("currency", currency);
	    	model.addAttribute("dateCurrency", dateString);
    	}
    	
    	model.addAttribute("name", nameLog);
    	return "redirect:/rates.htm";
    	
    }
     

   
}
