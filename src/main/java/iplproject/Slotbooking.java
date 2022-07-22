package iplproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Slotbooking {
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
		public static void Csk() throws ClassNotFoundException, SQLException {
			String sql = "Select * from Csk";
	        PreparedStatement ps = getCon().prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
				{   
	        	System.out.print("\t");
				System.out.print(rs.getString("opteam")+"     \t");
				System.out.print(rs.getString("date")+"     \t");
				System.out.println();
			}
	}
public static void Mi() throws SQLException, ClassNotFoundException {
	String sql = "Select * from Mi";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next())
		{   
        System.out.print("\t");
			System.out.print(rs.getString("opteam")+"     \t");
			System.out.print(rs.getString("date")+"     \t");
			System.out.println();
		}
}
public static void Rcb() throws ClassNotFoundException, SQLException {
	String sql = "Select * from Rcb";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next())
		{   
        System.out.print("\t");
			System.out.print(rs.getString("opteam")+"     \t");
			System.out.print(rs.getString("date")+"     \t");
			System.out.println();
		}
}
public static void Dc() throws ClassNotFoundException, SQLException {
	String sql = "Select * from Dc";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next())
		{   
        System.out.print("\t");
			System.out.print(rs.getString("opteam")+"     \t");
			System.out.print(rs.getString("date")+"     \t");
			System.out.println();
		}
}
public static void RR() throws ClassNotFoundException, SQLException {
	String sql = "Select * from RR";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next())
		{   
        System.out.print("\t");
			System.out.print(rs.getString("opteam")+"     \t");
			System.out.print(rs.getString("date")+"     \t");
			System.out.println();
		}
}



	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
      
      System.out.println("Enter the choice:");
      int ch = sc.nextInt();
      switch(ch) {
      case 1:
    	  Csk();
    	  break;
      case 2:
    	  Mi();
    	  break;
      case 3:
    	  Rcb();
    	  break;
      case 4:
    	  Dc();
    	  break;
      case 5:
    	  RR();
    	  break;
      }
      
	}

	

}