package com.intercorm.converter;

import java.io.IOException;
import java.util.List;

public interface Converter<T> {
	
	public T getJsonAsJavaObject(String jsonLine);
	
	public List<T> getJsonAsJavaObjects(String jsonFilePatch) throws IOException;
	
}
