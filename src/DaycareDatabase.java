import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.Formatter;

/**
 * Lead Author(s):
 * @author Shayna Bello
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Professor Tasha Frankie, San Diego Mesa College
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * https://beginnersbook.com/2017/08/java-switch-case/
 * https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
 * https://beginnersbook.com/2017/08/operators-in-java/
 *   
 * Version/date: October 24 2021
 * 
 * Responsibilities of class:
 * The main application for my program. Opens and reads a daycare file.
 * Create a daycare database and a menu for the user to navigate the database.
 */

public class DaycareDatabase
{

	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<Daycares> daycares = new ArrayList<Daycares>();
	    readFile(daycares);
        mainMenu(daycares);
	}
	
	/**
	 * Purpose: Creates a main menu helps the user navigate the daycare database.
	 * @param Daycares Arrayli.list
	 */
	public static void mainMenu(ArrayList<Daycares> daycares)
	{
		System.out.println("Welcome to the San Diego Daycare Search Portal!\n");
		System.out.println("What are you searching for? (choose a corresponding number)\n"
				+ "1) Search for Daycares\n"
				+ "2) View all Daycares (sorted by Name)\n"
				+ "3) Sort Daycares by County\n"
				+ "4) View Favorites List\n"
				+ "0) Exit Program\n");
		
		boolean inputSuccess = false;
		
		do {
		
			try {
				Scanner keyboard = new Scanner (System.in);
				int input = keyboard.nextInt();	
				
				switch (input) {
					case 1: 
						searchDaycares(daycares);
						break;
					case 2: 
						display(daycares);
						break;
					case 3: 
						//sorts the daycares by County instead of the default alphabetically;
						sortDaycares(daycares);
						break;
					case 4: 
						createFavorites(daycares);
						break;
					case 0:
						System.out.println("Exiting program. Goodbye!");
						break;
						default: 
						System.out.println("You need to pick 1, 2, 3, 4 or 0!");
				}//end switch
				inputSuccess = true;
			}//end try
			
			catch (InputMismatchException e) {
				System.out.println("Please enter a number: 0, 1, 2, 3, or 4."); }
			catch (IllegalStateException e) {
				System.out.println("Scanner is closed. Terminating program.");
				System.exit(0); }
		} while (!inputSuccess);
		
	} //end mainMenu method
	
	/**
	 * Purpose: Creates a search menu for the user to search the daycares by name, county, or zipcode.
	 * @param Daycares Arraylist
	 */
	public static void searchDaycares(ArrayList<Daycares> daycares)
	{
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("\nHow would you like to search for daycares by? (choose a corresponding number)\n"
				+ "1) By name\n"
				+ "2) By County\n"
				+ "3) By Zipcode\n"
				+ "4) return to main menu\n"
				+ "0) Exit Program");
		
		// exception handling method based off of Professor Frankie's UniversityDatabaseUI code
		boolean inputSuccess = false;
		
		do {
			try {
				Scanner keyboard = new Scanner (System.in);
				int input = keyboard.nextInt();
				
				switch (input) {
					case 0: 
						System.out.println("Exiting program. Goodbye!");
						System.exit(0);
						break;
					case 1:
						searchByName(daycares);
						break;
					case 2:
						searchByCounty(daycares);
						break;
					case 3:
						searchByZipcode(daycares);
						break;
					case 4: 
						mainMenu(daycares);
					default:
						System.out.println("You need to pick 0, 1, 2, 3, or 4!");
				}//end switch
				inputSuccess = true;
			}//end try
			catch (InputMismatchException e) {
				System.out.println("Please enter a number: 0, 1, 2, 3, or 4."); }
			catch (IllegalStateException e) {
				System.out.println("Scanner is closed. Terminating program.");
				System.exit(0); }
		} while (!inputSuccess);
	} //end method
	
	/**
	 * Purpose: Creates a search menu for the user to search the daycares by name.
	 * @param Daycares Arraylist
	 */
	public static void searchByName(ArrayList<Daycares> daycares)
	{
		boolean inputSuccess = false;
		
		do {
			System.out.println("-------------------------------------------------------------");
			System.out.println("Enter a daycare name or part of the name. \n");
			
			try { 
				Scanner keyboard = new Scanner(System.in);
				String input = keyboard.nextLine();
		
				int count = 0;
				for (Daycares d: daycares)
				{
					if (d.getName().toUpperCase().contains(input.toUpperCase()))
					{
						System.out.println(d);
						System.out.println("---------------------------------------");
						count++;
					}//end if
				} //end for
				
				if (count != 0) {
					System.out.println("\n" + count + " daycares found: \n");
					break; }
				else {	
					System.out.println("No daycares were found.");
					mainMenu(daycares); }
			}//end try
			catch (IllegalStateException e) {
				System.out.println("Scanner is closed. Terminating program.");
				System.exit(0); }
		} while (!inputSuccess);
	}//end search method
	
	/**
	 * Purpose: Creates a search menu for the user to search the daycares by county.
	 * @param Daycares Arraylist
	 */
	public static void searchByCounty(ArrayList<Daycares> daycares)
	{
		boolean inputSuccess = false;
		
		do {
			System.out.println("-------------------------------------------------------------");
			System.out.println("Enter a county in San Diego or enter 0 to return to main menu \n");
			
			try { 
				Scanner keyboard = new Scanner(System.in);
				String input = keyboard.nextLine();
		
				int count = 0;
				for (Daycares d: daycares)
				{
					if (d.getAddressCounty().toUpperCase().contains(input.toUpperCase()))
					{
						System.out.println(d);
						System.out.println("---------------------------------------");
						count++;
					}//end if
				} //end for
				if (input.equals("0"))
					mainMenu(daycares);
				if (count != 0)
					System.out.println("\n" + count + " daycares found: \n");
				else 
					System.out.println("No daycares were found.");	
			}//end try
			catch (IllegalStateException e) {
				System.out.println("Scanner is closed. Terminating program.");
				System.exit(0); }
		} while (!inputSuccess);
	}//end search method
	
	/**
	 * Purpose: Creates a search menu for the user to search the daycares by zipcode.
	 * @param Daycares Arraylist
	 */
	public static void searchByZipcode(ArrayList<Daycares> daycares)
	{
		boolean inputSuccess = false;
		
		do {
			System.out.println("-------------------------------------------------------------");
			System.out.println("Enter a zipcode in San Diego or enter 0 to return to main menu\n");
			
			//Scanner keyboard = new Scanner(System.in);
			
			try { 
				Scanner keyboard = new Scanner(System.in);
				String input = keyboard.nextLine();
		
				int count = 0;
				for (Daycares d: daycares)
				{
					if (d.getAddressZipcode().toUpperCase().contains(input))
					{
						System.out.println(d);
						System.out.println("---------------------------------------");
						count++;
					}//end if
				} //end for
				if (input.equals("0"))
					mainMenu(daycares);
				if (count != 0)
					System.out.println("\n" + count + " daycares found: \n");
				else 	
					System.out.println("No daycares were found.");
			}//end try
			catch (IllegalStateException e) {
				System.out.println("Scanner is closed. Terminating program.");
				System.exit(0); }
		} while (!inputSuccess);
	}//end search method
	
	/**
	 * Purpose: Opens and reads a file of daycares to create a Daycare Arraylist. 
	 * @param Daycares Arraylist
	 */
	public static void readFile(ArrayList<Daycares> daycares)
	{
		//fields of the Daycare arraylist. status is whether daycare is closed, open, active etc.
		String line,  type, name, address, city, state, zipcode, county, status;
	    int typeACitation; //number of type A citations
	    int typeBCitation; //number of type B citations
	      
	    try 
	    {
	    	File infile = new File("sandiegoDaycares.csv");
	    	Scanner filescan = new Scanner(infile);
	        filescan.nextLine(); //remove title
	        
	        while (filescan.hasNext())
	        {
	           line = filescan.nextLine();
	          
	           StringTokenizer st = new StringTokenizer(line, ",");
	           type = st.nextToken();
	           name = st.nextToken();
	           status = st.nextToken();         
	           typeACitation = Integer.parseInt( st.nextToken());
	           typeBCitation = Integer.parseInt( st.nextToken());
	           address = st.nextToken();
	           county = st.nextToken();         
	           state = st.nextToken();
	           zipcode = st.nextToken();
	           city = st.nextToken();         
	           
	           Daycares temp = new Daycares(type, name, status, typeACitation, typeBCitation, 
	                                address, city, zipcode);
	            
	           daycares.add(temp);
	        }//end while
	        filescan.close();
	    }//end try
	    
	    catch (FileNotFoundException e) {
	    	System.out.println(e.getMessage()); }
	}//end readFile method

	/**
	 * Purpose: Displays the list of daycares.
	 * @param Daycares Arraylist
	 */
	public static void display(ArrayList<Daycares> daycares)
	{
		for (int i=0; i< daycares.size(); i++)
	    {
			int count = i +1; 
			System.out.println(count + ") -----------------------------------");
	        System.out.println(daycares.get(i));
	    }
	}
	
	/**
	 * Purpose: Allows the user to choose their top 3 daycares and displays the chosen top 3. 
	 * @param Daycares Arraylist
	 */
	public static void createFavorites(ArrayList<Daycares> daycares)
	{
		int favorite1;
		int favorite2;
		int favorite3;
		Scanner keyboard = new Scanner(System.in);
		try { 
			System.out.println("Choose your top 3 daycares by number");
			System.out.println("Enter your number 1 favorite");
			favorite1 = keyboard.nextInt();
			System.out.println("Enter your number 2 favorite");
			favorite2 = keyboard.nextInt();
			System.out.println("Enter your number 3 favorite");
			favorite3 = keyboard.nextInt();
		
			System.out.println("\n-------------------------------------");
			System.out.println("Your top 3 daycares");
			System.out.println(daycares.get(favorite1-1));
			System.out.println(daycares.get(favorite2-1));
			System.out.println(daycares.get(favorite3-1));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Must only answer the available options 1 - 21"); }
		catch (IllegalStateException e) {
			System.out.println("Scanner is closed. Terminating.");
			System.exit(0); }
		finally {
			keyboard.close(); }
	}
		
	/**
	 * Purpose: Sorts the Daycares arraylist by county. 
	 * @param Daycares Arraylist
	 */
 	public static void sortDaycares(ArrayList<Daycares> sortedDaycares)
    {
        Collections.sort(sortedDaycares);
        
        //display all of the arraylist if the arraylist size is less than 100, else display just the first 100
        for (int i = 0; i < (sortedDaycares.size() <= 100 ? sortedDaycares.size(): 100); i++)
        	System.out.println(sortedDaycares.get(i));
    }
}
























