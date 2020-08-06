
// -----------------------------------------------------------
// "Lists", Assignment 2 Sogyo
//
// (C) 2020 Pieke Heijmans
// -----------------------------------------------------------

package javaopdrachten;

import java.util.Arrays;

public class lists {

	public static void main(String[] args) {
		
		// 1. Create Array
		int[] numbers = new int[10];
		
		// Print Array
		for(int i = 0; i < numbers.length; i++) {
			int random_int = (int)(Math.random() * (100 - 0 + 1) + 0);
			numbers[i] = random_int;
		}
		System.out.println("1. Randomized array: " + Arrays.toString(numbers));
		
		// 2. Highest Value
		int highest = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > highest) {
			 highest = numbers[i];
			}
		}
		System.out.println("2. The highest value of the array is: " + highest + ".");
		
		// 3.  Lowest Two
		int lowest = 100;
		int secondlowest = 100;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < lowest) {
				secondlowest = lowest;
				lowest = numbers[i];
			}
			if(numbers[i] > lowest && numbers[i] < secondlowest) {
				secondlowest = numbers[i];
			}
		}
		System.out.println("3. The sum of the two lowest values is " + lowest + " + " + secondlowest + " = " + (lowest + secondlowest) + ".");
		
		// 4.  Filter Even
		int[] filterEven = new int[10]; //Create new array
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] % 2 == 0)
				filterEven[i] = numbers[i];
		}
		filterEven = Arrays.stream(filterEven).filter(x -> x > 0).toArray(); //Drop all 0's from Array
        System.out.println("4. The even numbers in this array are: " + Arrays.toString(filterEven));
		
        
		// 5. Split Four List
		int[] divideBy3 = new int[10]; //Create new, alternative Arrays
		int[] divideBy5 = new int[10];
		int[] remainders = new int[10];
		
		for(int i = 0; i < numbers.length; i++) { //Loop through main Array.
			if(numbers[i] % 3 == 0) {
				divideBy3[i] = numbers[i]; //Put number divided by 3 in alternative Array
			}	
			if(numbers[i] % 5 == 0) { // ... divided by 5...
				divideBy5[i] = numbers[i];
			}
			if (numbers[i] % 2 != 0 && numbers[i] % 3 != 0 && numbers[i] % 5 != 0) { //... same for remainders.
				remainders[i] = numbers[i];
			}
		}
		// Drop all 0's from Arrays so there are no empty spots in the display.
		divideBy3 = Arrays.stream(divideBy3).filter(x -> x > 0).toArray();
		divideBy5 = Arrays.stream(divideBy5).filter(x -> x > 0).toArray();
		remainders = Arrays.stream(remainders).filter(x -> x > 0).toArray();

		
		System.out.println("5. ~~ Four list ~~ ");
		System.out.println("   Divided by 2: " + Arrays.toString(filterEven));
		System.out.println("   Divided by 3: " + Arrays.toString(divideBy3));
		System.out.println("   Divided by 5: " + Arrays.toString(divideBy5));
		System.out.println("   Remainders: " + Arrays.toString(remainders));

		
		// 6. Sort List
	    for (int j = 0; j < numbers.length; j++) {
	        for (int i = 1; i < numbers.length - j; i++) {
	            if (numbers[i-1] > numbers[i]) {
	                int k = numbers[i];
	                numbers[i] = numbers[i-1];
	                numbers[i-1] = k;
	            }
	        }
	    }
		System.out.println("6. Array sorted: " + Arrays.toString(numbers));
	}

}

