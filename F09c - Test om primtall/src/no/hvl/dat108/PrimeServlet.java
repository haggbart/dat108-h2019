package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.math3.primes.Primes;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String talletSomString = request.getParameter("tall");
		
		if (!erGyldigHeltall(talletSomString)) {
			// Feilh�ndtering
			
		} else {

			int tallet = Integer.parseInt(talletSomString);

			String erPrimtallTekst;
			if (Primes.isPrime(tallet)) {
				erPrimtallTekst = " er et primtall";
			} else {
				erPrimtallTekst = " er ikke et primtall";
			}
			//alternativt med tern�r op

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<body>");
			out.println("<h1>");
			out.println(tallet + erPrimtallTekst);
			out.println("</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	private boolean erGyldigHeltall(String talletSomString) {
		return talletSomString.matches("^\\d+$");
	}
}


