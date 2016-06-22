package com.intercorm.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
	
	private ArrayUtils(){};

	public static List<Integer> flattern(Object[] nestedArray) {
		if (nestedArray == null || nestedArray.length == 0)
			return null;
		List<Integer> flattenArrays = new ArrayList<Integer>();
		return flattern(nestedArray, flattenArrays);
	}

	public static List<Integer> flattern(List<?> nestedArray) {
		if (nestedArray == null || nestedArray.size() == 0)
			return null;
		List<Integer> flattenArrays = new ArrayList<Integer>();
		return flattern(nestedArray, flattenArrays);
	}

	private static List<Integer> flattern(List<?> nestedArray,
			List<Integer> flattenArrays) {
		for (Object element : nestedArray) {
			if (element instanceof Integer) {
				flattenArrays.add((Integer) element);
			} else {
				flattern((List<?>) element, flattenArrays);
			}
		}
		return flattenArrays;
	}

	private static List<Integer> flattern(Object[] nestedArray,
			List<Integer> flattenArrays) {
		for (Object element : nestedArray) {
			if (element instanceof Integer) {
				flattenArrays.add((Integer) element);
			} else {
				flattern((Object[]) element, flattenArrays);
			}
		}
		return flattenArrays;
	}
	
	

}
