package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recreation;
import model.Season;

/**
 * Servlet implementation class seasonNavigationServlet
 */
@WebServlet("/seasonNavigationServlet")
public class seasonNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seasonNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RecreationHelper rh = new RecreationHelper();
		request.setAttribute("allRecreations", rh.showAllRecreations());
		
		SeasonHelper dao = new SeasonHelper();
		String act = request.getParameter("doThisToSeason");
		
		String path = "/viewAllSeasonsServlet";
		
		if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Season seasonToEdit = dao.searchForSeasonById(tempId);
				request.setAttribute("seasonToEdit", seasonToEdit);
				path = "/edit-season.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a season");
			}
		} 
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
