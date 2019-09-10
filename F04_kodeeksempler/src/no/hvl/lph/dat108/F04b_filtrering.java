package no.hvl.lph.dat108;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F04b_filtrering {

	public static void main(String[] args) {
		
		List<Integer> listen = Arrays.asList(-4, 9, 2, 7, 6, 0);
		List<Integer> filtrertListe;
		System.out.println(listen);
		
		//1 - På "gamlemåten" der Betingelse er representert ved en konkret klasse
		filtrertListe = filter(listen, new PartallBetingelse());
		System.out.println(filtrertListe);
		
		//2 - Lambdauttrykk
		filtrertListe = filter(listen, x -> x % 2 == 0);
		System.out.println(filtrertListe);
		
		//3 - Enda et eksempel
		filtrertListe = filter(listen, x -> x > 0);
		System.out.println(filtrertListe);
		
		//4 - Enda et eksempel. Vi ser at eksmplene ligner. Kan vi generalisere?
		filtrertListe = filter(listen, x -> x > 7);
		System.out.println(filtrertListe);
		
		//5 - storreEnn er en metode som returnerer et (dynamisk) lambda-uttrykk
		filtrertListe = filter(listen, storreEnn(5));
		System.out.println(filtrertListe);

	}

	// Et hjemmesnekret filter for filtrering av heltall
	public static List<Integer> filter(List<Integer> liste, Betingelse b) {
		
		List<Integer> resultat = new ArrayList<>();
		for (int tall : liste) {
			if (b.erOppfylt(tall)) {
				resultat.add(tall);
			}
		}
		return resultat;
	}
	
	// En metode som returnerer et dynamisk lambdauttrykk
	public static Betingelse storreEnn(int grense) {
		return tall -> tall > grense; //Et kall på storreEnn(5) returnerer tall -> tall > 5;
	}
}

// En betingelse vi bruker i filteret for å bestemme om et tall er med eller ikke
@FunctionalInterface
interface Betingelse {
	boolean erOppfylt(int tall);
}

// En implementasjon av Betingelse til bruk i filter()
class PartallBetingelse implements Betingelse {
	@Override
	public boolean erOppfylt(int tall) {
		return tall % 2 == 0;
	}
}

