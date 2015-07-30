package com.pl.iwach.footbetmanager;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
		
		Progression progresja3 = new Progression("Widzew");
		progresja3.dodajZaklad(3.2, "ŁKS", true, 1,5,2015,15,00);
		progresja3.dodajWynik(1, 2, 1);
		progresja3.dodajZaklad(3.5, "Lechia", false,1,5,2015,15,00);
		progresja3.dodajWynik(2, 3, 3);
		progresja3.printBet();
		
		Progression progresja4 = new Progression("Legia","http://fcstats.com/club,matches,legia-warszawa,470.php");
		progresja4.dodajZaklad(4.2, "ŁKS", true, 1,5,2015,15,00);
		progresja4.dodajWynik(1, 2, 3);
		progresja4.dodajZaklad(3.5);
		progresja4.dodajWynik(2, 4, 4);
		progresja4.printBet();
		
		ArrayList<Progression> progresje = new ArrayList<Progression>();
		progresje.add(progresja);
		progresje.add(progresja2);
		progresje.add(progresja3);
		progresje.add(progresja4);
		
		Multiprogression multiprogresja = new Multiprogression(100,300);
		multiprogresja.setProgresje(progresje);
		multiprogresja.odswiexWartosci();
		System.out.println(multiprogresja.toString());
//		multiprogresja.saveMultiprogression();
//		multiprogresja.loadMultiprogression();
		
		new ViewPanels(multiprogresja);
		
		


	}


}
