package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recreation;

/**
 * Servlet implementation class recreationNavigationServlet
 */
@WebServlet("/recreationNavigationServlet")
public class recreationNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recreationNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RecreationHelper dao = new RecreationHelper();
		String act = request.getParameter("doThisToRecreation");
		
		String path = "/viewAllRecreationsServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Recreation recreationToDelete = dao.searchForRecreationById(tempId);
				dao.deleteItem(recreationToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a recreation");
			}
			
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Recreation recreationToEdit = dao.searchForRecreationById(tempId);
				request.setAttribute("recreationToEdit", recreationToEdit);
				path = "/edit-recreation.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a recreation");
			}
		} else if(act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
