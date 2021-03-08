package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Season;

/**
 * Servlet implementation class addRecreationForSeasonServlet
 */
@WebServlet("/addRecreationForSeasonServlet")
public class addRecreationForSeasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRecreationForSeasonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SeasonHelper sh = new SeasonHelper();
		List<Season> abc = sh.getSeasons();
		request.setAttribute("allSeasons", abc);
		
		RecreationHelper dao = new RecreationHelper();
		request.setAttribute("allRecreations", dao.showAllRecreations());
		if(dao.showAllRecreations().isEmpty()) {
			request.setAttribute("allRecreations", " ");
		}
		getServletContext().getRequestDispatcher("/new-recreation-for-season.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
