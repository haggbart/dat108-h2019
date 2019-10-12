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

    	//Har brukt en request-parameter for � angi feilmelding
    	//Har brukt ulike parametre for ulike feil
    	//Det er andre og muligens bedre m�ter � gj�re dette p�
        boolean requiresLoginRedirect = request
                .getParameter("requiresLogin") != null;
        boolean invalidUsernameRedirect = request
                .getParameter("invalidUsername") != null;

        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        
        if (requiresLoginRedirect) {
            out.println("<p><font color=\"red\">" +
                    "Foresp�rselen din krever p�logging. " +
                    "(Du kan ha blitt logget ut automatisk)</font></p>");
            
        } else if (invalidUsernameRedirect) {
            out.println("<p><font color=\"red\">" +
            		"Manglende eller ugyldig brukernavn</font></p>");
        }
        
        out.println("<form action=\"" + LOGIN_URL
                + "\" method=\"post\">");
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

        String username = request.getParameter("username");

        if (username == null || !Validator.isValidUsername(username)) {
            response.sendRedirect(LOGIN_URL + "?invalidUsername");
        } else {

            HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(10);

            sesjon.setAttribute("username", username);
            sesjon.setAttribute("cart", new Cart());

            response.sendRedirect(WEBSHOP_URL);
        }
    }
}
