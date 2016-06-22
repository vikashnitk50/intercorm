package com.intercorm.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.intercorm.bean.Customer;

public class FindMatchingCustomerTest {

	private FindMatchingCustomer findMatchingCustomer = new FindMatchingCustomer();

	@Before
	public void setUp() {
		this.findMatchingCustomer = new FindMatchingCustomer();
	}

	@Test
	public void testFindMatchingCustomersValidFile() throws IOException {
		String validJsonFilePath = "C:\\Users\\Vikash\\Desktop\\vikash_target\\workspace\\intercorm\\src\\main\\resources\\json\\customers.json";
		List<Customer> matchingCustomers = findMatchingCustomer
				.findMatchingCustomers(validJsonFilePath, 53.3381985d,
						-6.2592576d);
		System.out.println(matchingCustomers.size());
		System.out.println(matchingCustomers);
	}

	@Test(expected = FileNotFoundException.class)
	public void testFindMatchingCustomersInValidFile() throws IOException {
		String inValidJsonFilePath = "C:\\Users\\Vikash\\Desktop\\vikash_target\\workspace\\intercorm\\src\\main\\resources\\json\\customers1.json";
		findMatchingCustomer.findMatchingCustomers(inValidJsonFilePath,
				53.3381985d, -6.2592576d);
	}
}
