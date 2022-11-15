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

public class Nutrition_API {
	public static void nutrition_table() {
		DB_conn db_conn=new DB_conn();
	
		try { 
			ResultSet rs=db_conn.connection("create table nutrition(id int NOT NULL PRIMARY KEY, calories varchar(10), carbs varchar(10), fat varchar(10), protein varchar(10));");
			rs=db_conn.connection("select id from food;");
			while(rs.next()) {
				int id=rs.getInt("id");
				URL nutrition_url = new URL("https://api.spoonacular.com/recipes/"+id+"/nutritionWidget.json?apiKey=a60a514dcf84490ab57f21b4fee00d65");
				HttpURLConnection conn = (HttpURLConnection) nutrition_url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}
			
				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					JSONObject obj= new JSONObject(output);
					ResultSet rs1=db_conn.connection("select * from nutrition where id="+id+";");
					if(!rs1.next()) {
						ResultSet rs2=db_conn.connection("insert into nutrition(id,calories,carbs,fat,protein) values("+id+",\""+obj.getString("calories")+"\",\""+
								obj.getString("carbs")+"\",\""+obj.getString("fat")+"\",\""+obj.getString("protein")+"\");");
					}			
				}
				conn.disconnect();
			} 
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (JSONException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
