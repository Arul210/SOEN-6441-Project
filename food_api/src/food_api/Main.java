package food_api;

public class Main {
	public static void main(String[] args) {
		
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
