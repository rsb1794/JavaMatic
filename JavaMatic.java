import java.util.*;

public class JavaMatic {
	//Note: to add a new drink, modify the drinks[] and recipes[][] arrays by adding the new drink's name and recipe at the appropriate place.

	//drinks array holding the name of each drink in alphabetical order
	private static final String[] drinks = {"Caffe Americano","Caffe Latte", "Caffe Mocha","Cappuccino","Coffee", "Decaf Coffee"};
	//ingredients array holding the name of each ingredient in alphabetical
	private static final String[] ingredients= {"Cocoa","Coffee","Cream", "Decaf Coffee","Espresso","Foamed Milk","Steamed Milk","Sugar","Whipped Cream"};
	
	//Recipes array contains number of each ingredient required for each drink
	//recipes[i][j] = units of ingredient j needed for drink i.
	private static final int[][] recipes = {{0,0,0,0,3,0,0,0,0},{0,0,0,0,2,0,1,0,0},{1,0,0,0,1,0,1,0,1},{0,0,0,0,2,1,1,0,0},{0,3,1,0,0,0,0,1,0},{0,0,1,3,0,0,0,1,0}};
	
	//Note: to add a new drink, modify the drinks[] and recipes[][] arrays by adding the new drink's name and recipe at the appropriate place.

	//max stock for any ingredient
	private static final int maxStock = 10;
 
	//inventory array holds the stock available for each ingredient
	private static int[] inventory = new int[ingredients.length];
	
	//unit costs of each ingredient
	private static final double[] unitCosts = {0.90,0.75,0.25,0.75,1.10,0.35,0.35,0.25,1.00};
	
	
	JavaMatic() {
		//initialize all ingredients to full stock
		Arrays.fill(inventory, maxStock);
	} 
	/**
	 * Main method that runs application
	 * @param args
	 */
	public static void main(String[] args) {
		JavaMatic jm = new JavaMatic();
		//scanner to get user input
		Scanner keyboard = new Scanner(System.in);
		//boolean flag used to represent if user wants to quit
		boolean quit = false;
		//string to hold user input
		String command = "";
		do { 
			//Print the inventory
			jm.displayInventory();
			//Print the menu
			jm.displayMenu();
			//read in user input
			command = keyboard.next();
			//if user input is a quit command, update flag
			if(command.equals("Q") || command.equals("q")) {
				quit=true;
			}  
			//if user input is a restock command, restock inventory
			else if(command.equals("R") || command.equals("r")) {
				jm.restockInventory();
			} else {
				//if not quit or restock, process command and display drink if valid drink order.
				jm.processCommand(command);
			}
		} while(!quit);
		keyboard.close();
	} 
	/**
	 * Method to print the inventory and display it to the output console
	 * 
	 */
	private void displayInventory() {
		System.out.println("Inventory:");
		//for each ingredient
		for(int i=0;i<ingredients.length;i++) {
			//print the ingredient name and its inventory
			System.out.println(ingredients[i] + "," + inventory[i]);
		}
		
	}
	/**
	 * Method to print the menu and display it to the output console
	 * 
	 */
	private void displayMenu() {
		System.out.println("Menu:");
		//for each drink
		for(int i=0;i<drinks.length;i++) {
			//calculate its cost
			String cost = getDrinkCost(i);
			//see if ingredients to make drink are in stock
			boolean inStock = isDrinkAvail(i);
			//print drink to output
			System.out.println("" + (i+1) + "," + drinks[i] + "," + cost + "," + inStock );
		}
		
	}
	/**
	 * Restocks the inventory for all ingredients
	 * 
	 */
	private void restockInventory() {
		Arrays.fill(inventory, maxStock);
	}
	/**
	 * Calculates the cost of a drink and returns the output as a formatted string
	 * @param order
	 * @return
	 */
	private String getDrinkCost(int order) {
		//variable to hold price of drink
		float price = 0.0f;
		//get the recipe for this drink
		int[] drinkRecipe = recipes[order];
		//for each ingredient
		for(int i=0;i<ingredients.length;i++) {
			//increase price of drink, by unit Cost of ingredient i * units of ingredient i used by drink
			price += unitCosts[i]*drinkRecipe[i];
		}
		//convert price to string with $ (formatted to two decimal places)
		String dollarprice = "$"+String.format("%.02f", price);
		return dollarprice;
	}
	/**
	 * Processes a user's input command
	 * Uses Version 1 of ValidOrder
	 * @param command
	 */
	private void processCommand(String command) {
		//if command is valid
		if(isValidOrder(command)) {
			//parse the command to an int and subtract 1 to get appropriate index of drink to get name and recipe
			//this will not throw any exceptions because, we have already validated the command.
			int order = Integer.parseInt(command)-1;
			//if drink is out of stock, print out of stock message
			if(!isDrinkAvail(order)) {
				System.out.println("Out of stock: " + drinks[order]);
			} else { //else dispense drink
				dispenseDrink(order);
			}
		}
		//user command is invalid, indicate invalid selection
		else {
			System.out.println("Invalid selection: " + command);
		}
	}
	/**
	 * Checks if a user's input is a valid command
	 * Version 1: uses for-loop to compare input command to valid drink commands
	 * @param command
	 * @return
	 */
	private boolean isValidOrder(String command) {
		//for each drink
		for(int i=1;i<drinks.length+1;i++) {
			//check if user input equals the expected command for this drink, if yes, return true
			if(command.equals(Integer.toString(i))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check if ingredients for a drink are in stock
	 * @param order
	 * @return
	 */
	private boolean isDrinkAvail(int order) {
		//boolean value for drink availability, assume drink can be made
		boolean avail = true;
		//get the recipe for this drink
		int[] drinkRecipe = recipes[order];
		//for each ingredient
		for(int i=0;i<ingredients.length;i++) {
			//compare stock to units needed for drink - if not enough stock, drink cannot be made, update boolean to false
			if(inventory[i] < drinkRecipe[i]) {
				avail = false;
			}
		}
		return avail;
	}
	/**
	 * Dispenses a drink order by deducting inventory stock accordingly and then printing dispensing message
	 * @param order
	 * @return
	 */
	private void dispenseDrink(int order) {
		//get recipe for drink
		int[] drinkRecipe = recipes[order];
		//for each ingredient
		for(int i=0;i<ingredients.length;i++) {
			//deduct its inventory by amount used by drink specified in the order
			inventory[i] -= drinkRecipe[i];
		}
		//print dispensing message
		System.out.println("Dispensing: " + drinks[order]);
	}
	/**
	 * Returns the current inventory - used for testing only
	 * @return
	 */
	public int[] getInventory() {
		return inventory;
	}
	
//	Given below are alternate implementations for processing a user's command (isValidOrder uses a try-catch block)
//	
//	/**
//	 * Processes a user's input command
//	 * Uses Version 2 of ValidOrder
//	 * @param command
//	 */
//	private void processCommand2(String command) {
//		//check if command is valid
//		if(isValidOrder2(command)) {
//			//parse the command to an int and subtract 1 to get appropriate index of drink to get name and recipe
//			int order = Integer.parseInt(command)-1;
//			//if drink is out of stock, print out of stock message
//			if(!isDrinkAvail(order)) {
//				System.out.println("Out of stock: " + drinks[order]);
//			} else { //else dispense drink
//				dispenseDrink(order);
//			}
//		}
//	}
//	/**
//	 * Checks if a user's input is a valid command
//	 * Version 2: parses input to int, if NumberFormatException thrown, print invalid selection. 
//	 * 			  if input is an int, check if int is in range of menu items
//	 * @param command
//	 * @return
//	 */
//	private boolean isValidOrder2(String command) {
//		try {
//			//try to parse command to int
//			int order = Integer.parseInt(command);
//			//if parsed to int, check if invalid order number
//			if(order > drinks.length || order < 1) {
//				System.out.println("Invalid selection: " + command);
//				return false;
//			} else { //order number is valid
//				return true;
//			}
//		} catch(NumberFormatException ne) { //if user command could not be parsed to int, not a valid command
//			System.out.println("Invalid selection: " + command);
//			return false;
//		}
//	}
}
