package com.male.models.ds.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class AbstractArrayTest {

	private AbstractArray<Integer> underTest;

	@BeforeEach
	public void setUp() {
		underTest = new StaticArray<>(5);
	}

	@Test
	@DisplayName("AbstractArray addFirst method 测试")
	public void testAddFirst() {
		// Setup
		// Run the test
		underTest.addFirst(1);
		underTest.addFirst(2);
		underTest.addFirst(3);
		underTest.addFirst(4);
		underTest.addFirst(5);
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.addFirst(6));
		// Verify the results
		underTest.forEach(System.out::print);
	}

	@Test
	@DisplayName("AbstractArray addLast method 测试")
	public void testAddLast() {
		// Setup
		// Run the test
		underTest.addLast(1);
		underTest.addLast(2);
		underTest.addLast(3);
		underTest.addLast(4);
		underTest.addLast(5);
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.addLast(6));
		// Verify the results
		underTest.forEach(System.out::print);
	}

	@Test
	@DisplayName("AbstractArray removeFirst method 测试")
	public void testRemoveFirst() {
		underTest.addLast(1);
		underTest.addLast(2);
		underTest.addLast(3);
		underTest.addLast(4);
		underTest.addLast(5);
		assertEquals(1, underTest.removeFirst());
		assertEquals(2, underTest.removeFirst());
		assertEquals(3, underTest.removeFirst());
		assertEquals(4, underTest.removeFirst());
		assertEquals(5, underTest.removeFirst());
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.removeFirst());
	}

	@Test
	@DisplayName("AbstractArray removeLast method 测试")
	public void testRemoveLast() {
		underTest.addLast(1);
		underTest.addLast(2);
		underTest.addLast(3);
		underTest.addLast(4);
		underTest.addLast(5);
		assertEquals(5, underTest.removeLast());
		assertEquals(4, underTest.removeLast());
		assertEquals(3, underTest.removeLast());
		assertEquals(2, underTest.removeLast());
		assertEquals(1, underTest.removeLast());
		assertThrows(IndexOutOfBoundsException.class, () -> underTest.removeLast());
	}

	@Test
	@DisplayName("AbstractArray removeStream method 测试")
	public void testStream() {
		// Setup
		underTest.addLast(1);
		underTest.addLast(2);
		underTest.addLast(3);
		underTest.addLast(4);
		underTest.addLast(5);
		// Run the test
		final Stream<Integer> result = underTest.stream();
		underTest.stream().forEach(System.out::print);
		// Verify the results
	}

	@Test
	@DisplayName("AbstractArray iterator method 测试")
	public void testIterator() {
		underTest.addLast(1);
		underTest.addLast(2);
		underTest.addLast(3);
		underTest.addLast(4);
		underTest.addLast(5);
		assertIterableEquals(List.of(1, 2, 3, 4, 5), underTest);
	}

	@Test
	@DisplayName("AbstractArray forEach method 测试")
	public void testForEach() {
		// Setup
		underTest.addLast(1);
		underTest.addLast(2);
		underTest.addLast(3);
		underTest.addLast(4);
		underTest.addLast(5);
		// Run the test
		underTest.forEach(System.out::print);

		// Verify the results
	}

	@Test
	@DisplayName("AbstractArray forEach method NullPointer 测试")
	public void testForEach_ThrowsNullPointerException() {
		// Setup
		underTest.addLast(1);
		underTest.addLast(2);
		underTest.addLast(3);
		underTest.addLast(4);
		underTest.addLast(5);
		// Run the test
		assertThrows(NullPointerException.class, () -> underTest.forEach(null));
	}

}
