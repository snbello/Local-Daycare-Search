import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

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
 * Version/date: December 16 2021
 * 
 * Responsibilities of class:
 * The controller part of my program that listens to the events triggered by the viewer. 
 */

public class DaycareController implements ActionListener, DocumentListener
{

	private DaycareView view;

	/**
	 * Purpose: A DaycareController constructor
	 * @param DaycareView
	 */
	public DaycareController(DaycareView view) 
	{
		this.view = view;
	}

	/**
	 * Purpose: uses the actionlisteners actionperformed method which handles the actions of the components
	 * @param the actionevent
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{

		//get different button actions using switch statements
		int action = Integer.parseInt(e.getActionCommand());
		switch (action) {
			case 1: 
				JOptionPane.showMessageDialog(null, "Enter text to search by Daycare Name");

				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Enter text to search by cities");

				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Enter text to search by zipcodes");

				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Enter text to search by Daycare status (CLOSED, OPEN, PENDING)");

			default:
				break;
		}

	}
	/**
	 * Purpose: handles updating a change in the JTextfield
	 * @param documentevent
	 */
	//@Override
	public void changedUpdate (DocumentEvent e)
	{
		view.newFilter();
	}

	/**
	 * Purpose: handles updating an insertion in the JTextfield
	 * @param documentevent
	 */
	//@Override
	public void insertUpdate (DocumentEvent e)
	{
		view.newFilter();
	}

	/**
	 * Purpose: handles updating a removal in the JTextfield
	 * @param documentevent
	 */
	// @Override
	public void removeUpdate (DocumentEvent e)
	{
		view.newFilter();
	}

}
