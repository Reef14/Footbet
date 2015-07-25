package com.pl.iwach.footbetmanager;

import java.util.ArrayList;
import java.io.*;

public class Multiprogression implements Serializable {
	
	private double stanKonta, obrot, obrotCel, obrotProc, skonczoneZysk = 0 , aktualneWydatki = 0, kapital;
	private int aktywneProgresje = 0, skonczoneProgresje = 0;
	private ArrayList<Progression> progresje = new ArrayList<Progression>();;
	
	
	
	
	public Multiprogression(double kapital, double obrotCel) 
	{
		super();
		this.obrotCel = obrotCel;
		this.kapital = kapital;
	}
	
	
	
	@Override
	public String toString() {
		return "Multiprogression [stanKonta=" + stanKonta + ", obrot=" + obrot
				+ ", obrotCel=" + obrotCel + ", obrotProc=" + obrotProc
				+ ", skonczoneZysk=" + skonczoneZysk + ", aktualneWydatki="
				+ aktualneWydatki + ", kapital=" + kapital
				+ ", aktywneProgresje=" + aktywneProgresje
				+ ", skonczoneProgresje=" + skonczoneProgresje  + "]";
	}



	public void odswiexWartosci()
	{
		for( int i = 0; i < progresje.size(); i++)
		{
			obrot += progresje.get(i).getWydatki();
			if (progresje.get(i).getSkonczone()) {skonczoneZysk += progresje.get(i).getBilans();skonczoneProgresje++;} else {aktualneWydatki += progresje.get(i).getWydatki();aktywneProgresje++;}
		}
		
		stanKonta = kapital - aktualneWydatki+ skonczoneZysk;
		obrotProc = obrot / obrotCel * 100;
		
	}

	public void saveMultiprogression()
	{
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream("data.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(progresje);
	         out.close();
	         fileOut.close();
	         System.out.println("Dane multiprogresji zapisane w data.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public void loadMultiprogression()
	{
		try
	      {
	         FileInputStream fileIn = new FileInputStream("data.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         progresje = (ArrayList<Progression>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("No data to load.");
	         c.printStackTrace();
	         return;
	      }
		for( int i = 0; i < progresje.size(); i++)
		{
			System.out.println("Wczytano progresje dla: " + progresje.get(i).getDruzyna());

		}
		
	}

	public double getStanKonta() {
		return stanKonta;
	}

	public void setStanKonta(double stanKonta) {
		this.stanKonta = stanKonta;
	}

	public double getObrot() {
		return obrot;
	}

	public void setObrot(double obrot) {
		this.obrot = obrot;
	}

	public double getObrotProc() {
		return obrotProc;
	}

	public void setObrotProc(double obrotProc) {
		this.obrotProc = obrotProc;
	}

	public double getSkonczoneZysk() {
		return skonczoneZysk;
	}

	public void setSkonczoneZysk(double skonczoneZysk) {
		this.skonczoneZysk = skonczoneZysk;
	}

	public double getAktualneWydatki() {
		return aktualneWydatki;
	}

	public void setAktualneWydatki(double aktualneWydatki) {
		this.aktualneWydatki = aktualneWydatki;
	}

	public double getKapital() {
		return kapital;
	}

	public void setKapital(double kapital) {
		this.kapital = kapital;
	}

	public int getAktywneProgresje() {
		return aktywneProgresje;
	}

	public void setAktywneProgresje(int aktywneProgresje) {
		this.aktywneProgresje = aktywneProgresje;
	}

	public int getSkonczoneProgresje() {
		return skonczoneProgresje;
	}

	public void setSkonczoneProgresje(int skonczoneProgresje) {
		this.skonczoneProgresje = skonczoneProgresje;
	}

	public ArrayList<Progression> getProgresje() {
		return progresje;
	}

	public void setProgresje(ArrayList<Progression> progresje) {
		this.progresje = progresje;
	}

}
