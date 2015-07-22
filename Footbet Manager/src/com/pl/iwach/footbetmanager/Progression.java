package com.pl.iwach.footbetmanager;

import java.util.ArrayList;
import java.util.Date;

public class Progression {
	
	private String druzyna;
	private int poziom = 1;
	private double stawka = 0.5d, wydatki = 0.0d, bilans = 0.0d, zwrot = 0, stawkowanie = 1.52;
	private ArrayList<Mecz> mecz = new ArrayList<Mecz>();
	private Boolean skonczone = false, obstawione = false;
	
	
	
	public Progression(String druzyna) {
		super();
		this.druzyna = druzyna;
	}
	
	public void dodajZaklad(double kurs, String przecinwik, boolean meczDomowy)
	{
		Date date = new Date();
		Mecz nowyMecz;
		
		if (meczDomowy)
			{
				 nowyMecz = new Mecz(druzyna, przecinwik, date, kurs);
			}
		else 
			{
				 nowyMecz = new Mecz(przecinwik, druzyna, date, kurs);
			}
		mecz.add(nowyMecz);
		//stawka = Math.pow(stawkowanie, poziom);
		stawka = stawka*Math.pow(stawkowanie,poziom-1);	
		poziom = mecz.size();
		wydatki +=  stawka;
		
		if (skonczone) {bilans = stawka * kurs - wydatki;}
		else {bilans = (-1) * wydatki;}

	}
	
	public void dodajWynik(int poziom, int goleDom, int goleWyjazd)
	{
		Mecz tempMecz = new Mecz(mecz.get(poziom-1).getDruzynaA(), mecz.get(poziom-1).getDruzynaB(), mecz.get(poziom-1).getTermin(), mecz.get(poziom-1).getKurs(), goleDom, goleWyjazd);
		mecz.set(poziom - 1, tempMecz );
	}
	
	public void printBet()
	{
		System.out.println("Progresja dla drużyny: "+ getDruzyna());
		System.out.println();
		for( int i = 0; i < mecz.size(); i++)
		{
			System.out.println(mecz.get(i));
			System.out.println("Stawka: " + stawka);
			System.out.println("Wydatki: " + wydatki);
			System.out.printf("%.3f", wydatki);
		}
		
	}
	
	
	public String getDruzyna() {
		return druzyna;
	}
	public void setDruzyna(String druzyna) {
		this.druzyna = druzyna;
	}
	public int getPoziom() {
		return poziom;
	}
	public void setPoziom(int poziom) {
		this.poziom = poziom;
	}
	public double getStawka() {
		return stawka;
	}
	public void setStawka(double stawka) {
		this.stawka = stawka;
	}
	public double getWydatki() {
		return wydatki;
	}
	public void setWydatki(double wydatki) {
		this.wydatki = wydatki;
	}
	public double getBilans() {
		return bilans;
	}
	public void setBilans(double bilans) {
		this.bilans = bilans;
	}
	public double getZwrot() {
		return zwrot;
	}
	public void setZwrot(double zwrot) {
		this.zwrot = zwrot;
	}

	public double getStawkowanie() {
		return stawkowanie;
	}
	public void setStawkowanie(double stawkowanie) {
		this.stawkowanie = stawkowanie;
	}

	public Boolean getSkonczone() {
		return skonczone;
	}
	public void setSkonczone(Boolean skonczone) {
		this.skonczone = skonczone;
	}
	public Boolean getObstawione() {
		return obstawione;
	}
	public void setObstawione(Boolean obstawione) {
		this.obstawione = obstawione;
	}

}
