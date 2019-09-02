package no.hvl.dat108.f05;

public class Eksempel4 {
	
	public static Runnable halloRunnable(String id) {
		return () -> System.out.println("Hallo " + id);
	}
	
	public static void main(String[] args) {
		
		//Lage en runnable som sier Hallo
		//Lage og kj�re 2 tr�der med denne runnable-en
		//Skulle �nske at de to tr�dene ogs� skriver ut tr�d-id-en.
		
		//L�sning: M� lage en "dynamisk" lambda, dvs. lage en metode som
		//tar en parameter, og som returnerer en lambda basert p� denne 
		//parameteren. Se �verst.
		
		Thread t1 = new Thread(halloRunnable("T1"), "T1");
		Thread t2 = new Thread(halloRunnable("T2"), "T2");
		
		t1.start();
		t2.start();
	}
		
}
