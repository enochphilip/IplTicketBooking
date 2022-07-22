package iplproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Registration {

	public static Connection getCon() throws ClassNotFoundException, SQLException
  	{
  		Connection con= null;
  		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Enoch@759840");
  		if(con!=null)
  		{
  			System.out.println("Connected!!");
  		}
  		return con;
  	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	 Scanner scan = new Scanner(System.in);
	 int choice = 0;
	 System.out.println("Welcome To IPL Booking App") ;
	 do {
		System.out.println("Please Enter 1 for Registration, 2 for Login, 3 for Exit") ;
		System.out.println("\n\n1-Registration\n2-Login\n3-Exit") ;
		choice = scan.nextInt();

		if(choice == 1) {
			System.out.println("REGISTRATION FORM");
		      System.out.println("**");
		      System.out.println("Enter Name:");
		      String name = scan.next();
		      System.out.println("Enter Email Id:");
		      String email = scan.next();
		      System.out.println("Enter Mobile Number:");
		      String phoneNumber = scan.next();
		      System.out.println("Enter Password:");
		      String password = scan.next();
		      System.out.println("Enter ID Proof:");
		      String id_proof = scan.next();
		      
		      
		      Connection con = getCon();
		      PreparedStatement ps = null;
		      String st = "insert into users(name,email,phone_number,password,id_proof)values(?,?,?,?,?);";
		      ps = con.prepareStatement(st);
		      ps.setString(1,name);
		      ps.setString(2, email);
		      ps.setString(3, phoneNumber);
		      ps.setString(4,password);
		      ps.setString(5,id_proof);
		      ps.executeUpdate();
		      System.out.println("-----Successfully Registered------");
		      System.out.println("\n*** PLEASE LOGIN NOW BY ENTERING OPTION 2 ***") ;
		} 
		  else if( choice == 2){
			 loginpage p = new loginpage();
		      p.login();
		    
		}else if(choice==3) {
			 System.out.println("Thanks for using our App, Come Back Soon.....");
		} else {
			 System.out.println("OOPS!! Invalid Option, Please Enter Correct Option...");
		}
	 }while(choice != 3);
             
      
	}

}