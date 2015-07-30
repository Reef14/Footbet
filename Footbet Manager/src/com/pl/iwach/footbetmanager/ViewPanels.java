package com.pl.iwach.footbetmanager;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

class ViewPanels extends JFrame
{

	JPanel p1,p2,p3,p4;
	Dimension d;
	Multiprogression multiprogresja;

    public ViewPanels(Multiprogression multiprogresja)
    {
        this.multiprogresja = multiprogresja;
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
        
        p1=viewPanelStakeTable();
        p2=viewPanelActiveProgressions();
        p3=viewPanelFinishedProgressions();
        
        add(p1);
        add(p2);
        add(p3);
        
       
        setSize(1000,1000);
        setVisible(true);    
        pack();
        
        JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuPlik = new JMenu("Plik");
		JMenuItem mntmZapisz = new JMenuItem("Zapisz");
		JMenuItem mntmWczytaj = new JMenuItem("Wczytaj");
		JMenuItem mntmWyjdz = new JMenuItem("Wyjdź");
		
		menuBar.add(menuPlik);
		menuPlik.add(mntmZapisz);
		menuPlik.add(mntmWczytaj);
		menuPlik.add(mntmWyjdz);
		
		JMenu menuWidok = new JMenu("Widok");
	    ButtonGroup widokInterfejsGrupa = new ButtonGroup();
	    JRadioButtonMenuItem rbInterfejs1 = new JRadioButtonMenuItem("Interfejs 1", true);
	    JRadioButtonMenuItem rbInterfejs2 = new JRadioButtonMenuItem("Interfejs 2");
	    JRadioButtonMenuItem rbInterfejs3 = new JRadioButtonMenuItem("Interfejs 3");
	    JRadioButtonMenuItem rbInterfejs4 = new JRadioButtonMenuItem("Interfejs 4");
	    widokInterfejsGrupa.add(rbInterfejs1);
	    widokInterfejsGrupa.add(rbInterfejs2);
	    widokInterfejsGrupa.add(rbInterfejs3);
	    widokInterfejsGrupa.add(rbInterfejs4);
		
		menuBar.add(menuWidok);
	    menuWidok.add(rbInterfejs1);
	    menuWidok.add(rbInterfejs2);
	    menuWidok.add(rbInterfejs3);
	    menuWidok.add(rbInterfejs4);

		JMenu menuOpcje= new JMenu("Opcje");
		JMenuItem mntmOpcjePreferencje = new JMenuItem("Preferencje");
		JMenuItem mntmOpcjeOProgramie= new JMenuItem("O programie");
		
		menuBar.add(menuOpcje);
		menuOpcje.add(mntmOpcjePreferencje);
		menuOpcje.add(mntmOpcjeOProgramie);
    }
    
    public JPanel viewPanelStakeTable()
    {
        // An empty panel with FlowLayout
        JPanel panel=new JPanel();
        // Set some preferred size
        d=new Dimension(500,500);
        panel.setPreferredSize(d);
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,5,true));
        // Set some tooltip text
        panel.setToolTipText("Panel Stake Table");
        
        double kurs=3.2, stawkowanie=1.52, stawkaPoczatkowa=0.5, wydatki=0, zysk, yield;
	    int poziom, maxPoziom=20;
	    
	    Object dane[][] = new Object[maxPoziom][5];
	    
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
	    JScrollPane scrollPane = new JScrollPane(table);
	    //table.setFillsViewportHeight(true); 
	    panel.add(scrollPane);
	     return panel;
    }
    
    public JPanel viewPanelFinishedProgressions()
    {
        // An empty panel with FlowLayout
        JPanel panel=new JPanel();
        // Set some preferred size
        d=new Dimension(500,500);
        panel.setPreferredSize(d);
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,5,true));
        // Set some tooltip text
        panel.setToolTipText("Panel Finished Progressions");
        
	    
	    int maxPoziom=multiprogresja.getSkonczoneProgresje();
	    
	    Object dane[][] = new Object[maxPoziom][5];
	    
	    ArrayList<Progression> tempProgresje = new ArrayList<Progression>();
	    
	    for (int i = 0; i < multiprogresja.getProgresje().size(); i++) 
	    {
	    	if (multiprogresja.getProgresje().get(i).getSkonczone()) { tempProgresje.add(multiprogresja.getProgresje().get(i));}			
		}
	    
	    
	    for (int i = 0; i < maxPoziom; i++) {
			dane[i][0]=i+1;
			dane[i][1]= tempProgresje.get(i).getDruzyna();
			dane[i][2]=  tempProgresje.get(i).getPoziom();
			dane[i][3]= dwaMiejsca(tempProgresje.get(i).getBilans());
			dane[i][4]= dwaMiejsca(tempProgresje.get(i).getZwrot());
		}
    
	    Object columnNames[] = { "Lp.", "Drużyna", "Poziom", "Zysk", "Yield" };
	    JTable table = new JTable(dane, columnNames);
	    JScrollPane scrollPane = new JScrollPane(table); 
	    panel.add(scrollPane);
	     return panel;
    }

    public JPanel viewPanelActiveProgressions()
    {
        // An empty panel with FlowLayout
        JPanel panel=new JPanel();
        // Set some preferred size
        d=new Dimension(500,500);
        panel.setPreferredSize(d);
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,5,true));
        // Set some tooltip text
        panel.setToolTipText("Panel Active Progressions");
        
	    
	    int maxPoziom=multiprogresja.getAktywneProgresje();
	    
	    Object dane[][] = new Object[maxPoziom][4];
	    
	    ArrayList<Progression> tempProgresje = new ArrayList<Progression>();
	    
	    for (int i = 0; i < multiprogresja.getProgresje().size(); i++) 
	    {
	    	if (!multiprogresja.getProgresje().get(i).getSkonczone()) { tempProgresje.add(multiprogresja.getProgresje().get(i));}			
		}
	    
	    
	    for (int i = 0; i < maxPoziom; i++) {
			dane[i][0]=i+1;
			dane[i][1]= tempProgresje.get(i).getDruzyna();
			dane[i][2]=  tempProgresje.get(i).getPoziom();
			dane[i][3]= dwaMiejsca(tempProgresje.get(i).getWydatki());
		}
    
	    Object columnNames[] = { "Lp.", "Drużyna", "Poziom", "Wydatki"};
	    JTable table = new JTable(dane, columnNames);
	    JScrollPane scrollPane = new JScrollPane(table); 
	    panel.add(scrollPane);
	     return panel;
    }
}
