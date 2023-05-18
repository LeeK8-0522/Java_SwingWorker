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
	public ArrayList<Integer> getFibonacciSeries() {
		return this.fibonacciSeries;
	}//returns fibonacci-series in integer list
	
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
	}//setter method for number-of-row field
	
	public void setSumOfSeries(int input) {
		this.sumOfSeries = input;
	}//setter method for sumOfSeries field
	
	// * Below are methods that provide various arithmetic functions for fields *
	public void calculateSumOfSeries(int input) {
		this.sumOfSeries += input;
	}//add input number to sum of fibonacci series
	
	public void addFibonacciElement(int input) {
		this.fibonacciSeries.add(input);
	}//add input integer element to fibonacci-series list
	
	public void clearFibonacciSeries() {
		this.fibonacciSeries.clear();
	}//clear fibonacci-series list
	// * finish implementing *
}
