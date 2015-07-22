package com.pl.iwach.footbetmanager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Progression progresja = new Progression("Śląsk");
		progresja.dodajZaklad(3.2, "Wisła", true);
		progresja.dodajWynik(1, 2, 4);
		progresja.dodajZaklad(3.4, "Lech", false);
		progresja.printBet();

	}

}
