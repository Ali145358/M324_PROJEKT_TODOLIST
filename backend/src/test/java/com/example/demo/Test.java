package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

	@Test
	void testDefaultConstructor() {
		Task task = new Task();
		assertNull(task.getTaskdescription(), "Default taskdescription should be null");
	}

	@Test
	void testSetAndGetTaskdescription() {
		Task task = new Task();
		task.setTaskdescription("Testbeschreibung");
		assertEquals("Testbeschreibung", task.getTaskdescription());
	}


	// Removed duplicate testSetTaskdescriptionToEmptyString() to resolve compilation error

	@Test
	void testTaskdescriptionWithWhitespace() {
		Task task = new Task();
		task.setTaskdescription("   ");
		assertEquals("   ", task.getTaskdescription());
	}

	@Test
	void testTaskdescriptionWithSpecialCharacters() {
		Task task = new Task();
		String special = "!@#$%^&*()_+-=[]{}|;':,.<>/?";
		task.setTaskdescription(special);
		assertEquals(special, task.getTaskdescription());
	}

	@Test
	void testMultipleSetTaskdescription() {
		Task task = new Task();
		task.setTaskdescription("First");
		assertEquals("First", task.getTaskdescription());
		task.setTaskdescription("Second");
		assertEquals("Second", task.getTaskdescription());
	}

	@Test
	void testEqualsAndHashCodeWithSameDescription() {
		Task task1 = new Task();
		Task task2 = new Task();
		task1.setTaskdescription("Aufgabe");
		task2.setTaskdescription("Aufgabe");
		assertEquals(task1, task2);
		assertEquals(task1.hashCode(), task2.hashCode());
	}

	@Test
	void testEqualsAndHashCodeWithDifferentDescription() {
		Task task1 = new Task();
		Task task2 = new Task();
		task1.setTaskdescription("A");
		task2.setTaskdescription("B");
		assertNotEquals(task1, task2);
		assertNotEquals(task1.hashCode(), task2.hashCode());
	}

	@Test
	void testEqualsWithNull() {
		Task task = new Task();
		task.setTaskdescription("Test");
		assertNotEquals(task, null);
	}

	@Test
	void testEqualsWithDifferentClass() {
		Task task = new Task();
		task.setTaskdescription("Test");
		assertNotEquals(task, "Test");
	}

	@Test
	void testToString() {
		Task task = new Task();
		task.setTaskdescription("ToStringTest");
		String str = task.toString();
		assertNotNull(str);
		assertTrue(str.contains("ToStringTest"));
	}


	@Test
	void testSetTaskdescriptionToNull() {
		Task task = new Task();
		task.setTaskdescription(null);
		assertNull(task.getTaskdescription());
	}

	@Test
	void testSetTaskdescriptionToEmptyString() {
		Task task = new Task();
		task.setTaskdescription("");
		assertEquals("", task.getTaskdescription());
	}

}

