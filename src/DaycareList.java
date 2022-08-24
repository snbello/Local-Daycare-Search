import java.util.ArrayList;
import java.io.*; 

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
 *
 * GUI Programming Selected Sections Gaddis Download GUI Programming Selected Sections Gaddis
 * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley.
 * Provided under Fair Use (Section 107 of the US Copyright Act)
 *
 * MVC Design Pattern (GeeksforGeeks)
 * retrieved from https://www.geeksforgeeks.org/mvc-design-pattern/ 
 * 
 * How to Use Tables (The Java™ Tutorials > Creating a GUI With Swing > Using Swing Components)
 * retrieved from https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 * 
 * University of Hawaii's A Custom Table Model
 * retrieved from http://www2.hawaii.edu/~takebaya/ics111/jtable_custom/jtable_custom.html
 * 
 * Version/date: December 16 2021
 * 
 * Responsibilities of class:
 * The model part of the program containing the data of my application. Code is heavily influenced by University of Hawaii's 
 * code retrieved from http://www2.hawaii.edu/~takebaya/ics111/jtable_custom/jtable_custom.html
 */

public class DaycareList 
{
   private ArrayList<Daycares> daycareList;
   
	/**
	 * Purpose: A DaycareList constructor creates the daycare arraylist from which the JTable gets its data
	 * @param 
	 */
   public DaycareList() 
   {
      daycareList = new ArrayList<Daycares>();
   }
   
	/**
	 * Purpose: adds an object to the daycare arraylist.
	 * @param the daycares object
	 */
   public void add(Daycares dc) 
   {
      daycareList.add(dc);
   }
   
	/**
	 * Purpose: gets teh daycares arraylist
	 * @return the daycares arraylist
	 */
   public ArrayList<Daycares> getDaycares() 
   {
      return daycareList;
   }
   
	/**
	 * Purpose: reads the file and adds each item to a daycare arraylist
	 * @param the filename
	 */
   public void readFile(String filename) 
   {
      File file = new File(filename);
      FileReader reader = null;
      try {
         reader = new FileReader(file);
      }
      catch (FileNotFoundException e) {
         e.printStackTrace();
         System.exit(1);
      }
      BufferedReader infile = new BufferedReader(reader);
      String line = "";
      try {
         boolean done = false;
         while (!done) {
            line = infile.readLine();
            if (line == null) {
               done = true;
            }
            else {
               String[] tokens = line.trim().split(",");
               String type = tokens[0].trim();
               String name = tokens[1].trim();
               String status = tokens[2].trim();
               String typeACitation = tokens[3].trim();
               String typeBCitation = tokens[4].trim();
               String address = tokens[5].trim();
               String city = tokens[6].trim();
               String zipcode = tokens[7].trim();
 
               Daycares dc = new Daycares(type, name, status, typeACitation, typeBCitation,
            		   					address, city, zipcode);
               daycareList.add(dc);
            }
         }
      }
      catch (IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}