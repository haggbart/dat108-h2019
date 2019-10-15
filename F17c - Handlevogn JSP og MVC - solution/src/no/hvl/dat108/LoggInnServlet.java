package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.UrlMappings.WEBSHOP_URL;

import java.io.IOException;

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

        String loginMessage = "";
        
        if (request.getParameter("requiresLogin") != null) {
        	loginMessage = "Foresp�rselen din krever p�logging. " 
        			+ "(Du kan ha blitt logget ut automatisk)";
        	
        } else if (request.getParameter("invalidUsername") != null) {
        	loginMessage = "Manglende eller ugyldig brukernavn"; 
        }

        request.setAttribute("loginMessage", loginMessage);
        
        request.getRequestDispatcher("WEB-INF/login.jsp")
        		.forward(request, response);
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
