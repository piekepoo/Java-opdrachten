
// -----------------------------------------------------------
// "Lists", Assignment 4 Sogyo
//
// (C) 2020 Pieke Heijmans
// -----------------------------------------------------------

package javaopdrachten;

import java.util.Date;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;

import java.time.LocalDate;
import java.time.Month;


public class quote {

    // Generates quotes.
    static String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"rené descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };

    // Function to capitalize each word in a given string.
    public static String capitalizeAll(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Arrays.stream(str.split("\\s+"))
                .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
    }
    

    public static void main(String... args) {
    	
        //Takes current date and puts it into a variable in a certain format.
        Date date = new Date();
        SimpleDateFormat formatDotw = new SimpleDateFormat("EEEE"); //Get day of the week.
        SimpleDateFormat formatM = new SimpleDateFormat("MMMM"); //Get month.
        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth(); //Get day of the month.

        // Displays day of the week, day of the month and month.
        System.out.println("Quote voor " + formatDotw.format(date) + " " + currentDay + " " + formatM.format(date) + ":");
        
        // Initializes random quote.
        int random_int = (int)(Math.random() * (5 - 0 + 1) + 0);
        String[] rdmQuote = quotes[random_int];
        
        //Replace each first letter of the nested string array to a capital letter.
        for (int i = 0; i < rdmQuote.length; i++) {
        	char c = rdmQuote[i].charAt(0);
        	c = Character.toUpperCase(c);
        	char[] chars = rdmQuote[i].toCharArray();
        	chars[0] = c;
        	rdmQuote[i] = String.valueOf(chars);
        }

        // Prints quote and capitalizes all names on the left side of the Quotes string array)
        System.out.println(rdmQuote[1] + ". -- " + capitalizeAll(rdmQuote[0]));
    }

}
