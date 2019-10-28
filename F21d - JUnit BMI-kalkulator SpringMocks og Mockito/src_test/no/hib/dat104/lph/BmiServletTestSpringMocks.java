package no.hib.dat104.lph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BmiServletTestSpringMocks {

    MockHttpServletRequest fakeRequest;
    MockHttpServletResponse fakeResponse;
    BmiServlet bmiServlet;
    
    @Before
    public void fellesOppsettForAlleTestene() {
        fakeRequest = new MockHttpServletRequest();
        fakeResponse = new MockHttpServletResponse();
        bmiServlet = new BmiServlet();
    }
    
    @Test
    public void feilmeldingSkalLagresIRequestScopeHvisParametreIkkeErHeltall() 
            throws ServletException, IOException {
        
        fakeRequest.setParameter("hoyde", "x");
        fakeRequest.setParameter("vekt", "y");
        
        bmiServlet.doGet(fakeRequest, fakeResponse);
        
        assertNotNull(fakeRequest.getAttribute("feilmelding"));
    }

    @Test
    public void feilmeldingSkalLagresIRequestScopeHvisUgyldigeParametre() 
            throws ServletException, IOException {
        
        fakeRequest.setParameter("hoyde", "0");
        fakeRequest.setParameter("vekt", "0");

        bmiServlet.doGet(fakeRequest, fakeResponse);
        
        assertNotNull(fakeRequest.getAttribute("feilmelding"));
    }
    
    @Test
    public void ingenFeilmeldingSkalLagresIRequestScopeHvisOkParametre() 
            throws ServletException, IOException {
        
        fakeRequest.setParameter("hoyde", "185");
        fakeRequest.setParameter("vekt", "80");

        bmiServlet.doGet(fakeRequest, fakeResponse);
        
        assertNull(fakeRequest.getAttribute("feilmelding"));
    }
    
}
