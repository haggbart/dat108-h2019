package no.hvl.dat108.f05;
/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.Arrays;
import java.util.List;

public class Eksempel2_Oppgave {
	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// 1: Sorter personene p� etternavn.

		
		// 2: Skriv ut alle personene, �n linje per person. 
		// 		Lag en egen hjelpemetode printAll(...) som gj�r dette. 
		
		
		// 3: Skriv ut alle personene som har etternavn som begynner p� C.
		//		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gj�r dette. 
		
		
		// 4: Skriv ut alle personene som har fornavn som begynner p� C.
		//		Vi ser n� at det er tungvint � lage �n utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gj�r jobben i stedet. Denne tar inn listen + et lambdauttrykk.
		
		// 5: Skriv ut ALLE personene ved � bruke printConditionally(...)
	}
}
