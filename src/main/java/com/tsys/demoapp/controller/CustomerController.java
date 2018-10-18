package com.tsys.demoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.demoapp.bean.Customer;
import com.tsys.demoapp.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/getcustomer")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	
	@RequestMapping("/getcustomer/{id}")
	public Customer getCustomerbyId(@PathVariable String id) {
		return customerService.getCustomerbyId(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addcustomer")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	

	@RequestMapping(method=RequestMethod.PUT, value="/updatecustomer/{id}")
	public void updateCustomer(@RequestBody Customer customer,@PathVariable String id) {
		customerService.updateCustomer(id, customer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);
	}
}
