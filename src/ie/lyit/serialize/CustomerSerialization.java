/**
 * Dean Comiskey L00097028 
 * Software Implementation
 * Description: CustomerSerialization contains the ArrayList of Customers
 * as well as all the methods writing to a file
 * Date: 6/11/2017
**/

package ie.lyit.serialize;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.lyit.hotel.Customer;

import java.io.*;
import java.util.*;

// CustomerSerialization contains the ArrayList of Customers
// as well as all the methods for the GUI options on the JOptionPane.
// It implements Serializable as does all of the classes that is used 
// when writing data to the FILENAME customers.ser
public class CustomerSerialization implements CustomerSerializationDao{


	// Constant FILENAME for the file to be created
	final String FILENAME = "customers.ser";

	// Declare ArrayList called customers - for storing a list of customers
	private ArrayList<Customer> customers;
	
	private static int viewPane;

	// Default Constructor
	public CustomerSerialization(){
		// Construct customers ArrayList
		customers = new ArrayList<Customer>();
	}

	//////////////////////////////////////////////////////////
	// Method Name : add()							    	//
	// Return Type : void							    	//
	// Parameters : None							     	//
	// Purpose : Reads one Customer record from the user    //
	//           and adds it to the ArrayList customers     //
	//////////////////////////////////////////////////////////	
	public void add(){
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();	
		// And add it to the customers ArrayList
		customers.add(customer);
	}

	////////////////////////////////////////////////////////////
	// Method Name : list()							          //
	// Return Type : void			  				          //
	// Parameters : None						 	          //
	// Purpose : Lists all Customer records in the ArrayList  //
	////////////////////////////////////////////////////////////	
	public void list(){
		// for every Customer object in customers
      for(Customer tmpCustomer:customers)
      {
			// display it
			System.out.println(tmpCustomer);
      }
	}
	
	////////////////////////////////////////////////////////////////
	// Method Name : view()									      //
	// Return Type : void								          //
	// Parameters : None								          //
	// Purpose : Displays the required Customer record on screen  //
	//         : And returns it, or null if not found             //   
	////////////////////////////////////////////////////////////////	
	@SuppressWarnings("resource")
	public Customer view(){
		Scanner keyboard = new Scanner(System.in);		

		// Read the number of the customer to be viewed from the user
		System.out.println("ENTER CUSTOMER NUMBER: ");
		int customerToView=keyboard.nextInt();
		
		// for every Customer object in customers
	    for(Customer tmpCustomer:customers){
		   // if it's number equals the number of the customerToView
		   if(tmpCustomer.getCustomerNumber() == customerToView){
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    // if we reach this code the Customer was not found so return null
	    return null;
	}
		
	
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()								         //
	// Return Type : void									         //
	// Parameters : None									         //
	// Purpose : Deletes the required Customer record from customers //
	///////////////////////////////////////////////////////////////////	
	public void delete(){	
		// Call view() to find, display, & return the Customer to delete
		Customer tmpCustomer = view();
		// If the book != null, i.e. it was found then...
	    if(tmpCustomer != null)
		   // ...remove it from customers
	    	customers.remove(tmpCustomer);
	}
	
	////////////////////////////////////////////////////////////////
	// Method Name : edit()			  					          //
	// Return Type : void								       	  //
	// Parameters : None									      //
	// Purpose : Edits the required Customer record in customers  //
	////////////////////////////////////////////////////////////////	
	public void edit(){	
		// Call view() to find, display, & return the Customer to edit
		Customer tmpCustomer = view();
		// If the Customer != null, i.e. it was found then...
	    if(tmpCustomer != null){
		   // get it's index
		   int index=customers.indexOf(tmpCustomer);
		   // read in a new Customer and...
		   tmpCustomer.read();
		   // reset the object in customers
		   customers.set(index, tmpCustomer);
	    }
	}
	
	//////////////////////////////////////////////////////////
	// Method Name : setNextNumberInCustomer()    		    //
	// Return Type : void								    //
	// Parameters : None								    //
	// Purpose : Sets the customer number, when the program //
	// is started to the last customer in the file and tells//
	// the next customer number to + 1						//
	//////////////////////////////////////////////////////////	
	public void setNextNumberInCustomer() {
		if (customers.size() > 0) {
			Customer lastCustomer = customers.get(customers.size()-1);
			Customer.setNextNumber(lastCustomer.getCustomerNumber() + 1);
		}
	}
	
	//////////////////////////////////////////////////////////
	// Method Name : writeToFile()    			  		    //
	// Return Type : void								    //
	// Parameters : None								    //
	// Purpose : Writes the ArrayList customers to the      //
	//		     File customers before closing the File     //
	//////////////////////////////////////////////////////////	
	public void writeToFile(){
		try{
			// Write to the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
	
			os.writeObject(customers);
	
			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to customers.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	///////////////////////////////////////////////////////
	// Method Name : readFile()    			             //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads the ArrayList from the File back  //
	//		     into customers before closing the File  //
	///////////////////////////////////////////////////////	
	@SuppressWarnings("unchecked")
	public void readFile(){
		try{
			// serialize the ArrayList...
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream is = new ObjectInputStream(fis);
		
			customers = (ArrayList<Customer>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find customers file.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}				
	}	

}