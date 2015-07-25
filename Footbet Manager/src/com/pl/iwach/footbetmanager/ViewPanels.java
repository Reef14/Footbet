package com.pl.iwach.footbetmanager;

import javax.swing.*;
import java.awt.*;

class ViewPanels extends JFrame
{

	JPanel p1,p2;
	Dimension d;

    public ViewPanels()
    {
        createAndShowGUI();
    }
    
    
	public double dwaMiejsca(double x) {
	    
    	x = x*100;
    	x = Math.round(x);
    	x = x /100;
		return x;
	}
    
    private void createAndShowGUI()
    {
        setTitle("Footbet Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // An empty panel with FlowLayout
        p1=new JPanel();
        
        // Panel with custom layout
        p2=new JPanel(new GridBagLayout());
        
        // Set some preferred size
        d=new Dimension(400,400);

        p1.setPreferredSize(d);
        p2.setPreferredSize(d);
        
        // Set some background
        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.DARK_GRAY);

        // Set some border
        // Here a line border of 5 thickness, dark gray color and rounded
        // edges
        p1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,5,true));
        
        // Set some tooltip text
        p1.setToolTipText("Panel 1");
        p2.setToolTipText("Panel 2");
        
        double kurs=3.2, stawkowanie=1.52, stawkaPoczatkowa=0.5, wydatki=0, zysk, yield;
	    int poziom, maxPoziom=15;
	    
	    Object dane[][] = new Object[maxPoziom][6];
	    
	    for (int i = 0; i < maxPoziom; i++) {
	    	

			dane[i][0]=i+1;
			dane[i][1]= dwaMiejsca(stawkaPoczatkowa*Math.pow(stawkowanie,i));
			wydatki +=  (double) dane[i][1];
			dane[i][2]=  dwaMiejsca(wydatki);
			dane[i][3]= dwaMiejsca((double) dane[i][1]*kurs - wydatki);
			dane[i][4]= dwaMiejsca((double) dane[i][3] /wydatki *100);
		}
	    

	    
	    Object columnNames[] = { "Poziom", "Stawka", "Wydatki", "Zysk", "Yield" };
	    JTable table = new JTable(dane, columnNames);
	    
	    p1.add(table);
        
        // Add panels
        add(p1);
        add(p2);
        
        setSize(800,800);
        setVisible(true);    
        pack();
        
        
    }
    
}
