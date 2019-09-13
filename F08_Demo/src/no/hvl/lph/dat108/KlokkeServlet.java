package no.hvl.lph.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/klokken")
public class KlokkeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() ble kjørt");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.err.println("doGet() ble kjørt");
		
		String navn = request.getParameter("navn");
				
		LocalTime klokken = LocalTime.now();
		
		response.setContentType("text/plain; charset=ISO-8859-1"); 
		
		PrintWriter out = response.getWriter();

		out.println("Hallo " + navn + ". Ha en fin dag.");
		out.println("Klokken er : " + klokken);
	}
}





