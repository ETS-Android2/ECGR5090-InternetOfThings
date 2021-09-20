/*NAME: SOMTOCHUKWU CHUKWUDERA ANYAEGBU
 * COURSE: ENGR 5090 Internet Of Things
 * ID:
 * DATE:09-29-2020
 * TOPIC: ASSIGNMENT I--JAVA BASED VENDING MACHINE 
*/


package Assignment1;

import java.util.Scanner;


public class Test {

	private static Scanner input;

	public static void main(String[] args) {
		
		
		//Filling in values using constructor
		VM schoolVM = new VM(10,10,10,20);

		System.out.println("Welcome To The School Vending Machine");
		
		System.out.println("Items in Vending Machine: Coke----25c......Pepsi-----35c......Soda-----45c");

		System.out.println("If You're a Supplier Enter Pin To Reset Inventory In The Vending Machine! \nClick 'a' To Purchase An Item!\n");
		
		input = new Scanner(System.in);
		String supplierChoice = input.nextLine();

		  if(supplierChoice.equals("zxcv")) {
			  schoolVM.reset();
		  }
		  
		  else if(supplierChoice.equals("a")) {
			  schoolVM.acceptCoins();
		  }
	}
}