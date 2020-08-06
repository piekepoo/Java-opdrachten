

// -----------------------------------------------------------
// "Leap year", Assignment 1 Sogyo
//
// (C) 2020 Pieke Heijmans
// -----------------------------------------------------------

package javaopdrachten;

import java.util.Scanner;

public class leapyear {

	public static void main(String[] args) {
		
		// Asking for user input.
		System.out.println("Please enter a year to check if the entered year is a leap year.");
		int year = new Scanner(System.in).nextInt();
		System.out.println("The year you entered is " + year + ".");
		
		
		// Check if year is dividible by 4, by 100 and by 400.
		if (year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					System.out.println("The year you entered is a leap year.");
					}
					else {
						System.out.println("The year you entered is not a leap year.");
					}
				}
				else {
					System.out.println("The year you entered is a leap year.");	
				}
			}
		else {
		System.out.println("The year you entered is not a leap year.");
		}
	}
}
