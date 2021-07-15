package com.digite.cc;

@FunctionalInterface
public interface Currency {
	double dollarValue();
	
	static double convert(Currency source, Currency target, double amount) {
		double rate = target.dollarValue() / source.dollarValue();
		return rate * amount;
	}
	
	static Currency USD = () -> 1.0;
	static Currency INR = () -> 72.50;
	static Currency AED = () -> 3.65;
}
