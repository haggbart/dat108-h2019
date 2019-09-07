package no.hvl.dat108.f06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Eksempel5 {
	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		// Summen av aldre
		int sumAlder = people.stream()
				.map(p -> p.getAge())
//				.reduce(0, (sum, a) -> sum + a);
//Alternativt
				.reduce(0, Integer::sum);
		
		System.out.println(sumAlder);
		
		//Samme, men droppe map
		int sumAlder2 = people.stream()
				.reduce(0, (sum, p) -> sum + p.getAge(), Integer::sum);
		System.out.println(sumAlder2);
		
		// Alle initialene
//		String initialer = people.stream()
//				.map(p -> "" + p.getFirstName().charAt(0) 
//						+ p.getLastName().charAt(0))
//				.reduce("", (total, s) -> total + s + " ");
		
//Alternativt
		String initialer = people.stream()
				.map(p -> "" + p.getFirstName().charAt(0) 
						+ p.getLastName().charAt(0))
				.collect(Collectors.joining(" "));
		
		System.out.println(initialer);
	}	

}
