package com.pl.iwach.footbetmanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Progression implements Serializable{
	
	private String druzyna;
	private int poziom;
	private double stawka, stawkaPoczatkowa = 0.5d, wydatki = 0.0d, bilans = 0.0d, zwrot = 0, stawkowanie = 1.52;
	private ArrayList<Mecz> mecz = new ArrayList<Mecz>();
	private Boolean skonczone = false, obstawione = false;
	
	
	
	public Progression(String druzyna) {
		super();
		this.druzyna = druzyna;
	}
	
	@Override
	public String toString() {
		return "Progression [druzyna=" + druzyna + ", poziom=" + poziom
				+ ", stawka=" + stawka + ", stawkaPoczatkowa="
				+ stawkaPoczatkowa + ", wydatki=" + wydatki + ", bilans="
				+ bilans + ", zwrot=" + zwrot + ", stawkowanie=" + stawkowanie
				+ ", mecz=" + mecz + ", skonczone=" + skonczone
				+ ", obstawione=" + obstawione + "]";
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
		poziom = mecz.size();
		stawka = stawkaPoczatkowa*Math.pow(stawkowanie,poziom-1);	
		wydatki +=  stawka;
		
		
		


	}
	
	public void dodajWynik(int poziom, int goleDom, int goleWyjazd)
	{
		if (!skonczone){
		Mecz tempMecz = new Mecz(mecz.get(poziom-1).getDruzynaA(), mecz.get(poziom-1).getDruzynaB(), mecz.get(poziom-1).getTermin(), mecz.get(poziom-1).getKurs(), goleDom, goleWyjazd);
		mecz.set(poziom - 1, tempMecz );
		if (goleDom == goleWyjazd) {skonczone = true;}
		if (skonczone) {bilans = stawka * mecz.get(poziom-1).getKurs() - wydatki;}
		else {bilans = (-1) * wydatki;}
		} else System.out.println("UWAGA! Progresja skończyła się na niższym poziomie.");
	}
	
	
	
	
	public void printBet()
	{
		System.out.println("Progresja dla drużyny: "+ getDruzyna());
		System.out.println();
		double aktualneWydatki=0, aktualnaStawka=0;
		zwrot= (bilans)/wydatki*100;
		
		for( int i = 0; i < mecz.size(); i++)
		{
			System.out.println(mecz.get(i));
			aktualnaStawka = stawkaPoczatkowa*Math.pow(stawkowanie,i);
			aktualneWydatki +=  aktualnaStawka;
			System.out.printf("Stawka %.2f\n", aktualnaStawka);	
			System.out.printf("Wydatki %.2f\n", aktualneWydatki);	
		}
		System.out.printf("\nBilans: %.2f", bilans);
		System.out.printf("\nZwrot: %.2f%%\n", zwrot);
//		System.out.printf("Stawka %.2f\n", stawka);
//		System.out.printf("Wydatki %.2f\n", wydatki);
		
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
