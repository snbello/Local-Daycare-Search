
public class DaycareTest
{

	public static void main(String[] args)
	{
	      Daycares daycare1 = new Daycares();
	      Daycares daycare2 = new Daycares("Infant", "ABC Daycare", "Open", 0, 0, "An address", "San Diego",
	                        "CA", "zipcode", "San Diego");
	      Daycares daycare3 = daycare2;
	      Daycares daycare4 = new Daycares(daycare2);
	      //System.out.println(daycare1 + "\n----------");
	      //System.out.println(daycare2 + "\n----------");
	      //System.out.println(daycare3 + "\n----------"); //shallow copy
	      System.out.println(daycare4 + "\n----------"); //deep copy

	}

}
