
// -----------------------------------------------------------
// "Fractional calculation", Assignment 6 Sogyo
//
// (C) 2020 Pieke Heijmans
// -----------------------------------------------------------


package javaopdrachten;
import org.apache.commons.math3.fraction.BigFraction;

public class fractionalCalculation {

	public static void main(String[] args) {
		Fraction fract = new Fraction(3, 10);
		
		//Requirements
		
		//Fraction 1/3
		System.out.println("double toDecimalNotation() -> 1/3 should return 0.33333 ----> " + fract.toDecimalNotation());
		System.out.println("string toString() -> 1/3 should return 1/3 ----> " + fract.toString());
		System.out.println("Fraction add(int number) -> 1/3 + 1 should become 4/3 ----> " + fract.add(1));
		System.out.println("Fraction add(Fraction fraction) -> 1/3 + 1/6 should become 1/2 ----> " + fract.add(1, 6));
		
		//Fraction 4/3
		System.out.println("Fraction subtract(int number) -> 4/3 - 1 should become 1/3 ----> " + fract.subtract1(1));
		
		//Fraction 1/2
		System.out.println("Fraction subtract(Fraction fraction) -> 1/2 - 1/6 should become 1/3 ----> " + fract.subtract(1, 6));
		
		//Fraction 3/4
		System.out.println("Fraction multiply(int number) -> 3/4 * 2 should become 3/2 ----> " + fract.multiply(2));
		System.out.println("Fraction multiply(Fraction fraction) -> 3/4 * 2/5 should become 3/10 ----> " + fract.multiply(2, 5));
		
		//Fraction 3/2
		System.out.println("Fraction divide(int number) -> 3/2 / 2 should become 3/4 ----> " + fract.divide(2));
		
		//Fraction 3/10
		System.out.println("Fraction divide(Fraction fraction) -> 3/10 / 2/5 should become 3/4 ----> " + fract.divide(2, 5));
		
	}
}

// Creating a class with the numerator and denumerator traits.
class Fraction{
	int numerator;
	int denumerator;

	// With class constructors
	public Fraction (int n, int d){
		numerator = n;
		denumerator = d;


	}
	
	// Function that takes the numerator and denumerator of the class object and outputs its decimal notation.
	public double toDecimalNotation() {
		double n = numerator;
		double d = denumerator;
		double notation = n / d;
		return notation;
	}
	
	// Function that outputs the class num and denum as a string
	public String toString() {
		String n = String.valueOf(numerator);
		String d = String.valueOf(denumerator);
		String sToString = n + " / " + d;
		return sToString;
	}
	
	// Function that adds integer to the fraction.
	public String add(int number) {
		double n = numerator;
		double d = denumerator;
		double numb = number;
		double added = n / d + numb; //This is the "double" value of the fraction and the integer added up.
		String addedStr = new BigFraction(added, 0.00000002D, 10000).toString(); //This double value is converted to a fraction with this imported module feature. Then it is converted to a string.
		return addedStr; // Outputted is the fraction as a string.
	}
	
	// Function that adds a second fraction to the first fraction.
	public String add(int num2, int denum2) {
		double n = numerator;
		double d = denumerator;
		double n2 = num2; // Here we need to assign a value to the second numerator
		double d2 = denum2; // And the second denumerator
		double added = (n / d) + (n2 / d2); //Convert all back into a double
		String addedStr = new BigFraction(added, 0.00000002D, 10000).toString(); //Translate double to String
		return addedStr;
		
	}
	
	// Function that subtracts an integer from the fraction.
	public String subtract1(int number) {
		double n = numerator;
		double d = denumerator;
		double numb = number;
		double subtracted = n / d - numb; //Subtract instead of add.
		String subtractedStr = new BigFraction(subtracted, 0.00000002D, 10000).toString();
		return subtractedStr;	
	}
	
	// Function that subtracts a second fraction from the first fraction.
	public String subtract(int num2, int denum2) {
		double n = numerator;
		double d = denumerator;
		double n2 = num2;
		double d2 = denum2;
		double subtracted = (n / d) - (n2 / d2);
		String subtractedStr = new BigFraction(subtracted, 0.00000002D, 10000).toString();
		return subtractedStr;		
	}
	
	// Function that multipies fraction with integer.
	public String multiply(int number) {
		double n = numerator;
		double d = denumerator;
		double numb = number;
		double multiplied = (n / d) * numb; //Only the formulas are changing from now on.
		String multipliedStr = new BigFraction(multiplied, 0.00000002D, 10000).toString();
		return multipliedStr;
	}
	
	public String multiply(int num2, int denum2) { // Or the amount of input variables
		double n = numerator;
		double d = denumerator;
		double n2 = num2;
		double d2 = denum2;
		double multiplied = (n / d) * (n2 / d2);
		String multipliedStr = new BigFraction(multiplied, 0.00000002D, 10000).toString();
		return multipliedStr;	
	}
	
	// Function that divides a fraction by a given integer.
	public String divide(int number) {
		double n = numerator;
		double d = denumerator;
		double numb = number;
		double divided = (n / d) / numb;
		String dividedStr = new BigFraction(divided, 0.00000002D, 10000).toString();
		return dividedStr;
		
	}

	// Function that divides a fraction by another fraction.
	public String divide(int num2, int denum2) {
		double n = numerator;
		double d = denumerator;
		double n2 = num2;
		double d2 = denum2;
		double divided = (n / d) / (n2 / d2);
		String dividedStr = new BigFraction(divided, 0.00000002D, 10000).toString();
		return dividedStr;
		
	}
}
