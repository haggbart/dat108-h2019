package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.UrlMappings.WEBSHOP_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/" + LOGIN_URL)
public class LoggInnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Inn noe kode her i forbindelse med evt. feilmeldinger?
        String feilkode = request.getParameter("feilkode");
        String feilmelding = "";
        if (feilkode != null) {
        	if (feilkode.equals("1")) {
        		feilmelding = "Ugyldig brukernavn ...";
        	} else if (feilkode.equals("2")) {
        		feilmelding = "Du m� logge inn f�r du handler ...";
        	}
        }
        
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        
        // Inn noe kode her i forbindelse med evt. feilmeldinger?
        out.println("<p>" + feilmelding + "</p>");
        
        out.println("<form action=\"" + LOGIN_URL + "\" method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Login</legend>");
        out.println("    <p>Navn: <input type=\"text\" name=\"username\" /></p>");
        out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Inn noe kode her i forbindelse med innlogging av bruker?
    	String username = request.getParameter("username");
    	
    	if (username == null) { // || !erGyldig(username)) {
    		response.sendRedirect("/" + LOGIN_URL + "?feilkode=1");
    	} else {
    		
    		//Innlogging:
    		HttpSession sesjon = request.getSession(false);
    		if (sesjon != null) {
    			sesjon.invalidate();
    		}
    		sesjon = request.getSession(true);
    		sesjon.setMaxInactiveInterval(30); //sekunder
    		
    		sesjon.setAttribute("username", username);
    		sesjon.setAttribute("cart", new Cart());
    		
    		
    	    response.sendRedirect(WEBSHOP_URL);
    	}
    }
}



