package com.pl.iwach.footbetmanager;

import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Progression progresja = new Progression("Śląsk");
		progresja.dodajZaklad(3.2, "Wisła", true, 1,1,2015,15,00);
		progresja.dodajWynik(1, 2, 1);
		progresja.dodajZaklad(3.4, "Lech", false,1,5,2015,15,00);
		progresja.dodajWynik(2, 1, 2);
		progresja.dodajZaklad(3.2, "Legia", true, 1,5,2015,15,00);
		progresja.dodajWynik(3, 2, 2);
		progresja.printBet();
		
		Progression progresja2 = new Progression("Korona");
		progresja2.dodajZaklad(3.2, "Pogoń", true, 1,5,2015,15,00);
		progresja2.dodajWynik(1, 2, 1);
		progresja2.dodajZaklad(3.4, "Ruch", false,1,5,2015,15,00);
		progresja2.dodajWynik(2, 1, 2);
		progresja2.printBet();
		
		ArrayList<Progression> progresje = new ArrayList<Progression>();
		progresje.add(progresja);
		progresje.add(progresja2);
		Multiprogression multiprogresja = new Multiprogression();
		multiprogresja.setProgresje(progresje);
//		multiprogresja.saveMultiprogression();
//		multiprogresja.loadMultiprogression();
		
		


	}


}
