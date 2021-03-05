package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recreation;

/**
 * Servlet implementation class addRecreationServlet
 */
@WebServlet("/addRecreationServlet")
public class addRecreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRecreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String recName = request.getParameter("recreation");
		
		Recreation r = new Recreation(recName);
		RecreationHelper dao = new RecreationHelper();
		dao.insertRecreation(r);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
