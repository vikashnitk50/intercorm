package com.intercorm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.intercorm.bean.Customer;
import com.intercorm.converter.Converter;
import com.intercorm.converter.CustomerConvertor;
import com.intercorm.utils.GreatCircleUtil;

public class FindMatchingCustomer {

	private Converter<Customer> convetor = new CustomerConvertor<Customer>();

	private static final int MAX_DISTANCE = 100;

	private int maxD;

	public FindMatchingCustomer() {
		this.maxD = MAX_DISTANCE;
	}

	public FindMatchingCustomer(int maxD) {
		if (maxD < 0)
			throw new IllegalArgumentException("Invalid Distance " + maxD);
		this.maxD = maxD;
	}

	public List<Customer> findMatchingCustomers(String jsonFilePath,
			double srcLatitude, double srcLongitude) throws IOException {
		List<Customer> customers = convetor.getJsonAsJavaObjects(jsonFilePath);
		List<Customer> matchingCustomers = new ArrayList<Customer>();
		if (customers != null) {
			for (Customer customer : customers) {
				double distance = GreatCircleUtil.calculate(srcLatitude,
						srcLongitude, customer.getLatitude(),
						customer.getLongitude());
				if (distance <= maxD) {
					customer.setDistance(distance);
					matchingCustomers.add(customer);
				}
			}
			Collections.sort(matchingCustomers);
		}
		return matchingCustomers;
	}

}
