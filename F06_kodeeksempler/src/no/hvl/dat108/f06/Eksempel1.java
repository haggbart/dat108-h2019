package no.hvl.dat108.f06;

import java.util.Arrays;
import java.util.List;

public class Eksempel1 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		/*
		 * Dette er det første eksemplet om streams.
		 * Vi ser hvordan vi kan skrive ut alle med fornavn
		 * som begynner på "C".
		 */

		// "Gamlemåten"
//		for (Person p : people) {
//			if(p.getFirstName().startsWith("C")) {
//				System.out.println(p);
//			}
//		}
		
		// "Nyemåten"
		people.stream()
				.filter(p -> p.getFirstName().startsWith("C"))
				.forEach(System.out::println);

	}

}




