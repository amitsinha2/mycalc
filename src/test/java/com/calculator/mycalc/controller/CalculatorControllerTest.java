package com.calculator.mycalc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CalculatorControllerTest {

	@InjectMocks
	CalculatorController calculator;

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	private HttpSession session;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateForAddition() throws Exception {
		String result = calculator.calculate(1, 2, "+");
		assertNotNull(result);
		assertEquals("3", result);
	}

	@Test
	void testCalculateForSubstraction() throws Exception {
		String result = calculator.calculate(1, 2, "-");
		assertNotNull(result);
		assertEquals("-1", result);
	}

	@Test
	void testCalculateForMultiplication() throws Exception {
		String result = calculator.calculate(1, 2, "*");
		assertNotNull(result);
		assertEquals("2", result);
	}

	@Test
	void testCalculateForDivision() throws Exception {
		String result = calculator.calculate(4, 2, "/");
		assertNotNull(result);
		assertEquals("2", result);
	}

	@Test
	void testCalculateForOtherOperation() throws Exception {
		String result = calculator.calculate(1, 2, "%");
		assertNotNull(result);
		assertEquals("Invalid operation", result);
	}
}
