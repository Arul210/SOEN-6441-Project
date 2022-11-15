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

public class Main {
	public void connAPI() {
		Diet_API diet_instance = new Diet_API(); 
		diet_instance.diet_table();
		
		Intolerances_API intolerances_instance = new Intolerances_API();
		intolerances_instance.intolerances_table();
		
		Nutrition_API nutrition_instance = new Nutrition_API();
		nutrition_instance.nutrition_table();
		
		Recipe_API recipe_instance = new Recipe_API();
		recipe_instance.recipe_table();			
	}
}