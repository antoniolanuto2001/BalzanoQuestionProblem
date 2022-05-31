package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGraficiSchHD extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=1000, h=145;//salvo dimensioni della finestra in delle variabili per renderle piÃ¯Â¿Â½ facili da utilizzare e da modificare

	
   	
   	public void paintComponent(Graphics g){

	super.paintComponent(g); 

   	}
   	
   	public void resetGrafico(Graphics g){

   	}
   	
   	public void disegnaSoluzioneFCFS(Graphics g, int[] numeriFCFS, int nc, double distanzaFIFO, int[] successione) {
   		/*if(nc==50){
   			g.setColor(Color.black);
   			g.drawLine(0,12,1000,12);
   			g.setColor(Color.blue);
   			for(int i=0;i<successione.length;i++) {
   				g.drawString(String.valueOf(successione[i]),successione[i]*20,10);
   				g.drawLine(successione[i]*20,5,successione[i]*20,7);
   			}
   		}
   		if(nc==100){
   			g.setColor(Color.black);
   			g.drawLine(0,12,1000,12);
   			g.setColor(Color.blue);
   			for(int i=0;i<successione.length;i++) {
   				g.drawString(String.valueOf(successione[i]),successione[i]*10,10);
   				g.drawLine(successione[i]*10,5,successione[i]*10,7);
   			}
   		}
   		if(nc==200){
   			g.setColor(Color.black);
   			g.drawLine(0,12,1000,12);
   			g.setColor(Color.blue);
   			for(int i=0;i<successione.length;i++) {
   				g.drawString(String.valueOf(successione[i]),successione[i]*5,10);
   				g.drawLine(successione[i]*5,5,successione[i]*5,7);
   			}
   		}*/
   		   		
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==50) {
				if((i+1)<numeriFCFS.length)
					g.drawLine(numeriFCFS[i]*20,10*i,numeriFCFS[i+1]*20,10*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*20,11*i);
				System.out.print(" "+numeriFCFS[i]);
			}
		}
		System.out.println(" ");

	}
	
}
