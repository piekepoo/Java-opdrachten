
// -----------------------------------------------------------
// "Roborally", Assignment 5 Sogyo
//
// (C) 2020 Pieke Heijmans
// -----------------------------------------------------------


package javaopdrachten;

import java.util.ArrayList;
import java.util.List;

public class roborally {

	public static void main(String[] args) {

		// 2. Initiate robots with different positions.
		Robot my_first_robot = new Robot(0, 1, "East");
		Robot my_second_robot = new Robot(1, 0, "West");

		// My first robot is moving.
		System.out.println("The first robot: ");
		my_first_robot.printState(); // Print starting position.
		my_first_robot.backward(); // Saves command.
		my_first_robot.printState(); // As you see, the position did not change.
		my_first_robot.turnRight();
		my_first_robot.execute();
		my_first_robot.printState(); // It did after execution.
		my_first_robot.turnRight(); // To West
		my_first_robot.turnRight(); // To North
		my_first_robot.forward(); // y + 1
		my_first_robot.execute(); // Try to keep track of the movements! 
		my_first_robot.printState(); // We changed to North and added +1 to Y
		my_first_robot.turnRight();
		my_first_robot.execute();
		my_first_robot.printState();
		my_first_robot.turnLeft();
		my_first_robot.forward(3);
		my_first_robot.execute();
		my_first_robot.printState(); // A couple more changes...
		
		// My second robot is moving.
		System.out.println("The second robot: "); //Does it work on a second robot?
		my_second_robot.printState();	
		my_second_robot.turnRight(); // From West to Facing North
		my_second_robot.forward(); // Y + 1
		my_second_robot.forward(2); // Y + 2
		my_second_robot.forward(); // Y + 1
		my_second_robot.execute(); 
		my_second_robot.printState();	 // Facing North, plus 4
		
	}

}


//1. Create class of robots with default values.
class Robot{
	int posx = 0;
	int posy = 0;
	String facing = "North";
	CommandList commands = new CommandList();



	// creates class constructors.
	public Robot(int x, int y, String f) {
		posx = x;
		posy = y;
		facing = f;
	}
	
	// This lets the robot execute the positions.
	public void execute() {
		commands.run(); // We are running all the commands of the commands class!
		commands.emptyCommands(); // Once we've run them, the class List need to be emptied, so we call this function where this happens.
	}

	// 3. The robot turns Right
	public void turnRight() {
		String turnRight = "turnRight"; //We keep a string value turnRight.
		commands.addMethod(turnRight); // And add it to the commands class.
	}
	
	// 3. The robot turns Left
	public void turnLeft() {
		String turnLeft = "turnLeft";
		commands.addMethod(turnLeft);
	}
	// 4. Robot moves forward.
	public void forward() {
		String forward = "forward";
		commands.addMethod(forward);
	}
	// 4. Robot moves forward, a second instance where we actually define a speed.
	public void forward(int speed) {
		String forward = "forward";
		commands.addMethod(forward, speed); // We need to not only add the method, but the speed as well.
	}
	// 4. Robot moves backward.
	public void backward() {
		String backward = "backward";
		commands.addMethod(backward);
	}

	// Prints state of the robot to the console.
	public void printState() {
		System.out.println("Now facing \"" + facing + "\" at (" + posx + ", " + posy + ")" );
	}

	// Print the attributes without printing the hashport.
	public String toString(){ // Overrides the toString() method  
		return "(" + posx + ", " + posy +") " + facing;  
	}  
	
	//create a class commandlist that stores commands in a list.
	class CommandList {
		// We need a runnable method to know which runnable we are going to execute.
		Runnable method;

		// And a list to store those runnables.
		List<Runnable> listOfMethods = new ArrayList<>();
		
		// And a function to add the runnables to the list.
		public void addMethod(String commands) {
			if (commands == "turnRight") { // Based on what runnable we want to add, we store a different command to the list.
				Runnable turnRight = () ->  turnRight(); // Initialize the runnable.
				listOfMethods.add(turnRight); // Add the runnable to the list.
			}
			if (commands == "turnLeft") {
				Runnable turnLeft = () ->  turnLeft();
				listOfMethods.add(turnLeft);
			}
			if (commands == "forward") {
				Runnable forward = () ->  forward(1);
				listOfMethods.add(forward);
			}
			if (commands == "backward") {
				Runnable backward = () ->  backward();
				listOfMethods.add(backward);
			}
		}
		
		// We need a second addmethod function that needs to be able to take in different speeds for the forward movement.
		// We don't have to check for the "forward" string, because the code is written so that's the only one that takes integer input.
		public void addMethod(String commands, int speed) { // Takes in the command string and the speed.
			Runnable forward = () ->  forward(speed); // Initialize runnable.
			listOfMethods.add(forward);
		}
		
		// Function that clears the commands.
		public void emptyCommands() {
			listOfMethods.clear();
		}
		
		// Function that runs the commands.
		public void run() {
			for(Runnable aMethod : listOfMethods) {
				aMethod.run();
			}
		}
		
		// For our different runnables, we need to execute different functions.
		// This is where the actions are actually executed rather than stored.
		void turnRight(){
			String newfacing = null; // Initialize empty variable.
			if(facing == "North") {
				newfacing = "East"; // Change variable based on the facing.
			}
			else if(facing == "East") {
				newfacing = "South";

			}
			else if(facing == "South") {
				newfacing = "West";

			}
			else if(facing == "West") {
				newfacing = "North";

			}
			facing = newfacing;	// Overrides the facing.
		}

		// Turn Left function
		public void turnLeft() {
			String newfacing = null;
			if(facing == "North") {
				newfacing = "West";
			}
			else if(facing == "East") {
				newfacing = "North";
			}
			else if(facing == "South") {
				newfacing = "East";

			}
			else if(facing == "West") {
				newfacing = "South";

			}
			facing = newfacing;

		}	
		
		// Forward function
		public void forward(int speed) {
			if(speed < 1 || speed > 3) { // If speed is less than 1 or more than 3, 
				speed = 1; // We give it value 1.
			}
			if(facing == "North") {
				posy += speed; // If we are faced North, our Y increases..
			}
			if(facing == "East") {
				posx += speed; //If we are faced East, our X increases..

			}
			if(facing == "South") {
				posy -= speed;

			}
			if(facing == "West") {
				posx -= speed;		
			}	
		}

		// Backward function
		public void backward() { // Opposite to forward.
			if(facing == "North") {
				posy--;
			}
			if(facing == "East") {
				posx--;

			}
			if(facing == "South") {
				posy++;

			}
			if(facing == "West") {
				posx++;		
			}	
		}
	}
}





