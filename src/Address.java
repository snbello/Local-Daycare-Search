/**
 * Lead Author(s):
 * @author Shayna Bello
 * 
 * References:
 * Professor Tasha Frankie, San Diego Mesa College
 * 
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *  
 * Version/date: October 24 2021
 *
 * Responsibilities of class:
 * Daycares holds information for San Diego daycares.
 */

public class Address //implements Comparable <Address>
{
	   private String address;
	   //private String county;
	   //private String state;
	   private String zipcode;
	   private String city;
	  
		/**
		 * Purpose: A default Address constructor
		 * @param 
		 */
	   public Address()
	   {
	      address = "";
	      //county = "";
	      //state = "";
	      zipcode = "";
	      city = "";
	   }
	   
		/**
		 * Purpose: An overloaded constructor with 5 parameters. 
		 * @param address, county, state, zipcode, city.
		 */
	   public Address(String address, String city,
	                  String zipcode)
	   {
	      this.address = address;
	      //this.county = county;
	      //this.state = state;
	      this.zipcode = zipcode;
	      this.city = city;
	   }
	   
		/**
		 * Purpose: A copy constructor
		 * @param copy of the Address object
		 */
	   public Address(Address copy)
	   {
	      this.address = copy.address;
	      //this.county = copy.county;
	      //this.state = copy.state;
	      this.zipcode = copy.zipcode;
	      this.city = copy.city;
	   }
	   
	   public String getMailAddress()
	   {
		   return address;
	   }
		/**
		 * Purpose: Gets the zipcode of the address.
		 * @return returns the zipcode.
		 */
	   public String getZipcode()
	   {
		   return zipcode;
	   }
	   
		/**
		 * Purpose: Gets the county of the address.
		 * @return returns the county.
		 */ 
	   public String getCity()
	   {
		   return city;
	   }
	   
		/**
		 * Purpose: Appends the data of the address into a string format.
		 * @return returns the string.
		 */
	   public String toString()
	   {
	      StringBuilder sb = new StringBuilder();
	      sb.append ( 
	                  "Address: " + address + ", " + 
	                  city + ", " + 
	                  zipcode);
	 
	      return sb.toString();
	   }
	    
}

