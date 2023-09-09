package com.male.models.ds.array;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StaticArrayTest {

	private StaticArray<Integer> underTest;

	@BeforeEach
	public void setUp() {
		underTest = new StaticArray<>(5);
	}

	@Test
	@DisplayName("StaticArray isEmpty method 测试")
	public void testIsEmpty() {
		// 检测空
		assertTrue(underTest.isEmpty());
		// 检测非空
		underTest.addFirst(1);
		assertFalse(underTest.isEmpty());
	}

	@Test
	@DisplayName("StaticArray contains method 测试")
	public void testContains() {
		assertFalse(underTest.contains(null));
		underTest.addFirst(null);
		assertTrue(underTest.contains(null));
		assertFalse(underTest.contains(1));
		underTest.addFirst(1);
		assertTrue(underTest.contains(1));

	}

	@Test
	@DisplayName("StaticArray add method 测试")
	public void testAdd() {
		// Setup
		// Run the test
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.add(-1, -1));
		underTest.add(0, 1);
		assertEquals(1, underTest.get(0));
		underTest.add(0, 11);
		assertEquals(11, underTest.get(0));
		underTest.add(1, 2);
		underTest.add(2, 3);
		underTest.add(3, 4);
		underTest.add(4, 5);
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.add(5, 6));
		// Verify the results
	}

	@Test
	@DisplayName("StaticArray get method 测试")
	public void testGet() {
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.get(-1));
		assertEquals(null, underTest.get(0));
		underTest.add(0, 1);
		underTest.add(1, 2);
		assertEquals(1, underTest.get(0));
		assertEquals(2, underTest.get(1));
		underTest.add(1, 12);
		assertEquals(12, underTest.get(1));
		assertEquals(null, underTest.get(2));
	}

	@Test
	@DisplayName("StaticArray remove(index) method 测试")
	public void testRemove() {
		// add 方法只能从索引添加方法只能从0开始加
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.add(2, 3));
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.add(3, 3));
		underTest.add(0, 3);
		underTest.add(1, 3);
		underTest.add(2, 3);
		underTest.add(3, 4);
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.remove(-1));
		assertEquals(3, underTest.remove(0));
		assertEquals(4, underTest.remove(2));
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.remove(4));
	}

	@Test
	@DisplayName("StaticArray removeFirst(element) method 测试")
	public void testRemoveFirst() {
		underTest.add(0, 0);
		underTest.add(1, 1);
		underTest.add(2, 2);
		underTest.add(3, 3);
		assertEquals(1, underTest.removeFirst(Integer.valueOf(1)));
		assertEquals(2, underTest.removeFirst(Integer.valueOf(2)));
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.removeFirst(Integer.valueOf(5)));
	}

	@Test
	@DisplayName("StaticArray removeAll(element) method 测试")
	public void testRemoveAll() {
		underTest.add(0, 0);
		underTest.add(1, 1);
		underTest.add(2, 1);
		underTest.add(3, 2);
		underTest.add(4, 2);
		underTest.removeAll(Integer.valueOf(1));
		assertIterableEquals(List.of(0, 2, 2), underTest);
		underTest.removeAll(Integer.valueOf(2));
		assertIterableEquals(List.of(0), underTest);
		underTest.removeAll(Integer.valueOf(0));
		assertIterableEquals(List.of(), underTest);
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.removeAll(Integer.valueOf(12)));
	}
}
