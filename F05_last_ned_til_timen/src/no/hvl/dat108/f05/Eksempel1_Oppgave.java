package no.hvl.dat108.f05;

import java.util.Random;

public class Eksempel1_Oppgave {

	public static void main(String[] args) {
		/*
		 * Opprett og start 2 tr�der som kj�rer doSomeWildStuff() samtidig.
		 */
	}
	
	public static void doSomeWildStuff() {
		Random r = new Random();
		for (int i=1; i<=10; i++) {
				System.out.println(i);
			try {
				Thread.sleep(r.nextInt(100));
			} catch (InterruptedException e) {
			}
		}
	}
}
