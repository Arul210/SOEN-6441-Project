package food_api;
import java.sql.*; 

public class DB_conn {
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost/sample","root","Arul@210");  
			System.out.println("Inside");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from intolerances;");
			//System.out.println(rs.next());
			while(rs.next())  
				System.out.println("hello");
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}  
	} 
	/*public static void main(String args[]) throws SQLException {
		ResultSet rs=conn();
		while(rs.next())  
			System.out.println(rs.getString("SYMBOL"));
	}*/
}  


