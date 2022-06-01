package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class PanelGraficiSchHD extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=1000, h=145;//salvo dimensioni della finestra in delle variabili per renderle piÃƒÂ¯Ã‚Â¿Ã‚Â½ facili da utilizzare e da modificare

	
   	
   	public void paintComponent(Graphics g){

	super.paintComponent(g); 

   	}
   	
   	public void resetGrafico(Graphics g){
   		super.paintComponent(g); 
   	}
   	
   	public void disegnaSoluzione(Graphics g, int[] numeriFCFS, int nc, double distanzaFIFO, int[] successione) {
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
   		System.out.println();
		for(int i=0;i<numeriFCFS.length;i++) {
			System.out.print(numeriFCFS[i]+" ");
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==50) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*20,10*(i+1)-1,numeriFCFS[i+1]*20,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*20,10*(i+1),numeriFCFS[i+1]*20,10*(i+2));
					g.drawLine(numeriFCFS[i]*20,10*(i+1)+1,numeriFCFS[i+1]*20,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*20-2,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*20+7,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==100) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*10,10*(i+1)-1,numeriFCFS[i+1]*10,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*10,10*(i+1),numeriFCFS[i+1]*10,10*(i+2));
					g.drawLine(numeriFCFS[i]*10,10*(i+1)+1,numeriFCFS[i+1]*10,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*10-2,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*10+7,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==200) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*5,10*(i+1)-1,numeriFCFS[i+1]*5,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*5,10*(i+1),numeriFCFS[i+1]*5,10*(i+2));
					g.drawLine(numeriFCFS[i]*5,10*(i+1)+1,numeriFCFS[i+1]*5,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*5-2,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5+7,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==400) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*2+1,10*(i+1)-1,numeriFCFS[i+1]*2+1,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*2+1,10*(i+1),numeriFCFS[i+1]*2+1,10*(i+2));
					g.drawLine(numeriFCFS[i]*2+1,10*(i+1)+1,numeriFCFS[i+1]*2+1,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*2-2+1,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*2+7+1,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==500) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*2,10*(i+1)-1,numeriFCFS[i+1]*2,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*2,10*(i+1),numeriFCFS[i+1]*2,10*(i+2));
					g.drawLine(numeriFCFS[i]*2,10*(i+1)+1,numeriFCFS[i+1]*2,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*2-2,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*2+7,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==600) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*1+2,10*(i+1)-1,numeriFCFS[i+1]*1+2,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*1+2,10*(i+1),numeriFCFS[i+1]*1+2,10*(i+2));
					g.drawLine(numeriFCFS[i]*1+2,10*(i+1)+1,numeriFCFS[i+1]*1+2,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*1-2+2,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*1+7+2,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==800) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*1+1,10*(i+1)-1,numeriFCFS[i+1]*1+1,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*1+1,10*(i+1),numeriFCFS[i+1]*1+1,10*(i+2));
					g.drawLine(numeriFCFS[i]*1+1,10*(i+1)+1,numeriFCFS[i+1]*1+1,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*1-2+1,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*1+7+1,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
		for(int i=0;i<numeriFCFS.length;i++) {
			if(nc==1000) {
				g.setColor(new Color(0, 153, 0));
				if((i+1)<numeriFCFS.length) {
					g.drawLine(numeriFCFS[i]*1,10*(i+1)-1,numeriFCFS[i+1]*1,10*(i+2)-1);
					g.drawLine(numeriFCFS[i]*1,10*(i+1),numeriFCFS[i+1]*1,10*(i+2));
					g.drawLine(numeriFCFS[i]*1,10*(i+1)+1,numeriFCFS[i+1]*1,10*(i+2)+1);
				}
					//g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*5,11*i);
					g.setColor(Color.black);
					g.drawString("●",numeriFCFS[i]*1-2,11*(i+1));
					g.drawString(String.valueOf(numeriFCFS[i]),numeriFCFS[i]*1+7,12*(i+1));
					g.setColor(new Color(0, 153, 0));
			}
		}
	}
	
}



















