package no.hvl.dat108.f06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Eksempel2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		/*
		 * Dette eksemplet viser hvordan vi på deklarativ måte
		 * kan lage en liste av etternavnene til de personene
		 * som er over 50 år. Litt som med SQL.
		 */

		// "Gamlemåten"
//		List<String> etternavnene = new ArrayList<>();
//		for (Person p : people) {
//			if (p.getAge() > 50) {
//				etternavnene.add(p.getLastName());
//			}
//		}
//		System.out.println(etternavnene);
		
		// "Nyemåten"
		List<String> etternavnene = people.stream() // FROM people
				.filter(p -> p.getAge() > 50) 		// WHERE age > 50
//				.map(p -> p.getLastName()) 			// SELECT lastName
// alternativt
				.map(Person::getLastName)
				.collect(Collectors.toList());
		
		etternavnene.forEach(System.out::println);
	
	}
}




