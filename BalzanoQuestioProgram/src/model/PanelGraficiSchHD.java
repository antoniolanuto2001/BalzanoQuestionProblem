package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGraficiSchHD extends JPanel{

	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=1100, h=118;//salvo dimensioni della finestra in delle variabili per renderle pi� facili da utilizzare e da modificare
	float intervalloX, intervalloY;
   	static public float a=30;
	
   	
   	public void paintComponent(Graphics g){

	super.paintComponent(g); 

   	}
	
}
