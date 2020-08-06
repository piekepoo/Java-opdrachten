package package1;

import java.util.Scanner;

public class leapyear {

	public static void main(String[] args) {
		
		System.out.println("Please enter a year to check if the entered year is a leap year.");
		int year = new Scanner(System.in).nextInt();
		System.out.println("The year you entered is " + year + ".");
		
		
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
