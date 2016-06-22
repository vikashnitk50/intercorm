package com.intercorm.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

	@Test
	public void testNestedArrayList() {
		Integer[] expectedFlatternArray = { 1, 2, 3, 4 };
		List<Integer> actualflatterArray = ArrayUtils
				.flattern(getNestedArray());
		Assert.assertNotNull(actualflatterArray);
		Assert.assertArrayEquals(expectedFlatternArray,
				actualflatterArray.toArray());
	}

	@Test
	public void testEmptyNestedArrayList() {
		List<Integer> actualflatterArray = ArrayUtils
				.flattern(new ArrayList<Integer>());
		Assert.assertNull(actualflatterArray);
	}

	@Test
	public void testFlatternArrayList() {
		List<Integer> expectedFlatternArray = new ArrayList<Integer>();
		expectedFlatternArray.add(1);
		expectedFlatternArray.add(2);
		expectedFlatternArray.add(3);
		List<Integer> actualflatterArray = ArrayUtils
				.flattern(expectedFlatternArray);
		Assert.assertNotNull(actualflatterArray);
		Assert.assertArrayEquals(expectedFlatternArray.toArray(),
				actualflatterArray.toArray());
	}

	@Test
	public void testNestedArray() {
		Integer[] expectedFlatternArray = { 1, 2, 3, 4, 5, 6, 7 };
		List<Integer> actualflatterArray = ArrayUtils.flattern(new Object[] {
				1, 2, new Object[] { 3, 4, 5 }, 6, 7 });
		Assert.assertNotNull(actualflatterArray);
		Assert.assertArrayEquals(expectedFlatternArray,
				actualflatterArray.toArray());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getNestedArray() {
		List nestedArray = new ArrayList();
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(3);
		list.add(integers);
		nestedArray.add(list);
		nestedArray.add(4);
		return nestedArray;
	}

}
