package model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelGraficiPaginazioneMemoria extends JPanel {

	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=520, h=118;//salvo dimensioni della finestra in delle variabili per renderle pi� facili da utilizzare e da modificare
   	static public float a=30;
	
   	
   	public void paintComponent(Graphics g){

		super.paintComponent(g); 
		//setBackground(Color.white); 
		int i,j,k;
	
		g.setColor(Color.black);
		
		g.setColor(Color.lightGray);
	
		for(i=0;i<120;) {
	    	g.drawLine(21,h-i, l,h-i);
			i=i+15;
		}
		g.setColor(Color.BLUE);
		g.drawLine(0,h-15, l,h-15);
		g.setColor(Color.lightGray);
	
		for(j=0;j<500;) {
			g.drawLine(l-j,0,l-j,h-15);
			j=j+15;
		}
		g.setColor(Color.BLUE);
		g.drawLine(l-j+15,0,l-j+15,h);
	
		g.setFont(new Font("Times New Roman", Font.BOLD, 11));
		g.setColor(Color.black);
		g.drawString("1",8,92);
		g.drawString("2",8,77);
		g.drawString("3",8,62);
		g.drawString("4",8,47);
		g.drawString("5",8,32);
		g.drawString("6",8,17);
		int count=2;
		for( k=01;k<33;k++){
			if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",2+count*15,115);
			else g.drawString(" "+String.valueOf(k)+" ",2+count*15,115);
			count++;
		}
	}
	
	public void resetGrafico(Graphics g){

		super.paintComponent(g); 
		//setBackground(Color.white); 
		int i,j,k;
	
		g.setColor(Color.black);
		
		g.setColor(Color.lightGray);
	
		for(i=0;i<120;) {
	    	g.drawLine(21,h-i, l,h-i);
			i=i+15;
		}
		g.setColor(Color.BLUE);
		g.drawLine(0,h-15, l,h-15);
		g.setColor(Color.lightGray);
	
		for(j=0;j<500;) {
			g.drawLine(l-j,0,l-j,h-15);
			j=j+15;
		}
		g.setColor(Color.BLUE);
		g.drawLine(l-j+15,0,l-j+15,h);
	
		g.setFont(new Font("Times New Roman", Font.BOLD, 11));
		g.setColor(Color.black);
		g.drawString("1",8,92);
		g.drawString("2",8,77);
		g.drawString("3",8,62);
		g.drawString("4",8,47);
		g.drawString("5",8,32);
		g.drawString("6",8,17);
		int count=2;
		for( k=01;k<33;k++){
			if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",2+count*15,115);
			else g.drawString(" "+String.valueOf(k)+" ",2+count*15,115);
			count++;
		}
	}
	
	public void disegnaSoluzione(Graphics g, int[] punti){
			
		g.setColor(Color.blue);
		
		g.drawLine(25+punti[1]*15,103-punti[0]*15,25+punti[3]*15,103-punti[2]*15);
		g.drawLine(25+punti[3]*15,103-punti[2]*15,25+punti[5]*15,103-punti[4]*15);
		g.drawLine(25+punti[5]*15,103-punti[4]*15,25+punti[7]*15,103-punti[6]*15);
		g.drawLine(25+punti[7]*15,103-punti[6]*15,25+punti[9]*15,103-punti[8]*15);
		g.drawLine(25+punti[9]*15,103-punti[8]*15,25+punti[11]*15,103-punti[10]*15);
	    	
		g.drawLine(25+punti[1]*15,104-punti[0]*15,25+punti[3]*15,104-punti[2]*15);
		g.drawLine(25+punti[3]*15,104-punti[2]*15,25+punti[5]*15,104-punti[4]*15);
		g.drawLine(25+punti[5]*15,104-punti[4]*15,25+punti[7]*15,104-punti[6]*15);
		g.drawLine(25+punti[7]*15,104-punti[6]*15,25+punti[9]*15,104-punti[8]*15);
		g.drawLine(25+punti[9]*15,104-punti[8]*15,25+punti[11]*15,104-punti[10]*15);
	    	
		g.drawLine(25+punti[1]*15,102-punti[0]*15,25+punti[3]*15,102-punti[2]*15);
		g.drawLine(25+punti[3]*15,102-punti[2]*15,25+punti[5]*15,102-punti[4]*15);
		g.drawLine(25+punti[5]*15,102-punti[4]*15,25+punti[7]*15,102-punti[6]*15);
		g.drawLine(25+punti[7]*15,102-punti[6]*15,25+punti[9]*15,102-punti[8]*15);
		g.drawLine(25+punti[9]*15,102-punti[8]*15,25+punti[11]*15,102-punti[10]*15);
	    	
		g.setColor(Color.red);
		
		g.drawString("●",20+punti[1]*15,107-punti[0]*15);
		g.drawString("●",20+punti[3]*15,107-punti[2]*15);
		g.drawString("●",20+punti[5]*15,107-punti[4]*15);
		g.drawString("●",20+punti[7]*15,107-punti[6]*15);
		g.drawString("●",20+punti[9]*15,107-punti[8]*15);
		g.drawString("●",20+punti[11]*15,107-punti[10]*15);
	   
	}
}
