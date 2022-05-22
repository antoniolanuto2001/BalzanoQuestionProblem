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
   		
   		g.setFont(new Font("ARIAL", Font.PLAIN, 15));
   		
   		for(int j=0;j<page;j++) {
   			
   	   		for(int i=0;i<slot;i++) {
   	   			if(j+i<page) {
	   	   			g.drawString(String.valueOf(array[j+i]),j*15,20+i*18);
   	   			}
   	   		}
   	   		j=j+slot-1;
   		}
   		
   	}
   	
	public void disegnaSoluzioneOPT(Graphics g, int array[][], int slot,int page){
   		
   		g.setFont(new Font("ARIAL", Font.PLAIN, 15));
   		/*
   		for(int j=0;j<page;j++) {
   			
   	   		for(int i=0;i<slot;i++) {
   	   			if(j+i<page) {
	   	   			g.drawString(String.valueOf(array[j+i]),j*15,20+i*18);
   	   			}
   	   		}
   	   		j=j+slot-1;
   		}*/
   		for(int i = 0; i < slot; i++)
	    {
	        for(int j = 0; j < 25; j++)
   	   			g.drawString(String.valueOf(array[j][i]),j*17,20+i*18);
	    }
	    
   		
   	}
	
	public void disegnaSoluzioneLRU(Graphics g, int array[][], int slot,int page){
   		
   		g.setFont(new Font("ARIAL", Font.PLAIN, 15));
   		/*
   		for(int j=0;j<page;j++) {
   			
   	   		for(int i=0;i<slot;i++) {
   	   			if(j+i<page) {
	   	   			g.drawString(String.valueOf(array[j+i]),j*15,20+i*18);
   	   			}
   	   		}
   	   		j=j+slot-1;
   		}*/
   		for(int i = 0; i < slot; i++)
	    {
	        for(int j = 0; j < 25; j++)
   	   			g.drawString(String.valueOf(array[j][i]),j*17,20+i*18);
	    }
	    
   		
   	}
	
	public void disegnaSoluzioneCLOCK(Graphics g, int array[][], int slot,int page){
   		
   		g.setFont(new Font("ARIAL", Font.PLAIN, 15));
   		
   		/*for(int j=0;j<page;j++) {
   			
   	   		for(int i=0;i<slot;i++) {
   	   			if(j+i<page) {
	   	   			g.drawString(String.valueOf(array[j+i]),j*15,20+i*18);
   	   			}
   	   		}
   	   		j=j+slot-1;
   		}*/
   		for(int i = 0; i < slot; i++)
	    {
	        for(int j = 0; j < 25; j++)
   	   			g.drawString(String.valueOf(array[j][i]),j*17,20+i*18);
	    }
	    
   		
   	}
   	


}
