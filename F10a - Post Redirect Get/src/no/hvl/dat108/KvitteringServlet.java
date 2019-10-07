package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kvittering")
public class KvitteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String navn = request.getParameter("navn");
		
		String navn = (String) request.getSession().getAttribute("navn");
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("Du er herved påmeldt, " + navn);
	}

	
}



