package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		SeasonHelper dao = new SeasonHelper();
		String act = request.getParameter("doThisToSeason");
		
		if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Season seasonToEdit = dao.searchForSeasonById(tempId);
				request.setAttribute("seasonToEdit", seasonToEdit);
				
				request.setAttribute("seasonname", seasonToEdit.getSeasonname());
				
				RecreationHelper daoForRecreations = new RecreationHelper();
				request.setAttribute("allRecreations", daoForRecreations.showAllRecreations());
				
				if(daoForRecreations.showAllRecreations().isEmpty()) {
					request.setAttribute("allRecreations", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-season.jsp").forward(request, response);
			} catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllSeasonsServlet").forward(request, response);
			}
		}
	}

}
