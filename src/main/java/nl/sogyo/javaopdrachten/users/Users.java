// -----------------------------------------------------------
// "Exceptional Users ", Assignment 8 Sogyo
// -----------------------------------------------------------

package javaopdrachten;

import java.util.Scanner;

public class Users {

	public static void main(String[] args) throws Exception {

		// Call conditionsValidated function
		conditionsValidated();
	}

	public static boolean conditionsValidated() {
		askUsername(); // First ask the username.
		do {
			if( askPassword() == true) { // True is when requirements are met.
				System.out.println("Registered user Sogyo.");
				return false; 
			}
			else {
				System.out.println("This is not a valid password. Please enter a stronger password."); // Give error message if conditions are not met.
			}
		}
		while (true); // Keep going until loop is broken by meeting the requirements.
	}


	public static void conditionsValidatedWithE() throws Exception { // Same function but with exception error.
		try {
			askUsername();
			if( askPassword() == true) {
				System.out.println("Registered user Sogyo."); 
			}
			else {
				throw new Exception("User Sogyo has not been registered."); 
			}
		}
		catch (Exception e) {
			System.out.println("Something has gone wrong."); // Catch exception and print something else.
		}
	}

	public static void askUsername() {
		System.out.println("Enter a username: ");
		String username = new Scanner(System.in).nextLine(); // Register username. Anything is possible?

	}

	public static boolean askPassword(){
		boolean number = false; 
		boolean lowercase = false; 
		boolean uppercase = false; 
		System.out.println("Enter a password: ");
		String password = new Scanner(System.in).nextLine(); 
		char[] charArrayPw = password.toCharArray(); // Change string to character array.
		for(int i=0; i < charArrayPw.length; i++){ // Loop over char array.
			if( Character.isUpperCase( charArrayPw[i] )) {
				uppercase = true; //Change booleans if conditions are met.
			}
			if( Character.isLowerCase( charArrayPw[i] )) {
				lowercase = true;
			}
			if( Character.isDigit( charArrayPw[i] )) {
				number = true;
			}
		}
		if (uppercase == true && lowercase == true && number == true) {
			return true; // If all conditions are met, return true.
		}
		return false;
	}

}
