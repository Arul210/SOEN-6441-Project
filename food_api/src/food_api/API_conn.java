package food_api;

import java.sql.*; 
import java.io.BufferedReader;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class API_conn {
	public static void main(String[] args) {
		//diet_table();
		//intolerances_table();
		//nutrition_table();
		//recipe_table();
	}
	public static void diet_table() {
		try {
			
			String[] diet_array={"Gluten+Free", "Ketogenic", "Vegetarian", "Lacto-Vegetarian", "Ovo-Vegetarian", "Vegan", 
					"Pescetarian", "Paleo", "Primal", "Low+FODMAP", "Whole30"};  
			ResultSet rs=connection("create table Food(id int NOT NULL PRIMARY KEY, title varchar(100) NOT NULL, imagepath varchar(300), imagetype varchar(10));");
			String diet_query="create table diet(id int NOT NULL PRIMARY KEY";
			for(String s:diet_array) {
				if(s.contains("+") || s.contains("-")) {
					s=s.replace("+", "");
					s=s.replace("-", "");
				}
				diet_query=diet_query+","+s+" varchar(10) DEFAULT 'no'";
			}
			diet_query=diet_query+");";
			rs =connection(diet_query);
			
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
						rs=connection("select * from food where id="+innerobj.get("id")+";");
						if(!rs.next()) {
							ResultSet rs1=connection("insert into food (id, title, imagepath, imagetype) values ("+innerobj.get("id")+",\""+innerobj.get("title")+
							"\",\""+innerobj.get("image")+"\",\""+innerobj.get("imageType")+"\")");
						}
						ResultSet rs1;
						if(s.contains("+") || s.contains("-")) {
							s=s.replace("+", "");
							s=s.replace("-", "");
							rs=connection("select * from diet where id="+innerobj.get("id")+";");
							if(!rs.next()) {
								rs1=connection("insert into diet(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs1=connection("update diet set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
							}
						}
						else {
							rs=connection("select * from diet where id="+innerobj.get("id")+";");
							if(!rs.next()) {
								rs1=connection("insert into diet(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs1=connection("update diet set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
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
	public static void intolerances_table() {
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
			ResultSet rs=connection(intolerances_query);
			
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
						rs=connection("select * from food where id="+innerobj.get("id")+";");
						if(!rs.next()) {
							ResultSet rs1=connection("insert into food (id, title, imagepath, imagetype) values ("+innerobj.get("id")+",\""+innerobj.get("title")+
							"\",\""+innerobj.get("image")+"\",\""+innerobj.get("imageType")+"\")");
						}
						ResultSet rs1,rs2;
						if(s.contains("+")) {
							s=s.replace("+", "");
							rs1=connection("select * from intolerances where id="+innerobj.get("id")+";");
							if(!rs1.next()) {
								rs2=connection("insert into intolerances(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs2=connection("update intolerances set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
							}
						}
						else {
							rs1=connection("select * from intolerances where id="+innerobj.get("id")+";");
							if(!rs1.next()) {
								rs2=connection("insert into intolerances(id,"+s+") values("+innerobj.get("id")+",\"yes\");");
							}
							else {
								rs2=connection("update intolerances set "+s+"=\"yes\" where id="+innerobj.get("id")+";");
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
	public static void nutrition_table() {
		try { 
			ResultSet rs=connection("create table nutrition(id int NOT NULL PRIMARY KEY, calories varchar(10), carbs varchar(10), fat varchar(10), protein varchar(10));");
			rs=connection("select id from food;");
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
					ResultSet rs1=connection("select * from nutrition where id="+id+";");
					if(!rs1.next()) {
						ResultSet rs2=connection("insert into nutrition(id,calories,carbs,fat,protein) values("+id+",\""+obj.getString("calories")+"\",\""+
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
	public static void recipe_table() {
		try { 
			ResultSet rs=connection("create table recipe(id int NOT NULL PRIMARY KEY, card varchar(300));");
			rs=connection("select id from food;");
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
					ResultSet rs1=connection("select * from recipe where id="+id+";");
					if(!rs1.next()) {
						if(obj.getString("status").contentEquals("failure")) {
							break;
						}
						else {
							ResultSet rs2=connection("insert into recipe(id,card) values("+id+",\""+obj.getString("url")+"\");");
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
	public static ResultSet connection(String arg){  
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