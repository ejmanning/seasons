package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recreation;

/**
 * Servlet implementation class editRecreationServlet
 */
@WebServlet("/editRecreationServlet")
public class editRecreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editRecreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RecreationHelper dao = new RecreationHelper();
		
		String recname = request.getParameter("recname");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Recreation recreationToUpdate = dao.searchForRecreationById(tempId);
		recreationToUpdate.setRecname(recname);
		
		dao.updateRecreation(recreationToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllRecreationsServlet").forward(request, response);
	}

}
