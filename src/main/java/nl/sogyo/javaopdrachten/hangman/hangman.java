
// -----------------------------------------------------------
// "Hangman", Assignment 3 Sogyo
//
// (C) 2020 Pieke Heijmans
// -----------------------------------------------------------

package javaopdrachten;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hangman {

	public static void main(String[] args) {


		// Initialize possible words and pick random word. List can be expanded.
		String[] possibleWords = { "Watermelon", "Government","Behavior", "Valley", "Bank", "Disclose" };
		String word = possibleWords[(int) (Math.random() * possibleWords.length)].toUpperCase();

		// Initialize guesses, memory and a placeholder for unguessed letters.
		int nrOfGuesses = 10;
		List<String> memoryBox = new ArrayList<String>();
		String placeholder = new String(new char[word.length()]).replace("\0", "_");

		// Introduce game.
		System.out.println("Welcome to Hangman! The computer has chosen a word and you have to guess the word one letter at a time. "); 
		System.out.println("Good luck!"); 
		System.out.println(""); 

		// Start loop while player has guesses left and did not guess the word.
		while (nrOfGuesses >= 1 && placeholder.contains("_")) {
			System.out.println("You have " + nrOfGuesses + " guesses left.");
			System.out.println("");
			System.out.print(placeholder);
			System.out.print(" (" + word.length() + ") letters");   
			System.out.println("");
			System.out.println("");

			// Player can enter a guess.
			System.out.print("Enter a guess: ");
			String guess = new Scanner(System.in).nextLine().toUpperCase();
//			if (guess == word) {
//				System.out.println("You found the word!");
//			}

			// Check if guess is a number.
			if (guess.matches("[A-Za-z]{1}")) {

				String guessedLetter = "";

				// Iterate over word and replace letters if they match with the input.
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == guess.charAt(0)) {
						guessedLetter += guess.charAt(0);
					} else if (placeholder.charAt(i) != '_') {
						guessedLetter += word.charAt(i);
					} else {
						guessedLetter += "_";
					}

				}
				// Update Nr of gusses and add guess to memory.
				nrOfGuesses -= 1;
				memoryBox.add(guess);

				System.out.println("Your guess: " + guess);  

				// Check whether guess was positive or negative.
				if(word.contains(guess) == true){
					placeholder = guessedLetter.toUpperCase();
					System.out.println("The letter " + guess +  " is in the word."); 
				}
				if(word.contains(guess) == false){
					System.out.println("Sorry, pal. The letter " + guess +  " is not in the word."); 
				}

				System.out.println(""); 
				System.out.print("Previous guesses: " + memoryBox);
				System.out.println("");
			}

			// Checks whether input is alphabetic.
			else {
				System.out.println("");
				System.out.println("Please enter an alphabetic letter."); 
			}
		}

		// Checks whether there are enough gueses left and if there were still open spots.
		if(nrOfGuesses < 1 && placeholder.contains("_") == true){
			System.out.println("Too bad. Better luck next time."); 
			System.out.println("The word was " + word); 
		}

		// Checks whether all placeholders were filled.
		if(placeholder.contains("_") == false){
			System.out.println("Great job! You found the word."); 
		}

	}
}
