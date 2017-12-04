package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

public interface CustomerSerializationDao{

	//////////////////////////////////////////////////////////
	// Method Name : add()							    	//
	// Return Type : void							    	//
	// Parameters : None							     	//
	// Purpose : Reads one Customer record from the user    //
	//           and adds it to the ArrayList customers     //
	//////////////////////////////////////////////////////////	
	public abstract void add();

	////////////////////////////////////////////////////////////
	// Method Name : list()							          //
	// Return Type : void			  				          //
	// Parameters : None						 	          //
	// Purpose : Lists all Customer records in the ArrayList  //
	////////////////////////////////////////////////////////////	
	public abstract void list();

	////////////////////////////////////////////////////////////////
	// Method Name : view()									      //
	// Return Type : void								          //
	// Parameters : None								          //
	// Purpose : Displays the required Customer record on screen  //
	//         : And returns it, or null if not found             //   
	////////////////////////////////////////////////////////////////	
	public abstract Customer view();

	///////////////////////////////////////////////////////////////////
	// Method Name : delete()								         //
	// Return Type : void									         //
	// Parameters : None									         //
	// Purpose : Deletes the required Customer record from customers //
	///////////////////////////////////////////////////////////////////	
	public abstract void delete();

	////////////////////////////////////////////////////////////////
	// Method Name : edit()			  					          //
	// Return Type : void								       	  //
	// Parameters : None									      //
	// Purpose : Edits the required Customer record in customers  //
	////////////////////////////////////////////////////////////////	
	public abstract void edit();

	//////////////////////////////////////////////////////////
	// Method Name : setNextNumberInCustomer()    		    //
	// Return Type : void								    //
	// Parameters : None								    //
	// Purpose : Sets the customer number, when the program //
	// is started to the last customer in the file and tells//
	// the next customer number to + 1						//
	//////////////////////////////////////////////////////////	
	public abstract void setNextNumberInCustomer();

	//////////////////////////////////////////////////////////
	// Method Name : writeToFile()    			  		    //
	// Return Type : void								    //
	// Parameters : None								    //
	// Purpose : Writes the ArrayList customers to the      //
	//		     File customers before closing the File     //
	//////////////////////////////////////////////////////////	
	public abstract void writeToFile();

	///////////////////////////////////////////////////////
	// Method Name : readFile()    			             //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads the ArrayList from the File back  //
	//		     into customers before closing the File  //
	///////////////////////////////////////////////////////	
	public abstract void readFile();

}