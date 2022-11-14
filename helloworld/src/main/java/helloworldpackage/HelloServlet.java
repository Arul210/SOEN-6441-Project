
package helloworldpackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
		// TODO Auto-generated method stub
		//String yourName = request.getParameter("yourName");
		String diet = request.getParameter("diet");
		String intolerance = request.getParameter("intolerance");
		Main mainobj = new Main();
		String result = null;
       // String button = request.getParameter("button");
		if (diet != null && intolerance != null) {
			result = mainobj.printString(diet,intolerance);
		}
      
      //  request.getRequestDispatcher("/WEB-INF/NewFile.jsp").forward(request, response);
		
        PrintWriter writer = response.getWriter();
        String htmlRespone = "<html>";
      //  htmlRespone += "<h2> Dietary restrictions: " + diet + "<br/>";   
        htmlRespone += "<h2> result from java program" + result + "<br/>";     
        htmlRespone += "</html>";       
        writer.println(htmlRespone);
	}

}
