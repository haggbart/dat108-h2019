package no.hib.dat104.lph;

import static no.hib.dat104.lph.BmiVektklasse.*;
import static org.junit.Assert.assertEquals;
import no.hib.dat104.lph.BmiCalculator;

import org.junit.Test;

public class BmiCalculatorTestPlainJUnit {
    
    private BmiCalculator bmiCalc = new BmiCalculator(); 
    
    @Test
    public void bmiPaaAttenKommaFireSkalVaereUndervekt() {
        assertEquals(UNDERVEKT, bmiCalc.beregnVektklasse(18.4));
    }

    @Test
    public void bmiPaaAttenKommaFemSkalVaereNormalvekt() {
        assertEquals(NORMALVEKT, bmiCalc.beregnVektklasse(18.5));
    }
    
    //+ mange flere tester p� denne metoden
    
    @Test
    public void avrundingAvKomma45SkalVaereKomma5() {
        assertEquals(20.5, bmiCalc.rundAvTilEnDesimal(20.45), Double.MIN_VALUE);
    }

    @Test
    public void avrundingAvKomma44SkalVaereKomma4() {
        assertEquals(20.4, bmiCalc.rundAvTilEnDesimal(20.44), Double.MIN_VALUE);
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
