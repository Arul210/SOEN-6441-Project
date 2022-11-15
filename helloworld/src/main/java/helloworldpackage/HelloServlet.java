
package helloworldpackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class HelloServlet
 */

@SuppressWarnings("unused")
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String diet = request.getParameter("diet");
		String intolerance = request.getParameter("intolerance");
		String calories = request.getParameter("calories");
		Main mainobj = new Main();
		//mainobj.connAPI();
		
		Search searchobj = new Search();
		ArrayList<String> food = new ArrayList<String>();
		ArrayList<String> recipe = new ArrayList<String>();
		ArrayList<String> cal = new ArrayList<String>();
		
		if (diet != null && intolerance != null) {
			food = searchobj.getFood(diet,intolerance,calories);
			recipe = searchobj.getRecipe(diet,intolerance,calories);
			cal=searchobj.getNutrition(diet, intolerance, calories);
		}
		
		request.setAttribute("title", food);
		request.setAttribute("card", recipe);
		request.setAttribute("cal", cal);
        request.getRequestDispatcher("/WEB-INF/second.jsp").forward(request, response);
		
	}

}
