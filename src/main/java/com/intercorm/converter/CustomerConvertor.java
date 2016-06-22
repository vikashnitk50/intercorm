package com.intercorm.converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intercorm.bean.Customer;


@SuppressWarnings("hiding")
public class CustomerConvertor<Customer> implements Converter<Customer>{

	private Gson gson = new GsonBuilder().create();

	@SuppressWarnings("unchecked")
	public Customer getJsonAsJavaObject(String jsonLine) {
		return (Customer) gson.fromJson(jsonLine, com.intercorm.bean.Customer.class);
	}
	
	public List<Customer> getJsonAsJavaObjects(String jsonFilePatch) throws IOException {
		BufferedReader br = null;
		List<Customer> customers = new ArrayList<Customer>();
		try {
			br = new BufferedReader(new FileReader(jsonFilePatch));
			String jsonLine;
			while ((jsonLine = br.readLine()) != null) {
				customers.add(getJsonAsJavaObject(jsonLine));
			}
		} finally {
			if(br!=null){
				br.close();
			}
			
		}
		return customers;

	}

	
}
