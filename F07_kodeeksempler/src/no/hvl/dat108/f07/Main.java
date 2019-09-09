package no.hvl.dat108.f07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
	
	/*
	 * Dette eksemplet ble gjennomg�tt i DAT108-timen 9. september 2019.
	 * Form�let var � vise en litt mer kompleks datastruktur, litt mer
	 * komplekse sp�rsm�l, og bruk av Optional og flatmap().
	 */

	public static void main(String[] args) throws Exception {
		
		List<Utvikler> utviklere = Arrays.asList(
				new Utvikler("Arne", new HashSet<>(Arrays.asList("Java", "C"))),
				new Utvikler("Pere", new HashSet<>(Arrays.asList("Javascript", "C++"))),
				new Utvikler("Knut", new HashSet<>(Arrays.asList("Java"))),
				new Utvikler("Anne", new HashSet<>(Arrays.asList("Haskell", "C#", "Python"))),
				new Utvikler("Emma", new HashSet<>(Arrays.asList("Clojure", "Ruby", "C"))),
				new Utvikler("Lise", new HashSet<>(Arrays.asList("Java", "C"))));

		
		System.out.println("\nEn oversikt over hvilke utviklere som kan Java:");
		

		System.out.println("\nNavnet p� en utvikler som kan C#, eller \"INGEN\" om ingen kan C#:");
		

		System.out.println("\nEn sortert liste over alle programmeringsspr�kene utviklerne kan:");
		

		System.out.println("\nHvilket spr�k flest utviklere kan (finner ett av dem):");

		
		System.out.println("\nHvilke(t) spr�k flest utviklere kan hvis det er flere:");

		
	}
}





