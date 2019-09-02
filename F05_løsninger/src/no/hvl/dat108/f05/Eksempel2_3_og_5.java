package no.hvl.dat108.f05;
/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//@FunctionalInterface
//interface Betingelse {
//	boolean erOppfylt(Person p);
//}

public class Eksempel2_3_og_5 {
	
//	public static void printAll(List<Person> liste) {
//		for (Person p : liste) {
//			System.out.println(p);
//		}
//	}
	
//	public static void printLastNameStartsWithC(List<Person> liste) {
//		for (Person p : liste) {
//			if (p.getLastName().startsWith("C")) {
//				System.out.println(p);
//			}
//		}
//	}

//	public static void printConditionally(List<Person> liste, 
//			Predicate<Person> b) {
//		for (Person p : liste) {
//			if (b.test(p)) {
//				System.out.println(p);
//			}
//		}
//	}
	
	public static void doConditionally(List<Person> liste, 
			Consumer<Person> consumer, Predicate<Person> predicate) {
		for (Person p : liste) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// 1: Sorter personene på etternavn.
		Collections.sort(people, 
				(p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// 2: Skriv ut alle personene, én linje per person. 
		// 		Lag en egen hjelpemetode printAll(...) som gjør dette.
		
//		printAll(people);
// kan til slutt erstattes av
		doConditionally(people, System.out::println, p -> true);
		System.out.println("--------------------------------------------");
		
		// 3: Skriv ut alle personene som har etternavn som begynner på C.
		//		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gjør dette. 
		
//		printLastNameStartsWithC(people);
// kan til slutt erstattes av
		doConditionally(people, System.out::println, p -> p.getLastName().startsWith("C"));
		System.out.println("--------------------------------------------");
		
		// 4: Skriv ut alle personene som har fornavn som begynner på C.
		//		Vi ser nå at det er tungvint å lage én utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gjør jobben i stedet. Denne tar inn listen + et lambdauttrykk.
		
//		printConditionally(people, p -> p.getFirstName().startsWith("C"));
// kan til slutt erstattes av
		doConditionally(people, System.out::println, p -> p.getFirstName().startsWith("C"));
		System.out.println("--------------------------------------------");
		
		// 5: Skriv ut ALLE personene ved å bruke printConditionally(...)
		
//		printConditionally(people, p -> true);
// kan til slutt erstattes av
		doConditionally(people, System.out::println, p -> true);
		System.out.println("--------------------------------------------");
		
		//Eksempel3 ...
		doConditionally(people, p -> System.out.println(p),	p -> p.getAge() > 50);
		System.out.println("--------------------------------------------");
		
		//Eksempel5 ...
		doConditionally(people, System.out::println, p -> p.getAge() > 50);
		System.out.println("--------------------------------------------");
		
        Collections.sort(people, Eksempel2_3_og_5::aldersDiff);
		doConditionally(people, System.out::println, p -> true);
        
	}
	
	public static int aldersDiff(Person p1, Person p2) {
		return p1.getAge() - p2.getAge();
	}
}
