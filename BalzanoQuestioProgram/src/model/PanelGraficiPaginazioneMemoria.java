package model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelGraficiPaginazioneMemoria extends JPanel {

	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=520, h=118;//salvo dimensioni della finestra in delle variabili per renderle pi� facili da utilizzare e da modificare
	float intervalloX, intervalloY;
   	static public float a=30;
	
   	
   	public void paintComponent(Graphics g){

	super.paintComponent(g); 
	//setBackground(Color.white); 
	int i,j,k;

	g.setColor(Color.black);
	
	g.setColor(Color.lightGray);

	for(i=0;i<120;) {
    	g.drawLine(0,h-i, l,h-i);
		i=i+15;
	}
	g.setColor(Color.BLUE);
	g.drawLine(0,h-15, l,h-15);
	g.setColor(Color.lightGray);

	for(j=0;j<500;) {
		g.drawLine(l-j,0,l-j,h);
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
	for( k=01;k<31;k++){
		if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",2+count*15,115);
		else g.drawString(" "+String.valueOf(k)+" ",2+count*15,115);
		count++;
	}
	}
/*
	public void disegnaGriglia(Graphics g,Boolean selectGriglia){
		super.paintComponent(g); 
    	//setBackground(Color.white); 
    	int i,j,k;
    	g.setColor(Color.black);
    	
    	g.setColor(Color.lightGray);

    	if(selectGriglia==true) {
    		for(i=0;i<120;) {
    			g.drawLine(0,h-i, l,h-i);
    			i=i+15;
    		}
    		g.setColor(Color.BLUE);
    		g.drawLine(0,h-15, l,h-15);
    		g.setColor(Color.lightGray);

    		for(j=0;j<520;) {
    			g.drawLine(l-j,0,l-j,h);
    			j=j+15;
    		}
    		g.setColor(Color.BLUE);
    		g.drawLine(l-j+15,0,l-j+15,h);
    	}
    	else {
    		for(i=0;i<120;) {
        		i=i+15;
        	}
        	g.setColor(Color.BLUE);
        	g.drawLine(0,h-15, l,h-15);

        	for(j=0;j<520;) {
        		j=j+15;
        	}
        	g.setColor(Color.BLUE);
    		g.drawLine(l-j+30,0,l-j+30,h);
        }        		
    	
    	g.setFont(new Font("Times New Roman", Font.BOLD, 11));
    	g.setColor(Color.black);
    	g.drawString("P1",7,92);
    	g.drawString("P2",7,77);
    	g.drawString("P3",7,62);
    	g.drawString("P4",7,47);
    	g.drawString("P5",7,32);
    	g.drawString("P6",7,17);
	
    	int count=2;
    	for( k=01;k<31;k++){
    		if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",2+count*15,115);
    		else g.drawString(" "+String.valueOf(k)+" ",2+count*15,115);
    		count++;
    	}
	}
*/	
	
	
	
	
	
}
