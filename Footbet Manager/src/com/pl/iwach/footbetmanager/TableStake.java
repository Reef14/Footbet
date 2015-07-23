package com.pl.iwach.footbetmanager;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableStake {
	public static void main(String args[]) {
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    double kurs=3.2, stawkowanie=1.52, stawkaPoczatkowa=0.5, wydatki=0, zysk, yield;
	    int poziom, maxPoziom=15;
	    
	    Object dane[][] = new Object[maxPoziom][6];
	    
	    for (int i = 0; i < maxPoziom; i++) {
	    	
			dane[i][0]=i+1;
			dane[i][1]= stawkaPoczatkowa*Math.pow(stawkowanie,i);
			wydatki +=  (double) dane[i][1];
			dane[i][2]= wydatki;
			dane[i][3]= (double) dane[i][1]*kurs - wydatki;
			dane[i][4]= (double) dane[i][3] /wydatki *100;
		}
	    
	    
	    
	    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
	        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
	    Object columnNames[] = { "Poziom", "Stawka", "Wydatki", "Zysk", "Yield" };
	    JTable table = new JTable(dane, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setSize(300, 150);
	    frame.setVisible(true);

	  }
}


