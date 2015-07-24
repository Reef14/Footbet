package com.pl.iwach.footbetmanager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Progression progresja = new Progression("Śląsk");
		progresja.dodajZaklad(3.2, "Wisła", true);
		progresja.dodajWynik(1, 2, 1);
		progresja.dodajZaklad(3.4, "Lech", false);
		progresja.dodajWynik(2, 1, 2);
		progresja.dodajZaklad(3.2, "Legia", true);
		progresja.dodajWynik(3, 2, 2);
		progresja.printBet();
		
		Progression progresja2 = new Progression("Korona");
		progresja.dodajZaklad(3.2, "Pogoń", true);
		progresja.dodajWynik(1, 2, 1);
		progresja.dodajZaklad(3.4, "Ruch", false);
		progresja.dodajWynik(2, 1, 2);
		progresja.printBet();
		
		ArrayList<Progression> progresje = new ArrayList<Progression>();
		progresje.add(progresja);
		progresje.add(progresja2);
		Multiprogression multiprogresja = new Multiprogression();
		multiprogresja.setProgresje(progresje);
//		multiprogresja.saveMultiprogression();
//		multiprogresja.loadMultiprogression();
		
		
//		try {
//		    FileOutputStream outputStream=new FileOutputStream("add.ser");
//		    ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
//		    objectOutputStream.writeObject(progresja);
//		} catch (FileNotFoundException e) {
//		    e.printStackTrace();
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}


	}


}
