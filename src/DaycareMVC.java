import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
 * https://www.geeksforgeeks.org/mvc-design-pattern/  
 * 
 * Version/date: December 16 2021
 * 
 * Responsibilities of class:
 * The main application for my program. 
 */
public class DaycareMVC extends JFrame 
{

	public static void main(String[] args) 
	{

		DaycareView view = new DaycareView();
		DaycareController controller = new DaycareController(view);

		// register controller as the listener
		view.registerListener(controller);


		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 300);
		view.setVisible(true);
		System.out.println("End of main");

	}
}
