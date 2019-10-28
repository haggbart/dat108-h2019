package somepackage;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CookieUtilTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    
    @Before
    public void setup() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    
    @Test
    public void cookieSkalKunneHentesUtDekodetFraRequest() {
        
        //Arrange
        request.setCookies(new Cookie[]{new Cookie("User", "Atle+Patle")});
        //Act
        String cookie = CookieUtil.getCookieFromRequest(request, "User");
        //Assert
        assertEquals("Atle Patle", cookie);
    }
    
    @Test
    public void cookieBlirLagretKodetOgTidsmerket() {
        
        //Act
    	CookieUtil.addCookieToResponse(response, "User", "Atle Patle");
        //Assert
        Cookie cookie = response.getCookies()[0];
        assertEquals("User", cookie.getName());
        assertEquals("Atle+Patle", cookie.getValue());
        assertEquals(30, cookie.getMaxAge());
    }

}
