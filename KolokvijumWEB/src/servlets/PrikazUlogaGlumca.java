package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Controller;
import models.Uloga;

/**
 * Servlet implementation class PrikazUlogaGlumca
 */
@WebServlet("/PrikazUlogaGlumca")
public class PrikazUlogaGlumca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazUlogaGlumca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		
		List<Uloga> uloge = Controller.getUlogeGlumca(ime, prezime);
		
		boolean postojiRezultat = false;
		if(uloge != null && uloge.size() > 0) {
			postojiRezultat = true;
		}
		request.setAttribute("postojiRezultat", postojiRezultat);
		request.setAttribute("uloge", uloge);
		RequestDispatcher rd = request.getRequestDispatcher("Glumac.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
