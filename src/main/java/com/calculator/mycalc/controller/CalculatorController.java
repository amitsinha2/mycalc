package com.calculator.mycalc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@GetMapping("/calculate/{number1}/{number2}/{operation}")
	public String calculate(@PathVariable("number1") long number1, @PathVariable("number2") long number2,
			@PathVariable("operation") String operation) throws Exception {
		if (operation == null || number1 == 0 ||  number2 == 0) {
			return "Invalid inputs";
		}
		if (operation.equalsIgnoreCase("+") || operation.equalsIgnoreCase("add")) {
			return String.valueOf(number1 + number2);
		} else if (operation.equalsIgnoreCase("-") || operation.equalsIgnoreCase("substract")) {
			return String.valueOf(number1 - number2);
		} else if (operation.equalsIgnoreCase("*") || operation.equalsIgnoreCase("multiply")) {
			return String.valueOf(number1 * number2);
		} else if (operation.equalsIgnoreCase("/") || operation.equalsIgnoreCase("division")) {
			return String.valueOf(number1 / number2);
		} else {
			return "Invalid operation";
		}
	}

}
