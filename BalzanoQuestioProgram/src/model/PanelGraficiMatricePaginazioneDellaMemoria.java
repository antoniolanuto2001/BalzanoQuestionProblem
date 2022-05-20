package model;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGraficiMatricePaginazioneDellaMemoria extends JPanel {
	
	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=600, h=118;//salvo dimensioni della finestra in delle variabili per renderle pi� facili da utilizzare e da modificare
   	static public float a=30;
	int fault=0;
   	
   	public void paintComponent(Graphics g){

   		super.paintComponent(g); 
   		
   	}	
	
   	public void resetGrafico(Graphics g){

   		super.paintComponent(g); 
   		
   	}
   	
   	public void disegnaSoluzioneFIFO(Graphics g, int array[], int slot,int page){
   		for(int j=0;j<page;j++) {
	   			System.out.print(array[j]);
   		}
			System.out.println("" );

   		for(int j=0;j<page;j++) {
   			
   	   		for(int i=0;i<slot;i++) {
   	   			if(j+i<page) {
	   	   			g.drawString(String.valueOf(array[j+i]),j*15,20+i*15);
	   	   			System.out.println(String.valueOf(array[j]));
   	   			}
   	   		}
   	   		j=j+slot-1;
   		}
   		
   	}

}
