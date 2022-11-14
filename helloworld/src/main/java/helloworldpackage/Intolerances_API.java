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

public class Intolerances_API {
	public static void intolerances_table() {
		DB_conn db_conn=new DB_conn();
		try {
			
			String[] intolerances_array={"Diary","Egg","Glutten","Grain","Peanut","Seafood","Sesame","Shellfish",
					"Soy","Sulfite","Tree+Nut","Wheat"};  
			String intolerances_query="create table intolerances(id int NOT NULL PRIMARY KEY";
			for(String s:intolerances_array) {
				if(s.contains("+")) {
					s=s.replace("+", "");
				}
				intolerances_query=intolerances_query+","+s+" varchar(10) DEFAULT 'no'";
			}
			intolerances_query=intolerances_query+");";
			ResultSet rs=db_conn.connection(intolerances_query);
			
			for(String s:intolerances_array) {
				URL intolerances_url = new URL("https://api.spoonacular.com/recipes/complexSearch?intolerances="+s+"&apiKey=a60a514dcf84490ab57f21b4fee00d65");
				HttpURLConnection conn = (HttpURLConnection) intolerances_url.openConnection();
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
						ResultSet rs1,rs2;
						if(s.contains("+")) {
							s=s.replace("+", "");
							rs1=db_conn.connection("select * from intolerances where id="+innerobj.get("id")+";");
							if(!rs1.next()) {
								rs2=db_conn.connection("insert into intolerances(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs2=db_conn.connection("update intolerances set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
							}
						}
						else {
							rs1=db_conn.connection("select * from intolerances where id="+innerobj.get("id")+";");
							if(!rs1.next()) {
								rs2=db_conn.connection("insert into intolerances(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs2=db_conn.connection("update intolerances set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
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
