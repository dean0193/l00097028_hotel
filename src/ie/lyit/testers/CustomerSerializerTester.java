/**
 * Dean Comiskey L00097028 
 * Software Implementation
 * Description: Tester for CustomerSerialization
 * Date: 6/11/2017
**/
package ie.lyit.testers;


import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.lyit.serialize.CustomerSerialization;
import ie.lyit.serialize.CustomerSerializationDao;

public class CustomerSerializerTester {

	private static int view;
	private static int option;
	// Declare a new CustomerSerialization object
	private static CustomerSerializationDao customerSerializer;
	
	public static void main(String[] args) {
		//customerSerializer =  new CustomerSerialization();
		customerSerializer = new CustomerSerialization();
		// Add two records to the ArrayList
		//customerSerializer.add();

		// Read the ArrayList from the File
		customerSerializer.readFile();

		// Set the next Customer number to the last
		// in the file + 1.
		customerSerializer.setNextNumberInCustomer();

		// mainMenu() contains a loop of JOptionPanel 
		mainMenu();

		// Write the ArrayList to File
		customerSerializer.writeToFile();
		
		
	}
	
					
   public int getOption(){
	   return option;
   }
   public static void mainMenu(){
	   //Set up a boolean to close the loop of the JOptionPane 
	   boolean close = false;
	   //The program continues to loop until the User closes it.
	   do {
		   
		   //Create a JTextfeild "request" for the user to control the system.
		   JTextField request = new JTextField();
		   JTextField viewWho = new JTextField();
	      
	
	       Object[] message = {
	    	  //Here we display dialog positions on the JOptionPane   
    		  "1: Add", "2: List", "3: View", "4: Edit", "5: Delete",
	    	  "Enter number", request
	          
	       }; 
	       
	       Object[] viewMessage = {
     		  //Here we display dialog positions on the JOptionPane   
 	    	  "Enter number", viewWho
	 	          
 	       }; 
	       
	       /*Object[] editMessage = {
	      		  //Here we display dialog positions on the JOptionPane   
	  	    	  "Enter number", request
	 	 	          
	  	       };*/ 
	       
	       // Builds a JOptionPane with propose dialog, title and OK button
	       // we could also use an action listener and create a button
	       option = JOptionPane.showConfirmDialog(null, message,
	    		   "Customer File Handler", JOptionPane.OK_CANCEL_OPTION);
	       
	       //To input the request the User chooses  
	       if (option == JOptionPane.OK_OPTION){
	    	   // 1 adds a new customer
	    	   if (request.getText().equals("1")) {
	    		   customerSerializer.add();
	    	   }
	    	   // 2 list's file of customer
	    	   if (request.getText().equals("2")) {
	    		   customerSerializer.list();
	    	   }
	    	   // 3 views a customer by Customer Number
	    	   if (request.getText().equals("3")) {
	    		   customerSerializer.view();
	    	   }
	    	   // 4 edits a customers details and stores to file
	    	   if (request.getText().equals("4")) {
	    		   customerSerializer.edit();
	    	   }
	    	   // 5 deletes the customer from the file
	    	   if (request.getText().equals("5")) {
	    		   customerSerializer.delete();
	    	   }
	       }  
	       else
	    	   //Keeps the GUI open 
	    	   close = true;
	   }
	   while(!close);
    }
}