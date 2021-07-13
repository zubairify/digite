package com.digite.stock;

/**
 * This class represents stock of any random company. It maintains the quotes of theie
 * stock status.
 * @author Zubair Shaikh
 * @version 1.0
 */
public class Stock implements Exchange {

	/** Method to see the current quote of the stock. */
	public void viewQuote() {
		System.out.println("View Quote");
	}
	
	public void getQuote() {
		System.out.println("Get Quote");
	}
	
	public void setQuote() { 
		System.out.println("Set Quote");
	}
}
