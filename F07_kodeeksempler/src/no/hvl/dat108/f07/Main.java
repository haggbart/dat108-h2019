package no.hvl.dat108.f07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	
	/*
	 * Dette eksemplet ble gjennomgått i DAT108-timen 9. september 2019.
	 * Formålet var å vise en litt mer kompleks datastruktur, litt mer
	 * komplekse spørsmål, og bruk av Optional og flatmap().
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
		List<Utvikler> deSomKanJava = utviklere.stream()
				.filter(u -> u.getSpraak().contains("Java"))
				.collect(Collectors.toList());
		deSomKanJava.forEach(System.out::println);
		

		System.out.println("\nNavnet på en utvikler som kan C#, eller \"INGEN\" om ingen kan C#:");
		String navnPaaEnSomKanCSharp = utviklere.stream()
				.filter(u -> u.getSpraak().contains("C#"))
				.map(u -> u.getNavn())
				.findAny()
				.orElse("INGEN");
		System.out.println(navnPaaEnSomKanCSharp);
		

		System.out.println("\nEn sortert liste over alle programmeringsspråkene utviklerne kan:");
		List<String> progSpraak = utviklere.stream()
				.map(u -> u.getSpraak())
				.flatMap(s -> s.stream())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println(progSpraak);
		

		System.out.println("\nHvilket språk flest utviklere kan (finner ett av dem):");
		String favorittspraak = utviklere.stream()
				.flatMap(u -> u.getSpraak().stream())
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream()
				.max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.orElseThrow(() -> new Exception())
				.getKey();
		System.out.println(favorittspraak);

		
		System.out.println("\nHvilke(t) språk flest utviklere kan hvis det er flere:");
		Map<String, Long> frekvensMap = utviklere.stream()
				.flatMap(u -> u.getSpraak().stream())
				.collect(Collectors.groupingBy(x->x, Collectors.counting()));
		Long maksAntall = frekvensMap.values().stream()
				.max(Long::compareTo).orElse((long) 0);
		List<String> popSpraakListe = frekvensMap.entrySet().stream()
				.filter(e -> e.getValue().equals(maksAntall))
				.map(e -> e.getKey())
				.collect(Collectors.toList());
		System.out.println(popSpraakListe);
	}
}





