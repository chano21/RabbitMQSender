package com.crazypco.rabbit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crazypco.rabbit.config.Sender;
import com.crazypco.rabbit.entitys.Customer;
import com.crazypco.rabbit.repository.CustomerRespository;

@RestController
public class SenderController {

	@Autowired
	CustomerRespository customerrepository;
    
	@Autowired
	 Sender sender;
    
    @RequestMapping( path="/register", method = RequestMethod.GET)
    List<Customer> register(){        
    	Customer c1=new Customer();
    	c1.setEmail("test@naver.com");
    	c1.setName("chano");
    	customerrepository.saveAndFlush(c1);
    	System.out.println(customerrepository.findAll().toString());
    
    	for(int i=0; i<1000000; i++) {
    		sender.send(customerrepository.findAll().toString());
      }
    	
    	return customerrepository.findAll();     
    }



}
