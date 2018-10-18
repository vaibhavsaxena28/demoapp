package com.tsys.demoapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Service;

import com.tsys.demoapp.bean.Customer;

@Service
public class CustomerService {

	List<Customer> lstCustomer = new ArrayList<>(Arrays.asList( 
								new Customer("1", "Vaibhav", "TL"),
								new Customer("2", "JeetPal", "Senior developer"),
								new Customer("3", "Yogendra", "Senior developer") ,
								new Customer("4", "Chandan", "developer")
								));
	
	
	public List<Customer> getCustomers() {
		
		return lstCustomer;
	}
	
	
	public Customer getCustomerbyId(String id) {
		return lstCustomer.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}


	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		lstCustomer.add(customer);
		
	}


	public void updateCustomer(String id, Customer customer) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<lstCustomer.size(); i++) {
			Customer cust = lstCustomer.get(i);
			if(cust.getId().equals(id)) {
				lstCustomer.set(i, customer);
				return;
			}
			
		}
		
	}


	public void deleteCustomer(String id) {
		// TODO Auto-generated method stub
		lstCustomer.removeIf(t -> t.getId().equals(id));
	}
	
}
