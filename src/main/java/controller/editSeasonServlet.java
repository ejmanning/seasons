package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recreation;
import model.Season;

/**
 * Servlet implementation class editSeasonServlet
 */
@WebServlet("/editSeasonServlet")
public class editSeasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSeasonServlet() {
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
		RecreationHelper rh = new RecreationHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Season seasonToUpdate = dao.searchForSeasonById(tempId);
		//Season seasonToUpdate = request.getParameter();
		String recreation = request.getParameter("allRecreationsToAdd");
		
		//seasonToUpdate.setRecreations(recreation);
		try {
			//items are selected in list to add
			String[] selectedRecreations = request.getParameterValues("allRecreationsToAdd");
			List<Recreation> selectedRecreationsInSeason = new ArrayList<Recreation>();
			
			for(int i = 0; i < selectedRecreations.length; i++) {
				System.out.println(selectedRecreations[i]);
				Recreation c = rh.searchForRecreationById(Integer.parseInt(selectedRecreations[i]));
				selectedRecreationsInSeason.add(c);
			}
			seasonToUpdate.setRecreations(selectedRecreationsInSeason);
		} catch (NullPointerException ex) {
			// no items selected in list-set to an empty list
			List<Recreation> selectedRecreationsInSeason = new ArrayList<Recreation>();
			seasonToUpdate.setRecreations(selectedRecreationsInSeason);
		}
			
			dao.updateSeason(seasonToUpdate);
			
			getServletContext().getRequestDispatcher("/viewAllSeasonsServlet").forward(request, response);

	}

}
