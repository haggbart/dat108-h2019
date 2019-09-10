package no.hvl.lph.dat108;

/*
 * En liten oppgave dere skulle pr�ve selv for � se om dere hadde
 * f�tt med dere hovedid�en med lambda-uttrykk.
 * 
 * Oppgaveteksten:
 * 
 * Lag en generell metode betingetUtskrift(...) som tar inn en streng 
 * og et (false | true) lambda-uttrykk og som skriver ut strengen kun 
 * hvis uttrykket er sant.
 * 
 * Lag en main(...)-metode som tester dette ut med et par ulike input, 
 * f.eks. krav om at stringen begynner p� "X" eller at den er lengre 
 * enn 3 tegn.
 */
public class F04c_betinget_utskrift {

	private static void betingetUtskrift(String s, StringBetingelse b) {
		if (b.erSann(s)) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		betingetUtskrift("Xi", s -> s.startsWith("X"));
		betingetUtskrift("Knut", s -> s.startsWith("X"));
		betingetUtskrift("Per", s -> s.length() > 3);
		betingetUtskrift("Anne", s -> s.length() > 3);
	}

}

@FunctionalInterface
interface StringBetingelse {
	boolean erSann(String s);
}

