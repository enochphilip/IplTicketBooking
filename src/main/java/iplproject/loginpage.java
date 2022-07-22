package iplproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class loginpage {

	public static Connection getCon() throws ClassNotFoundException, SQLException
  	{
  		Connection con= null;
  		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Enoch@759840");
  		return con;
  	}
      public static void login() throws ClassNotFoundException, SQLException 
      {
    	  Scanner s = new Scanner(System.in);
          Slotbooking ar = new Slotbooking();
          System.out.println("\t*** Welcome To Login Console ***");
    	  System.out.println("*");
    	  System.out.println("Enter Username:");
         String Username = s.next();
         System.out.println("Enter password:");
         String Password = s.next();
         String sql = "select name,password from users";
         PreparedStatement ps = getCon().prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
        	
        	 if(Username.equals(rs.getString("name"))){
        	 		if(Password.equals(rs.getString("password"))) {
        	 			System.out.println("-----Logged In Successfully------\n");
        	 			
        	 			Connection con=getCon();
        	 			PreparedStatement pst=null;
        	 			String s1 = "select * from matches ";
        	 			pst=con.prepareStatement(s1);
        	 			int matchId = 0;
        	 			int totalTickets = 0;
        	 			int ticketPrice =500;
        	 		    do {
        	 		    	ResultSet rs1=pst.executeQuery();
            	 			
            	 			System.out.println("   Match ID\tTeam 1\tTeam 2\tTime\t\tlocation") ;
            	 			while(rs1.next())
            	 			{   
                                System.out.print("\t");
            	 				System.out.print(rs1.getString("match_id")+"\t");
            	 				System.out.print(rs1.getString("team_1")+"\t");
            	 				System.out.print(rs1.getString("team_2")+"\t");
            	 				System.out.print(rs1.getString("time")+"\t");
            	 				System.out.print(rs1.getString("location")+"\t");
            	 				System.out.println();
            	 			}
            	 			System.out.println("Enter the match ID for booking the ticket");
            	 			System.out.println("*EACH TICKET COST RS.500 ONLY*"); 
            	 			System.out.println("Enter 0 to Finish booking"); 
            	 		    
            	 		    
        	 		           matchId = s.nextInt();
        	 		           System.out.println("") ;
        	 		           int noOfTickets = 0;
        	 		           if(matchId == 1) {
        	 		        	  System.out.println("Please enter the no of tickets"); 
        	 		        	  noOfTickets = s.nextInt();
        	 		           }else if(matchId==2) {
        	 		        	  System.out.println("Please enter the no of tickets"); 
        	 		        	  noOfTickets = s.nextInt();
        	 		        	   
        	 		           } else if(matchId==3) {
        	 		        	  System.out.println("Please enter the no of tickets"); 
        	 		        	  noOfTickets = s.nextInt();
        	 		        	   
        	 		           } else if(matchId==4) {
        	 		        	  System.out.println("Please enter the no of tickets");
        	 		        	  noOfTickets = s.nextInt();
        	 		        	   
        	 		           } else if(matchId==5) {
        	 		        	  System.out.println("Please enter the no of tickets"); 
        	 		        	  noOfTickets = s.nextInt();
        	 		        	   
        	 		           } else if(matchId==0) {
        	 		        	  totalTickets += noOfTickets;
        	 		        	  if(totalTickets > 0) {
        	 		        		 System.out.println("----------***-----------");
        	 		        		 System.out.println("You have booked " + totalTickets + " tickets for Rs."+ (totalTickets * ticketPrice) ); 
           	 		        	     System.out.println("Thankyou for booking tickets"); 
           	 		        	     System.out.println("----------***-----------");
        	 		        	  } else {
        	 		         
           	 		        	  System.out.println("** You didn't book any tickets, Your Game is waiting for you, Come back later **"); 
        	 		        	  }
        	 		        	 
        	 		        	   
        	 		           }else {
        	 		        	  System.out.println("** PLEASE ENTER THE VALID OPTION **");  
        	 		           }
        	 		           totalTickets += noOfTickets;
        	 		      
        	 		      
        	 		      
        	 		    } while(matchId != 0); 
        	 			  
        	}
        	 		else {
           	 			System.out.println("** PLEASE ENTER THE VALID USERNAME AND PASSWORD OR REGISTER **");
           	 			
           	 		
        	 }
        	 }
        	 
        	 
        	
        }
         
         
         
         
      }
      public static void main(String[] args) throws ClassNotFoundException, SQLException {

      
      }

}