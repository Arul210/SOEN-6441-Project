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

public class Recipe_API {
	public static void recipe_table() {
		DB_conn db_conn=new DB_conn();
		
		try { 
			ResultSet rs=db_conn.connection("create table recipe(id int NOT NULL PRIMARY KEY, card varchar(300));");
			rs=db_conn.connection("select id from food;");
			while(rs.next()) {
				int id=rs.getInt("id");
				System.out.println(id);
				URL recipe_url = new URL("https://api.spoonacular.com/recipes/"+id+"/card?backgroundImage=none&apiKey=1343b8601cd042619a57787ff7f210d8");
				System.out.println(recipe_url);
				HttpURLConnection conn = (HttpURLConnection) recipe_url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				if (conn.getResponseCode() != 200) {
					//throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
					System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
					continue;
				}
			
				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					JSONObject obj= new JSONObject(output);
					ResultSet rs1=db_conn.connection("select * from recipe where id="+id+";");
					if(!rs1.next()) {
						if(obj.getString("status").contentEquals("failure")) {
							break;
						}
						else {
							ResultSet rs2=db_conn.connection("insert into recipe(id,card) values("+id+",\""+obj.getString("url")+"\");");
						}
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
