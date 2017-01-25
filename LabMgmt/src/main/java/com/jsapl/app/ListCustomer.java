package com.jsapl.app;

import com.jsapl.rest.CustomerResource;

public class ListCustomer {
	public static void main(String[] args) {
		new CustomerResource().getCustomerList();
	}
}
