package package1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hangman {

	public static void main(String[] args) {



		String[] possibleWords = { "Watermelon", "Government","Behavior", "Valley", "Bank", "Disclose" };
		String word = possibleWords[(int) (Math.random() * possibleWords.length)].toUpperCase();
		//System.out.println(word);
		int nrOfGuesses = 10;
		List<String> memoryBox = new ArrayList<String>();
		String placeholder = new String(new char[word.length()]).replace("\0", "_");
		System.out.println("Welcome to Hangman! The computer has chosen a word and you have to guess the word one letter at a time. "); 
		System.out.println("Good luck!"); 
		System.out.println(""); 

		while (nrOfGuesses >= 1 && placeholder.contains("_")) {
			System.out.println("You have " + nrOfGuesses + " guesses left.");
			System.out.println("");
			System.out.print(placeholder);
			System.out.print(" (" + word.length() + ") letters");   
			System.out.println("");
			System.out.println("");
			System.out.print("Enter a guess: ");
			String guess = new Scanner(System.in).nextLine().toUpperCase();
//			if (guess == word) {
//				System.out.println("You found the word!");
//			}
			if (guess.matches("[A-Za-z]{1}")) {

				String guessedLetter = "";

				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == guess.charAt(0)) {
						guessedLetter += guess.charAt(0);
					} else if (placeholder.charAt(i) != '_') {
						guessedLetter += word.charAt(i);
					} else {
						guessedLetter += "_";
					}

				}

				//guess = guess.toUpperCase();
				nrOfGuesses -= 1;
				memoryBox.add(guess);
				System.out.println("Your guess: " + guess);  

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
			else {
				System.out.println("");
				System.out.println("Please enter an alphabetic letter."); 
			}
		}
		if(nrOfGuesses < 1 && placeholder.contains("_") == true){
			System.out.println("Too bad. Better luck next time."); 
			System.out.println("The word was " + word); 
		}

		if(placeholder.contains("_") == false){
			System.out.println("Great job! You found the word."); 
		}

	}
}
