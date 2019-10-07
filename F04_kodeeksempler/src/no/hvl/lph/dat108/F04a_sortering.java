package no.hvl.lph.dat108;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class F04a_sortering {

	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList(
				"Hallo", "blabla", "knut", "Per");
		
		//1 - Sortere i "naturlig" orden, dvs. via String.compareTo()
		Collections.sort(listen);
		System.out.println(listen);
		
		//2 - Sortere i hht. Comparator, se AlfabetiskComparator nederst
		Collections.sort(listen, new AlfabetiskComparator());
		System.out.println(listen);
		
		//3 - Anonym Comparator-klasse i stedet for navngitt som i 2) 
		Collections.sort(listen, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.toUpperCase().compareTo(s2.toUpperCase());
			}
		});
		System.out.println(listen);
		
		// NÅ KOMMER DET SOM ER NYTT ...
		
		//4 - Bruke lambda-uttrykk for å representere en Comparator
		Collections.sort(listen, (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()));
		System.out.println(listen);
		
		//5 Sortere på strenglengde
		Collections.sort(listen, (s1, s2) -> s1.length()- s2.length());
		System.out.println(listen);
		
		//6 Lagre lambda-uttrykk i en variabel. (f.eks. sortere baklengs på strenglengde)
		Comparator<String> baklengsPaaLengde = (s1, s2) -> s2.length() - s1.length();
		Collections.sort(listen, baklengsPaaLengde);
		System.out.println(listen);
	}
}

class AlfabetiskComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.toUpperCase().compareTo(s2.toUpperCase());
	}
}

