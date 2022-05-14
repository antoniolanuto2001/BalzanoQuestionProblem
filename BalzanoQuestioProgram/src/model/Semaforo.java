package model;

import java.awt.Dimension;


import javax.swing.JPanel;
import gui.GraficaSemaforo;
import javax.swing.JButton;

public class Semaforo extends JPanel{
	
	GraficaSemaforo light = new GraficaSemaforo();
	
	public Semaforo()
	{
		//160-260 default settings for size
		light.setPreferredSize(new Dimension(160,260));
		add(light);
	}
}
