package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

public class PanelGraficiSchHD extends JPanel{

	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=1100, h=118;//salvo dimensioni della finestra in delle variabili per renderle piï¿½ facili da utilizzare e da modificare
	float intervalloX, intervalloY;
   	static public float a=30;
	
   	
   	public void paintComponent(Graphics g){

	super.paintComponent(g); 

   	}
   	
   	public void resetGrafico(Graphics g){

   	}
   	
   	public void disegnaSoluzioneFCFS(Graphics g, int[] numeriFCFS, int nc, double distanzaFIFO, int[] successione) {
   		/*
   		for(int l=0;l<numeriFCFS.length;l++) {   
    		g.setColor(Color.black);
			g.drawLine(0,5,2000,5);
		}
   		
   		for(int l=0;l<numeriFCFS.length;l++) {   
    		g.setColor(Color.black);
    		if(l+1<numeriFCFS.length)
			g.drawLine(numeriFCFS[l],3+15*l,numeriFCFS[l+1],3+15*(l+1));
		}
   		
		g.setColor(Color.blue);

   		for(int l=0;l<numeriFCFS.length;l++) {   
    		g.drawString("●",numeriFCFS[l]-5,8+15*l);
    					//92-l*15);
    	}*/
   	}
	
}
