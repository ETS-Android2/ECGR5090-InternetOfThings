package ShowBikes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class TestMyBicycles {
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		TestMyBicycles one = new TestMyBicycles();
		
		System.out.println("Welcome to Bicycle DB!\n Press q to query database\n       i to insert new row\n       d to delete row\n");
		
		String userChoice = new Scanner(System.in).nextLine();

		  if(userChoice.equals("q")) {
			  one.queryDB();
		  }
		  else if(userChoice.equals("i")) {
			  one.insertRow();
		  }
		  else if(userChoice.equals("d")){
			  one.deleteRow();
		  }
		
	}
	
	void queryDB(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
			System.out.println("Successful");
			
			Statement myStmt = myConn.createStatement();
			
			System.out.println("To view full table press'f' \nTo sort table press 's'");
			Scanner input = new Scanner(System.in);
			String viewChoice = input.nextLine();

			  if(viewChoice.equals("f")) {
				  ResultSet myRs = myStmt.executeQuery("SELECT * FROM attributes");
				  while (myRs.next()) {
					  System.out.println("\n\nBicycle Type: " + myRs.getString("type") + " - Number of Gears: " + myRs.getString("gear") + " - Wheel Base: "+myRs.getString("wheel_base") +  " - Height: " + myRs.getString("height") +  " - Color: " + myRs.getString("color") + " - Material: " + myRs.getString("material") );
				  }
			  }
			  
			  else if(viewChoice.equals("s")) {
				  ResultSet myRs = myStmt.executeQuery("SELECT * FROM attributes where gear=5");
				  while (myRs.next()) {
					  System.out.println("\n\nBicycle Type: " + myRs.getString("type") + " - Number of Gears: " + myRs.getString("gear") + " - Wheel Base: "+myRs.getString("wheel_base") +  " - Height: " + myRs.getString("height") +  " - Color: " + myRs.getString("color") + " - Material: " + myRs.getString("material") );
					  
					  }
			  }
			  else{
				System.out.println("Invalid input");
				
			  }
			
			
			  }catch (Exception exc) {
					exc.printStackTrace();
		}
		
	}
	
	void insertRow(){
		System.out.println("Enter Bike Type: \n");
		String type = new Scanner(System.in).nextLine();
		
		System.out.println("Enter Gear: \n");
		String gear = new Scanner(System.in).nextLine();
		
		System.out.println("Enter Wheel Base: \n");
		String wheel_base = new Scanner(System.in).nextLine();
		
		System.out.println("Enter Height: \n");
		String height = new Scanner(System.in).nextLine();
		
		System.out.println("Color: \n");
		String color = new Scanner(System.in).nextLine();
		
		System.out.println("Material: \n");
		String material = new Scanner(System.in).nextLine();

		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
			//Statement myStmt = myConn.createStatement();
			String sql = "insert into attributes (type, gear, wheel_base, height, color, material)"
                    + " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, type);
			myStmt.setString(2, gear);
			myStmt.setString(3, wheel_base);
			myStmt.setString(4, height);
			myStmt.setString(5, color);
			myStmt.setString(6, material);
			
			
			
			myStmt.executeUpdate();
			System.out.println("insert successful");
			
			myConn.close();
			 
		}catch (Exception exc) {
            exc.printStackTrace();
		}
		
	}
	void deleteRow(){
		
		
		try {
			System.out.println("To delete by type press 't'\n by material press 'm'\n by gear press 'g'\n by color press 'c'\n by wheelbase press 'w'\n by height press 'h'\n");
			String deleteChoice = new Scanner(System.in).nextLine();

			  if(deleteChoice.equals("t")) {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
				System.out.println("Enter Bike Type: \n");
				String type = new Scanner(System.in).nextLine();
					
				String sql = "delete from attributes where type =?";
				PreparedStatement myStmt = myConn.prepareStatement(sql);
				myStmt.setString(1, type);
		        int rowsDel = myStmt.executeUpdate();
		 
		        System.out.println("Rows affected: " + rowsDel);
		        System.out.println("Delete complete.");
		            
		        myConn.close();
			  }
			  else if(deleteChoice.equals("m")) {
				  Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
					System.out.println("Enter Material Type: \n");
					String mat = new Scanner(System.in).nextLine();
						
					String sql = "delete from attributes where type =?";
					PreparedStatement myStmt = myConn.prepareStatement(sql);
					myStmt.setString(1, mat);
			        int rowsDel = myStmt.executeUpdate();
			 
			        System.out.println("Rows affected: " + rowsDel);
			        System.out.println("Delete complete.");
			            
			        myConn.close();
			  }
			  else if(deleteChoice.equals("g")){
				  Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
					System.out.println("Enter Gear Type: \n");
					String gear = new Scanner(System.in).nextLine();
						
					String sql = "delete from attributes where gear=?";
					PreparedStatement myStmt = myConn.prepareStatement(sql);
					myStmt.setString(1, gear);
			        int rowsDel = myStmt.executeUpdate();
			 
			        System.out.println("Rows affected: " + rowsDel);
			        System.out.println("Delete complete.");
			            
			        myConn.close();
			  }
			  else if (deleteChoice.equals("w")){
				  Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
					System.out.println("Enter Wheel Base: \n");
					String wheel = new Scanner(System.in).nextLine();
						
					String sql = "delete from attributes where wheel_base=?";
					PreparedStatement myStmt = myConn.prepareStatement(sql);
					myStmt.setString(1, wheel);
			        int rowsDel = myStmt.executeUpdate();
			 
			        System.out.println("Rows affected: " + rowsDel);
			        System.out.println("Delete complete.");
			            
			        myConn.close();
			  }
			  else if (deleteChoice.equals("c")){
				  Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
					System.out.println("Enter Color: \n");
					String colorr = new Scanner(System.in).nextLine();
						
					String sql = "delete from attributes where color=?";
					PreparedStatement myStmt = myConn.prepareStatement(sql);
					myStmt.setString(1, colorr);
			        int rowsDel = myStmt.executeUpdate();
			 
			        System.out.println("Rows affected: " + rowsDel);
			        System.out.println("Delete complete.");
			            
			        myConn.close();
			  }
			  else if (deleteChoice.equals("h")){
				  Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles", "root" ,"Jamesbond007");
					System.out.println("Enter Height: \n");
					String heightt = new Scanner(System.in).nextLine();
						
					String sql = "delete from attributes where height=?";
					PreparedStatement myStmt = myConn.prepareStatement(sql);
					myStmt.setString(1, heightt);
			        int rowsDel = myStmt.executeUpdate();
			 
			        System.out.println("Rows affected: " + rowsDel);
			        System.out.println("Delete complete.");
			            
			        myConn.close();
			  }
			
			 
		}catch (Exception exc) {
            exc.printStackTrace();
		}
		
	}
}

