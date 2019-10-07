package no.hvl.dat108.f06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Eksempel4 {

	public static void main(String[] args) {
		
		/*
		 * Dette eksemplet viser en del vanlige
		 * intermediate operations.
		 */

		//Skrive ut alle partall i området [1,10>
		IntStream.range(1,10)
				.filter(i -> i % 2 == 0)
				.forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		
		//Skrive ut kvadratet av alle tallene området [1,10>
		IntStream.range(1,10)
				.map(x -> x * x)
				.forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		
		//For en strøm av tallene 100, 103, 106, 109, ...
		//		skriv ut de 10 første som er delelig med 4
		Stream.iterate(100, x -> x + 3)
				.filter(x -> x % 4 == 0)
				.limit(10)
				.forEach(x -> System.out.print(x + " "));
				
		System.out.println();
		
		//For en strøm av strenger skriv dem ut sortert uten duplikater
		Stream.of("A", "X", "A", "B", "F", "P", "X")
				.distinct()
				.sorted()
				.forEach(x -> System.out.print(x + " "));
	}

}




