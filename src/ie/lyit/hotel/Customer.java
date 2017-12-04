/**
 * Dean Comiskey L00097028 
 * Software Implementation
 * Description: Models a Customer, inherits from Person
 * Date: 25/09/2017
**/


package ie.lyit.hotel;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Customer extends Person implements Serializable{ 

	// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private int customerNumber;			    // AND number

	private static int nextNumber = 1;// static for unique number - starts off at 1
	
	
	public static void setNextNumber(int nextNumber) {
		Customer.nextNumber = nextNumber;
	}
	// Default Constructor
	// Called when object is created like this ==> 
	//   Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		customerNumber= nextNumber++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	// Customer cObj = new Customer("Mr","Joe","Doe","12 Hi Rd,Letterkenny",
	//                              "0871234567","joe@hotmail.com");
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialize Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		customerNumber=nextNumber++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return super.toString() + "," + emailAddress + "," + customerNumber;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.customerNumber==cObject.customerNumber);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress(){
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getCustomerNumber(){
		return customerNumber;
	}	
	
	// read() - To read a customer from the user	
	   public void read(){
	      JTextField txtCustomerNo = new JTextField();
	      txtCustomerNo.setText("" + this.getCustomerNumber());      
	      JTextField txtTitle = new JTextField();
	      JTextField txtFirst = new JTextField();
	      JTextField txtLast = new JTextField();
	      JTextField txtAddress = new JTextField();
	      JTextField txtEmail = new JTextField();
	      JTextField txtPhoneNumber = new JTextField();

	      Object[] message = {
              "Title", txtTitle,
              "First", txtFirst,
              "Last", txtLast,
              "Address", txtAddress,
	          "Email Address:", txtEmail,
	          "Phone Number:", txtPhoneNumber,
	      };

	      int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION){
	          this.name = new Name(txtTitle.getText(), txtFirst.getText(), txtLast.getText()); 
	          this.address = txtAddress.getText();
	          this.emailAddress = txtEmail.getText();
	          this.phoneNumber = txtPhoneNumber.getText();
	      }   
		}

	
}
