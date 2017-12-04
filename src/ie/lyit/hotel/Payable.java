/**
 * Dean Comiskey L00097028
 * Software Implementation
 * Description: Models an interface Payable
 * Date: 16/10/2017
**/


package ie.lyit.hotel;

public interface Payable {
	public abstract double calculateWage(double taxPercentage);
	// Don't have to put in public abstract
	double incrementSalary(double incrementAmount);
}

// A Java interface can contain only abstract 
// methods, i.e. methods without a body