/*NAME: SOMTOCHUKWU CHUKWUDERA ANYAEGBU
 * COURSE: ENGR 5090 Internet Of Things
 * ID:
 * DATE:09-29-2020
 * TOPIC: ASSIGNMENT I--JAVA BASED VENDING MACHINE 
*/
package Assignment1;

import java.util.Scanner;

//User defined exceptions
class MyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String s){
		// Call constructor of parent Exception
		super(s);
		}
	}

class NotFullPaidException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFullPaidException(String s){
		// Call constructor of parent Exception
		super(s);
		}
	}

class NotSufficientChangeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotSufficientChangeException(String s){
		// Call constructor of parent Exception
		super(s);
		}
	}

class SoldOutException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SoldOutException(String s){
		// Call constructor of parent Exception
		super(s);
		}
	}


public class VM {
	int coinsInMachine;
	int cokeAmount, pepsiAmount, sodaAmount;
	int changeInMachine; 
	int coinsTotal = 0;
	private Scanner input;
	private Scanner input2;
	
	public VM(int ca, int pa, int sa, int c){
		cokeAmount = ca;
		pepsiAmount = pa;
		sodaAmount = sa;
		changeInMachine = c;
		}
	
	public void acceptCoins() {
		input = new Scanner(System.in);
				
		System.out.println("Please Enter Coins and Press 'q' To Continue\nThis VM Only Accepts Pennys, Nickels, Dimes and Quarters.");
				
		//Holds the amount of coins a user enters
		
		String coins = "0";
		
		//Keep accepting coins until the user enters q
		while(coins != "q") {
			coins = input.nextLine();
			
			try {
				//Throw an exception of the wrong amount of coins is entered
				if(!(coins.equals("1"))&&!(coins.equals("5"))&&!(coins.equals("10"))&&!(coins.equals("25"))&&!(coins.equals("q"))) {
					//Throw an object of user defined exception
					throw new MyException("Invalid Input!\nThis Vending Machine Only Accepts Denominations of 1(Penny), 5(Nickel), 10(Dime) and 25cents(Quarter).");
					}
				}
			
			catch (MyException ex) {
				
				//Print the message from MyException object
				System.out.println(ex.getMessage());
				continue;
				}
			
			//If the user has chosen to stop entering coins
			if(coins.equals("q")) {
				
				System.out.println("You Have Stopped Entering Coins.");
				System.out.println("You Have " + coinsTotal + " cents In The Machine.");
				
				break;
				}
			
			else {
				
				//Calculating the total coins a user has entered
				coinsTotal += Integer.parseInt(coins);
				System.out.println("You Have " + coinsTotal + " cents In The Machine. Press 'q' to continue transaction.");
				coinsInMachine = coinsTotal;
				}
			}
		
		
		//Call the method to select products after putting in coins
		selectProducts(coinsInMachine);
		
		}
	
	public void selectProducts(int coinsInMachine) {
		System.out.println("Press 'c' For Coke, 'p' For Pepsi or 's' For Soda.");
		
		String choice = "";
		int change = 0;
		input2 = new Scanner(System.in);
		
		choice = input2.nextLine();
		
		//Choose c for coke
		if(choice.equals("c")) {
			try{
				//If the full amount isn't entered
				if(coinsInMachine < 25) {
					throw new NotFullPaidException("You Have Not Entered The Full Amount of 25cents.");
					}
				}
			
			catch (NotFullPaidException ex) {
				System.out.println(ex.getMessage());
				
				// if the full amount isn't entered the user can either cancel the transaction or continue
				System.out.println(" Enter 'r' To Get a Refund or 'c' To Continue.");
				String s = input2.nextLine();
				
				//if the user chooses to cancel
				if(s.equals("r")) {
					System.out.println(" You Have Been Refunded " + coinsInMachine + "cents.");
					}
				
				//if the user chooses to continue
				else if(s.equals("c")) {
					acceptCoins();
					}
				}
			
			//if the amount the user entered in the full amount or more, need to make the order
			if(coinsInMachine >=25) {
				change = coinsInMachine - 25;
				
				try {
					
					//if the amount of change in the machine isn't enough to complete the order
					if(changeInMachine < change) {
						throw new NotSufficientChangeException("There Isn't Enough Change To Complete Purchase.");
						
						}
					}
				
				catch (NotSufficientChangeException ex) {
					
					// Print the message from MyException object
					System.out.println(ex.getMessage());
					
					}
				
				
				if(changeInMachine >= change) {
					
					try	{
						
						//if the amount of product in stock isn't available
						if(cokeAmount <= 0) {
							throw new SoldOutException("The Selected Item Is Out of Stock.");
							}
						}
					
			        catch (SoldOutException ex) {
			        	
			        	//Print the message from MyException object
			        	System.out.println(ex.getMessage());
			        	}
					
					
					if(cokeAmount > 0) {
						
						//If the product is available, reduce it in stock count and perform the transaction
						//cokeAmount--;
						System.out.println("Your Change Is " + change + " cents.");
						
						System.out.println("If You Want To Proceed With Selection Press 'o'; Press 'r' If You Would Like To Return Item");
						String s = input2.nextLine();
						if(s.equals("r")) {
							
							System.out.println("Item Returned!");
							//cokeAmount++;
							System.out.println("You Have Been Refunded Your Full Amount of " + coinsInMachine + " cents");
							}
						
						else if(s.equals("o")) {
							System.out.println("Enjoy Your Purchased Item and Don't Forget To Collect Your Change of " + change + " cents");
							changeInMachine -= change;
							cokeAmount--;
							
							}
						}
					}
				}
			}
		
		else if(choice.equals("p")) {
			try{
				//If the full amount isn't entered
				if(coinsInMachine < 35) {
					throw new NotFullPaidException("You Have Not Entered The Full Amount of 35cents");
					}
				}
			
			catch (NotFullPaidException ex) {
				System.out.println(ex.getMessage());
				
				// if the full amount isn't entered the user can either cancel the transaction or continue
				System.out.println("Enter 'r' To Get a Refund or 'c' To Continue ");
				String s = input2.nextLine();
				
				//if the user chooses to cancel
				if(s.equals("r")) {
					System.out.println("You Have Been Refunded " + coinsInMachine + "cents");
					}
				
				//if the user chooses to continue
				else if(s.equals("c")) {
					acceptCoins();
					}
				}
			
			//if the amount the user entered in the full amount or more, need to make the order
			if(coinsInMachine >= 35) {
				change = coinsInMachine - 35;
				
				try {
					
					//if the amount of change in the machine isn't enough to complete the order
					if(changeInMachine < change) {
						throw new NotSufficientChangeException("There Isn't Enough Change To Complete Purchase!");
						
						}
					}
				
				catch (NotSufficientChangeException ex) {
					
					// Print the message from MyException object
					System.out.println(ex.getMessage());
					
					}
				
				
				if(changeInMachine >= change) {
					
					try	{
						
						//if the amount of product in stock isn't available
						if(pepsiAmount <= 0) {
							throw new SoldOutException("The Selected Item Is Out of Stock!");
							}
						}
					
			        catch (SoldOutException ex) {
			        	
			        	//Print the message from MyException object
			        	System.out.println(ex.getMessage());
			        	}
					
					
					if(pepsiAmount > 0) {
						
						//If the product is available, reduce it in stock count and perform the transaction
						//pepsiAmount--;
						System.out.println("Your Change Is " + change + " cents");
						
						System.out.println("If You Want To Proceed With Selection Press 'o'; Press 'r' If You Would Like To Return Item.");
						String s = input2.nextLine();
						if(s.equals("r")) {
							
							System.out.println("Item Returned!");
							//pepsiAmount++;
							System.out.println("You Have Been Refunded Your Full Amount of " + coinsInMachine + " cents.");
							}
						
						else if(s.equals("o")) {
							System.out.println("Enjoy Your Purchased Item and Don't Forget To Collect Your Change of " + change + " cents.");
							changeInMachine -= change;
							pepsiAmount--;
							
							}
						}
					}
				}
			}
		
		else if(choice.equals("s")) {
			try{
				//If the full amount isn't entered
				if(coinsInMachine < 45) {
					throw new NotFullPaidException("You Have Not Entered The Full Amount of 45cents.");
					}
				}
			
			catch (NotFullPaidException ex) {
				System.out.println(ex.getMessage());
				
				// if the full amount isn't entered the user can either cancel the transaction or continue
				System.out.println("Enter 'r' To Get A Refund or 'c' To Continue.");
				String s = input2.nextLine();
				
				//if the user chooses to cancel
				if(s.equals("r")) {
					System.out.println("You Have Been Refunded " + coinsInMachine + "cents.");
					}
				
				//if the user chooses to continue
				else if(s.equals("c")) {
					acceptCoins();
					}
				}
			
			//if the amount the user entered in the full amount or more, need to make the order
			if(coinsInMachine >= 45) {
				change = coinsInMachine - 45;
				
				try {
					
					//if the amount of change in the machine isn't enough to complete the order
					if(changeInMachine < change) {
						throw new NotSufficientChangeException("There Isn't Enough Change To Complete Purchase!");
						
						}
					}
				
				catch (NotSufficientChangeException ex) {
					
					// Print the message from MyException object
					System.out.println(ex.getMessage());
					
					}
				
				
				if(changeInMachine >= change) {
					
					try	{
						
						//if the amount of product in stock isn't available
						if(sodaAmount <= 0) {
							throw new SoldOutException("The Selected Item Is Out of Stock.");
							}
						}
					
			        catch (SoldOutException ex) {
			        	
			        	//Print the message from MyException object
			        	System.out.println(ex.getMessage());
			        	}
					
					
					if(sodaAmount > 0) {
						
						//If the product is available, reduce it in stock count and perform the transaction
						//sodaAmount--;
						System.out.println("Your Change Is " + change + " cents");
						
						System.out.println("If You Want To Proceed With Selection Press 'o'; Press 'r' If You Would Like To Return Item.");
						String s = input2.nextLine();
						if(s.equals("r")) {
							
							System.out.println("Item Returned!");
							//sodaAmount++;
							System.out.println("You Have Been Refunded Your Full Amount of " + coinsInMachine + " cents!");
							}
						
						else if(s.equals("o")) {
							System.out.println("Enjoy Your Purchased Item and Don't Forget To Collect Your Change of " + change + " cents!");
							changeInMachine -= change;
							sodaAmount--;
							
							}
						}
					}
				}
			}
		else {
			System.out.println("Invalid Item Selection! Please Press Right Key.");
		}		
	}
	
		
	public void reset() {
		cokeAmount = 10;
		pepsiAmount = 10;
		sodaAmount = 10;
		changeInMachine = 20;
		
		System.out.println("The Vending Machine's Inventory Has Been Restocked \n coke : " + cokeAmount + "\n Pepsi : " + pepsiAmount+ "\n Soda : " + sodaAmount+ "\n change : "+ changeInMachine);
		}
	}