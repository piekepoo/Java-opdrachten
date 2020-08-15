// -----------------------------------------------------------
// "Decision Tree", Assignment 7 Sogyo
//
// (C) 2020 Pieke Heijmans
// -----------------------------------------------------------

package javaopdrachten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class decisionTree {

	public static void main(String[] args) throws IOException {

		// New array list to dissolve the file per sentence.
		ArrayList<String> perSentence = new ArrayList<String>();

		// Read the file.
		try {
			// Make sure the pathname is correct and copy it here!
			File fileDir = new File("/Users/UserName/java-opdrachten/src/main/java/nl/sogyo/javaopdrachten/decisiontree/decision-tree-data.txt");

			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileDir), "UTF8"));

			String str;

			// Add lines to the sentences array.
			while ((str = in.readLine()) != null) {
				perSentence.add(str);
			}

			in.close();
		}

		//Correct for errors  and exceptions.
		catch (UnsupportedEncodingException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		// Creates 2 arrays, one for nodes and one for edges.
		ArrayList<String> nodes = new ArrayList<String>();
		ArrayList<String> edges = new ArrayList<String>();

		// We need to dissect the sentences to meaningful arrays, into nodes and edges.
		for (String sentence : perSentence) { 
			String s = Character.toString(sentence.charAt(4)); //The fourth character of each line is N for the edges, not for the nodes. That's how i'm going to make the distinction between them.
			if (s.equals("N")) { 
				edges.add(sentence.substring(0, 2)); // We add the first 2 characters that tell us which node we have to the edge array, eg N1
				edges.add(sentence.substring(4, 6)); // We add the edge signifier to the array, that tells us which node we will reach following this edge.
				edges.add(sentence.substring(8)); // We add the rest of the sentence to the array. (Will be Ja or Nee in this case)
			}
			else { //Else, we have a node. (if the fourth character is not N)
				nodes.add(sentence.substring(0,2)); 
				nodes.add(sentence.substring(4)); 

			}
		}	
		// The nodes array looks something like (N1, is het blad..?, N2, Is de rand..?]
		// The edges array looks something like [N1, N2, Nee, N2, N3, Ja, etc]

		// Create question and answer variable. 
		String question = "N1"; 
		String answer = null; 

		while(answer != "N0" || answer != "N6" || answer != "N7" || answer != "N8" || answer != "N9") {
			// Keep going until we have reached the end of a branch, the destination.

			// Print the questions.
			for(int i = 0; i < nodes.size(); i++) {
				String nodesToStr = nodes.get(i); 
				if (nodesToStr.equals(question) == true && (i % 2 == 0)) { // In the nodes array, only print if they match with the question that we wanna ask, and check if they are the 0th, 2th, 4th element etc. Remember that the the 1th, 3th element are node signifiers such as N1, N2 etc. 
					System.out.println(nodes.get(i+1)); 
				}
			}

			// Print the possible answers/edges.
			for(int i = 0; i < edges.size(); i++) {
				String edgesToStr = edges.get(i); 
				if (edgesToStr.equals(question) == true && (i % 3 == 0)) { // Again the edges need to match with the question. Also, we want only the 0th, 3th, 6th etc element.
					System.out.println(edges.get(i+2)); 
				}
			}
			// Ask for user input
			while(answer != "Ja" || answer != "Nee") {
				answer = new Scanner(System.in).nextLine().toUpperCase(); 
				if (answer.matches("JA")) {
					answer = "Ja"; 
					break; 
				}
				else if (answer.matches("NEE")) {
					answer = "Nee";
					break;
				}
				else { // We want valid output.
					System.out.println("Wil je echt niet weten wat om wat voor boom het gaat? Kies Ja of Nee."); 
				}
			}

			// Now, we need to replace the question with the new node that was the result of the edge that the user chose.
			for(int i = 0; i < edges.size(); i++) { 
				String edgesToStr = edges.get(i); 
				if (edgesToStr.equals(question) == true && (i % 3 == 0)) { // We loop again through only the nodes that match with the question.
					String YesOrNo = edges.get(i+2);; // Here, we take the possibilities that were there: either Ja or Nee.
					if (YesOrNo.equals(answer) == true){ 
						question = edges.get(i+1); // ...If they match, we replace the old question with the answer
						break; 
					}
				}
			}
		}
	}

}
