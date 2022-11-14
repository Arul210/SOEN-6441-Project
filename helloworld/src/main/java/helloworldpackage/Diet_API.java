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

public class Diet_API {
	public static void diet_table() {
		DB_conn db_conn = new DB_conn(); 
		try {
			
			String[] diet_array={"Gluten+Free", "Ketogenic", "Vegetarian", "Lacto-Vegetarian", "Ovo-Vegetarian", "Vegan", 
					"Pescetarian", "Paleo", "Primal", "Low+FODMAP", "Whole30"};  
			ResultSet rs=db_conn.connection("create table Food(id int NOT NULL PRIMARY KEY, title varchar(100) NOT NULL, imagepath varchar(300), imagetype varchar(10));");
			String diet_query="create table diet(id int NOT NULL PRIMARY KEY";
			for(String s:diet_array) {
				if(s.contains("+") || s.contains("-")) {
					s=s.replace("+", "");
					s=s.replace("-", "");
				}
				diet_query=diet_query+","+s+" varchar(10) DEFAULT 'no'";
			}
			diet_query=diet_query+");";
			rs =db_conn.connection(diet_query);
			
			for(String s:diet_array) {
				URL diet_url = new URL("https://api.spoonacular.com/recipes/complexSearch?diet="+s+"&apiKey=9e6cfba4e45a412a96635eabc677e688");
				HttpURLConnection conn = (HttpURLConnection) diet_url.openConnection();
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
					JSONObject innerobj=new JSONObject();
					for(int i=0;i<obj.getJSONArray("results").length();i++) {
						innerobj=(JSONObject) obj.getJSONArray("results").get(i);
						rs=db_conn.connection("select * from food where id="+innerobj.get("id")+";");
						if(!rs.next()) {
							ResultSet rs1=db_conn.connection("insert into food (id, title, imagepath, imagetype) values ("+innerobj.get("id")+",\""+innerobj.get("title")+
							"\",\""+innerobj.get("image")+"\",\""+innerobj.get("imageType")+"\")");
						}
						ResultSet rs1;
						if(s.contains("+") || s.contains("-")) {
							s=s.replace("+", "");
							s=s.replace("-", "");
							rs=db_conn.connection("select * from diet where id="+innerobj.get("id")+";");
							if(!rs.next()) {
								rs1=db_conn.connection("insert into diet(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs1=db_conn.connection("update diet set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
							}
						}
						else {
							rs=db_conn.connection("select * from diet where id="+innerobj.get("id")+";");
							if(!rs.next()) {
								rs1=db_conn.connection("insert into diet(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs1=db_conn.connection("update diet set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
							}
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
