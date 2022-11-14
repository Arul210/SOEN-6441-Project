package helloworldpackage;
import java.sql.*; 

public class DB_conn {
	public ResultSet connection(String arg){  
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost/sample","root","Arul@210");  
			System.out.println(arg);
			Statement stmt=con.createStatement(); 
			if(arg.contains("select")) {
				ResultSet rs= stmt.executeQuery(arg); 
				return rs;
			}
			else {
				stmt.executeUpdate(arg);
				con.close();
				return null;
			}  
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	} 
}  


