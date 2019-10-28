package no.hib.dat104.lph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BmiServlet3TestV2{
    
    private static final String UNDERVEKT_STRING = "undervekt";
    private static final String NORMALVEKT_STRING = "normalvekt";
    
    private BmiServlet3 s3;
    
    @Before
    public void setup() {
        s3 = new BmiServlet3(); //Ikke n�dv. � gj�re dette hver gang, men ...
    }

    @Test
    public void bmiPaaAttenKommaFireSkalVaereUndervekt() {
        assertEquals(UNDERVEKT_STRING, s3.beregnVektklasse(18.4));
    }

    @Test
    public void bmiPaaAttenKommaFemSkalVaereNormalvekt() {
        assertEquals(NORMALVEKT_STRING, s3.beregnVektklasse(18.5));
    }
    
    //+ mange flere tester p� denne metoden
    
    @Test
    public void avrundingAvKomma45SkalVaereKomma5() {
        assertEquals(20.5, s3.rundAvTilEnDesimal(20.45), Double.MIN_VALUE);
    }

    @Test
    public void avrundingAvKomma44SkalVaereKomma4() {
        assertEquals(20.4, s3.rundAvTilEnDesimal(20.44), Double.MIN_VALUE);
    }

    //+ flere tester p� denne metoden
    
    /* 
     * osv ... p� de andre metodene:
     * 
     *      double beregnBmi(double hoydeMeter, double vektKg)
     *      boolean gyldigHoydeMeter(double hoydeMeter)
     *      boolean gyldigVektKg(double vektKg)
     */
    
}
