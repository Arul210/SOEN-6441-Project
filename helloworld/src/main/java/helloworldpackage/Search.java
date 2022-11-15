package helloworldpackage;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Search {
	
	public ArrayList<String> getFood(String diet, String intolerance, String calories) {
		DB_conn db_conn = new DB_conn();
		ArrayList<String> title = new ArrayList<String>();
		String[] calories_str = calories.split("-");
		String min,max;
		min=calories_str[0];
		max=calories_str[1];
		String select_query="select * from food where id in(select id from nutrition where id in "
				+ "(select d.id from intolerances as i inner join diet as d "
				+ "where "+ diet +"=\"yes\" and "+ intolerance +"=\"yes\") and calories>"+ min +" and calories<="+max+");";
		ResultSet rs1=db_conn.connection(select_query);
		try {			
			while(rs1.next()) {
				title.add(rs1.getString("title"));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			title.add("Empty Set");
		}
		return title;
	}
	public ArrayList<String> getRecipe(String diet, String intolerance, String calories) {
		DB_conn db_conn = new DB_conn();
		ArrayList<String> card = new ArrayList<String>();
		String[] calories_str = calories.split("-");
		String min,max;
		min=calories_str[0];
		max=calories_str[1];
		String select_query="select card from recipe where id in (select id from food where id in (select id from nutrition where id in "
				+ "(select d.id from intolerances as i inner join diet as d "
				+ "where "+ diet +"=\"yes\" and "+ intolerance +"=\"yes\") and calories>"+ min +" and calories<="+max+"));";
		ResultSet rs2=db_conn.connection(select_query);
		try {			
			while(rs2.next()) {
				card.add(rs2.getString("card"));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			card.add("Empty Set");
		}
		return card;
	}
	public ArrayList<String> getNutrition(String diet, String intolerance, String calories) {
		DB_conn db_conn = new DB_conn();
		ArrayList<String> cal = new ArrayList<String>();
		String[] calories_str = calories.split("-");
		String min,max;
		min=calories_str[0];
		max=calories_str[1];
		String select_query="select calories,carbs,fat,protein from nutrition where id in "
				+ "(select d.id from intolerances as i inner join diet as d "
				+ "where "+ diet +"=\"yes\" and "+ intolerance +"=\"yes\") and calories>"+ min +" and calories<="+max+";";
		ResultSet rs3=db_conn.connection(select_query);
		try {			
			while(rs3.next()) {
				String str=rs3.getString("calories") +','+ rs3.getString("carbs")+','+ rs3.getString("fat")+','+rs3.getString("protein");
				cal.add(str);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			cal.add("Empty Set");
		}
		return cal;
	}
}