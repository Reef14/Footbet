package com.pl.iwach.footbetmanager;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserNextMatchInfo {
	

	private String druzynaA, druzynaB;
	private Date termin;
	int wskaznikMeczu=0;

    
    public ParserNextMatchInfo(String url){
        Document doc;
        try {
        	doc = Jsoup.connect(url).get();

        	Elements home = doc.getElementsByClass("teamHomeName");
        	Elements away = doc.getElementsByClass("teamAwayName");
        	Elements wynik = doc.getElementsByClass("matchResult");
        	Elements data = doc.getElementsByClass("dateSeparator");
        	
        	for (int i = 0; i < away.size(); i++) {
				if (wynik.get(i).text().length() > 2) wskaznikMeczu++;
			}
  
        	
        	druzynaA = home.get(wskaznikMeczu).text().replaceAll("[\\d()]", "").trim();
        	druzynaB = away.get(wskaznikMeczu).text().replaceAll("[\\d()]", "").trim();
        	String string = data.get(wskaznikMeczu).text();
        	String[] parts = string.split("-");
        	termin = ustawTerminMeczu(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));  

        	

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public Date ustawTerminMeczu(int dzien, int miesiac, int rok)
	{
        Calendar cal = Calendar.getInstance();
        cal.set(rok, miesiac-1, dzien, 0, 0, 0);
        return cal.getTime();
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


	public int getWskaznikMeczu() {
		return wskaznikMeczu;
	}


	public void setWskaznikMeczu(int wskaznikMeczu) {
		this.wskaznikMeczu = wskaznikMeczu;
	}


	@Override
	public String toString() {
		return "ParserNextMatchInfo [druzynaA=" + druzynaA + ", druzynaB="
				+ druzynaB + ", termin=" + termin + ", wskaznikMeczu="
				+ wskaznikMeczu + "]";
	}
}
