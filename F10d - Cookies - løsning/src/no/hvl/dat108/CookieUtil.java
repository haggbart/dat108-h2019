package no.hvl.dat108;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	public static void addCookieToResponse(HttpServletResponse response, String navn, String verdi) {
		try {
			Cookie cookie = new Cookie(navn, URLEncoder.encode(verdi, "UTF-8"));
			cookie.setMaxAge(30); // 30 sekunder
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getCookieFromRequest(HttpServletRequest request, String navn) {
		String verdi = null;
		try {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(navn)) {
						verdi = URLDecoder.decode(cookie.getValue(), "UTF-8");
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verdi;
	}
}
