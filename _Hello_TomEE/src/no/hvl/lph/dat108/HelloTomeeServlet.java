package no.hvl.lph.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloTomeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// Auto-generated method stub!
		// ... with expected response: HTTP Status 405 – Method Not Allowed
        // super.doGet(req, resp);
		
		resp.setContentType("text/plain; charset=ISO-8859-1");
		resp.getWriter().println("Hello TomEE !!!");
	}

}
