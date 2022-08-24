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
 * Version/date: December 16 2021
 *
 * Responsibilities of class:
 * Daycares holds information for San Diego daycares.
 */

public class Daycares implements Comparable <Daycares>
{
	   private String type;
	   private String name;
	   private String status; //whether the daycare is open, closed, inactive, pending
	   private String typeACitation; //citations due some immediate risk created
	   private String typeBCitation; //citations due to some potential risk created
	   private Address address;
	   private String mailAddress;
	   private String city;
	   private String zipcode;
      
		/**
		 * Purpose: An overloaded constructor with 10 parameters. 
		 * @param type, name, status, typeACitation, typeBCitation, mailAddress, county, state, zipcode, city
		 */
	   public Daycares(String type, String name, String status, String typeACitation, 
	                  String typeBCitation, String mailAddress, String city,
	                  String zipcode)
	   {
	      this.type = type.trim();
	      this.name = name.trim();
	      this.status = status.trim();
	      this.typeACitation = typeACitation.trim();
	      this.typeBCitation = typeBCitation.trim();
	      this.address = new Address(mailAddress.trim(), city.trim(), zipcode);
	   }
	   
		/**
		 * Purpose: Gets the type of the daycare.
		 * @return returns the type.
		 */
	   public String getType()
	   {
		   return type;
	   }
	   
		/**
		 * Purpose: Gets the name of the daycare.
		 * @return returns the name.
		 */
	   public String getName()
	   {
		   return name;
	   }
	   
		/**
		 * Purpose: Gets the status of the daycare.
		 * @return returns the status.
		 */
	   public String getStatus()
	   {
		   return status;
	   }
	   
		/**
		 * Purpose: Gets the address of the daycare.
		 * @return returns a copy of the Address object.
		 */
	   public Address getAddress()
	   {
		   Address copy = new Address(address);
		   return copy;
	   }
	   
	   public String getMailAddress()
	   {
		   return address.getMailAddress();
	   }
	   
		/**
		 * Purpose: Gets the zipcode of the daycare.
		 * @return returns the zipcode.
		 */
	   public String getAddressZipcode()
	   {
		   return address.getZipcode();
	   }
	   
		/**
		 * Purpose: Gets the county of the daycare.
		 * @return returns the county.
		 */
	   public String getAddressCity()
	   {
		   return address.getCity();
	   }
	   
		/**
		 * Purpose: Gets the type A citation.
		 * @return returns the  citation amount.
		 */
	   public String getTypeA()
	   {
		   return typeACitation;
	   }
	   
		/**
		 * Purpose: Gets the type B citation.
		 * @return returns the citation amount
		 */
	   public String getTypeB()
	   {
		   return typeBCitation;
	   }

		/**
		 * Purpose: Appends the data of the daycares into a string format.
		 * @return returns the string.
		 */
	   public String toString()
	   {
	      StringBuilder sb = new StringBuilder();
	      sb.append (name + ": \n\t\t" + type + ": " + status + " (Citations: " 
	    		  	+ getTypeA() + " and " + getTypeB() + ")" + "\n\t\t" + address + "\n");	    
	      return sb.toString();
	   }
	   
		/**
		 * Purpose: Compares the county of the Daycares object  in order to sort the daycares by order.
		 * @param A Daycares object that is being compared.
		 * @return returns a negative if less than, 0 if equal, positve if greater than the other Daycares object.   
		 */
	   @Override
	   public int compareTo(Daycares otherDaycares)
	   {
		   //sorts by county
		   return this.getAddressCity().compareTo(otherDaycares.getAddressCity());
	   }

}
