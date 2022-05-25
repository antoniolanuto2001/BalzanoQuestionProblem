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
   	
   	public void disegnaSoluzioneFIFO(Graphics g, int array[][], int slot,int page, int numeri[]){
   		
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
   		for(int i = array.length-1; i >=0; i--)
	    {
   	   		int count=0;
	        for(int j = 0; j < slot; j++) {
	        	if(i>0)	if(array[i][j]==array[i-1][j])count++;
	        }
	        if(count==slot) {
	        	for(int j = 0; j < slot; j++) {
		        	array[i][j]=-1;
		        }
	        }
	    }
   		
   		
   		for(int i = 0; i < slot; i++)
	    {
	        for(int j = 0; j < 25; j++) {
	        	if(array[j][i]<0) g.drawString(" ",j*17,20+i*18);
	        	else
   	   			g.drawString(String.valueOf(array[j][i]),j*17,20+i*18);
	    	}
   		}
   		g.setColor(Color.blue);
        for(int j = 0; j < 25; j++) {
        	g.drawString(String.valueOf(numeri[j]),j*17,20+slot*19);
        }
   	}
   	
	public void disegnaSoluzioneOPT(Graphics g, int array[][], int slot,int page, int numeri[]){
   		
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
   		for(int i = array.length-1; i >=0; i--)
	    {
   	   		int count=0;
	        for(int j = 0; j < slot; j++) {
	        	if(i>0)	if(array[i][j]==array[i-1][j])count++;
	        }
	        if(count==slot) {
	        	for(int j = 0; j < slot; j++) {
		        	array[i][j]=-1;
		        }
	        }
	    }
   		
   		for(int i = 0; i < slot; i++)
	    {
	        for(int j = 0; j < 25; j++) {
	        	if(array[j][i]<0) g.drawString(" ",j*17,20+i*18);
	        	else
   	   			g.drawString(String.valueOf(array[j][i]),j*17,20+i*18);
	    	}
   		}
	    
   		g.setColor(Color.blue);
	        for(int j = 0; j < 25; j++) {
	        	g.drawString(String.valueOf(numeri[j]),j*17,20+slot*19);
	        }
   		
   	}
	
	public void disegnaSoluzioneLRU(Graphics g, int array[][], int slot,int page, int numeri[]){
   		
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
   		for(int i = array.length-1; i >=0; i--)
	    {
   	   		int count=0;
	        for(int j = 0; j < slot; j++) {
	        	if(i>0)	if(array[i][j]==array[i-1][j])count++;
	        }
	        if(count==slot) {
	        	for(int j = 0; j < slot; j++) {
		        	array[i][j]=-1;
		        }
	        }
	    }
   		
   		for(int i = 0; i < slot; i++)
	    {
	        for(int j = 0; j < 25; j++) {
	        	if(array[j][i]<0) g.drawString(" ",j*17,20+i*18);
	        	else
   	   			g.drawString(String.valueOf(array[j][i]),j*17,20+i*18);
	        }
	    }
   		g.setColor(Color.blue);
        for(int j = 0; j < 25; j++) {
        	g.drawString(String.valueOf(numeri[j]),j*17,20+slot*19);
        }
   		
   	}
	
	public void disegnaSoluzioneCLOCK(Graphics g, int array[][], int slot,int page, int numeri[]){
   		
   		g.setFont(new Font("ARIAL", Font.PLAIN, 15));
   		
   		/*for(int j=0;j<page;j++) {
   			
   	   		for(int i=0;i<slot;i++) {
   	   			if(j+i<page) {
	   	   			g.drawString(String.valueOf(array[j+i]),j*15,20+i*18);
   	   			}
   	   		}
   	   		j=j+slot-1;
   		}*/
   		for(int i = array.length-1; i >=0; i--)
	    {
   	   		int count=0;
	        for(int j = 0; j < slot; j++) {
	        	if(i>0)	if(array[i][j]==array[i-1][j])count++;
	        }
	        if(count==slot) {
	        	for(int j = 0; j < slot; j++) {
		        	array[i][j]=-1;
		        }
	        }
	    }
   		
   		for(int i = 0; i < slot; i++)
	    {
	        for(int j = 0; j < 25; j++) {
	        	if(array[j][i]<0) g.drawString(" ",j*17,20+i*18);
	        	else
   	   			g.drawString(String.valueOf(array[j][i]),j*17,20+i*18);
	        }
	    }
	    
   		g.setColor(Color.blue);
        for(int j = 0; j < 25; j++) {
        	g.drawString(String.valueOf(numeri[j]),j*17,20+slot*19);
        }
   	}
   	


}
