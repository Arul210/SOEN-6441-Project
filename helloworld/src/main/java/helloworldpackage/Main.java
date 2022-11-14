package helloworldpackage;
import java.sql.*; 
import java.io.BufferedReader;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 * Diet_API diet_instance = new Diet_API(); 
		 * diet_instance.diet_table();
		 * 
		 * Intolerances_API intolerances_instance = new Intolerances_API();
		 * intolerances_instance.intolerances_table();
		 * 
		 * Nutrition_API nutrition_instance = new Nutrition_API();
		 * nutrition_instance.nutrition_table();
		 * 
		 * Recipe_API recipe_instance = new Recipe_API();
		 * recipe_instance.recipe_table();
		 *
		 */
		
	}
	public String printString(String diet, String intolerance) {
		
		System.out.println("Diet from servlet "+diet);
		System.out.println("Intolerance from servlet"+ intolerance); 
		DB_conn db_conn = new DB_conn();
		String title="";
		ResultSet rs=db_conn.connection("select title from food where id in "
				+ "(select d.id from intolerances as i inner join diet as d "
				+ "where"+ diet +"=\"yes\" and"+ intolerance +"=\"yes\");");
		try {			
			while(rs.next()) {
				title+=rs.getString("title");
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;

}
}