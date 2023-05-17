package Main;

import java.util.ArrayList;

public class FibonacciModel {
	// * Below are fields * 
	private ArrayList<Integer> fibonacciSeries;
	private int sumOfSeries = 0;//store sum of fibonacci series
	private int numberOfRow = 0;//store number of row which is equals to number of elements of series
	//finish implementing fields
	
	public FibonacciModel() {//constructor
		fibonacciSeries = new ArrayList<Integer>();
	}
	
	// * Below are getter-methods *
	public int getFibonacciElement(int index) {
		return this.fibonacciSeries.get(index);
	}//returns the value of element in index
	
	public int getSumOfSeries() {
		return this.sumOfSeries;
	}
	
	public int getnumberOfRow() {
		return this.numberOfRow;
	}
	//finish implementing getter-methods
	
	public void setNumberOfRow(int input) {
		this.numberOfRow = input;
	}
	
	// * Below are methods that provide various arithmetic functions for fields *
	public void calculateSumOfSeries(int input) {
		this.sumOfSeries += input;
	}
	
	public void addFibonacciElement(int input) {
		this.fibonacciSeries.add(input);
	}
	
	public void clearFibonacciSeries() {
		this.fibonacciSeries.clear();
	}
	
}
