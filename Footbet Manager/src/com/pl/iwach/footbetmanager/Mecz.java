package com.pl.iwach.footbetmanager;

import java.io.Serializable;
import java.util.Date;

public class Mecz implements Serializable {

	private String druzynaA, druzynaB;
	private Date termin;
	private int wynikA, wynikB;
	boolean skonczonyMecz = false;
	private double kurs;
	
	
	
	
	public Mecz(String druzynaA, String druzynaB, Date termin, double kurs) {
		super();
		this.druzynaA = druzynaA;
		this.druzynaB = druzynaB;
		this.termin = termin;
		this.kurs = kurs;
	}
	
	public Mecz(String druzynaA, String druzynaB, Date termin, double kurs, int wynikA, int wynikB) {
		super();
		this.druzynaA = druzynaA;
		this.druzynaB = druzynaB;
		this.termin = termin;
		this.kurs = kurs;
		this.wynikA = wynikA;
		this.wynikB = wynikB;
		this.skonczonyMecz = true;
	}
	
	
	@Override
	public String toString() {
		return "Mecz [druzynaA=" + druzynaA + ", druzynaB=" + druzynaB
				+ ", termin=" + termin + ", wynikA=" + wynikA + ", wynikB="
				+ wynikB + ", skonczonyMecz=" + skonczonyMecz + ", kurs="
				+ kurs + "]";
	}


	public String getDruzynaA() {
		return druzynaA;
	}
	public void setDruzynaA(String druzynaA) {
		this.druzynaA = druzynaA;
	}
	public String getDruzynaB() {
		return druzynaB;
	}
	public void setDruzynaB(String druzynaB) {
		this.druzynaB = druzynaB;
	}
	public Date getTermin() {
		return termin;
	}
	public void setTermin(Date termin) {
		this.termin = termin;
	}
	public int getWynikA() {
		return wynikA;
	}
	public void setWynikA(int wynikA) {
		this.wynikA = wynikA;
	}
	public int getWynikB() {
		return wynikB;
	}
	public void setWynikB(int wynikB) {
		this.wynikB = wynikB;
	}
	public boolean isSkonczonyMecz() {
		return skonczonyMecz;
	}
	public void setSkonczonyMecz(boolean skonczonyMecz) {
		this.skonczonyMecz = skonczonyMecz;
	}
	public double getKurs() {
		return kurs;
	}
	public void setKurs(double kurs) {
		this.kurs = kurs;
	}
	
	
}
