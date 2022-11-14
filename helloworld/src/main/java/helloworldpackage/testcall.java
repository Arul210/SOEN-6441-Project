package helloworldpackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class testcall
 */
public class testcall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testcall() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        test myClass = new test();
        String button = request.getParameter("button");

        if ("button".equals(button)) {
            myClass.method1();
        } else if ("button2".equals(button)) {
            myClass.method2();
        } else if ("button3".equals(button)) {
            myClass.method3();
        } else {
            // ???
        }

        request.getRequestDispatcher("/WEB-INF/NewFile.jsp").forward(request, response);
    }



}
