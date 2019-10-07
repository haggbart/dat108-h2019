package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ekko")
public class EkkoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String escapeHtml(String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		//...
		return resultat;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		String brukerinput = req.getParameter("fritekst");
		
		brukerinput = escapeHtml(brukerinput);
		
        resp.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Ekko</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>" + brukerinput +"</p>");
        out.println("</body>");
        out.println("</html>");
        
	}

}
