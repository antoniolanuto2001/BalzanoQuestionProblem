package model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class PanelGraficiSchProcessi extends JPanel {

	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=1100, h=118;//salvo dimensioni della finestra in delle variabili per renderle pi� facili da utilizzare e da modificare
	float intervalloX, intervalloY;
   	static public float a=30;
	
   	
   	public void paintComponent(Graphics g){

	super.paintComponent(g); 

	//setBackground(Color.white); 
	intervalloX=l/((float)xMax-xMin);
	intervalloY=h/((float)yMax-yMin);
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

	for(j=0;j<1075;) {
		g.drawLine(l-j,0,l-j,h);
		j=j+15;
	}
	g.setColor(Color.BLUE);
	g.drawLine(l-j+15,0,l-j+15,h);

	g.setFont(new Font("Times New Roman", Font.BOLD, 11));
	g.setColor(Color.black);
	g.drawString("P1",13,92);
	g.drawString("P2",13,77);
	g.drawString("P3",13,62);
	g.drawString("P4",13,47);
	g.drawString("P5",13,32);
	g.drawString("P6",13,17);
	int count=2;
	for( k=01;k<71;k++){
		if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",12+count*15,115);
		else g.drawString(" "+String.valueOf(k)+" ",12+count*15,115);
		count++;
	}
	}

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

    		for(j=0;j<1075;) {
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

        	for(j=0;j<1075;) {
        		j=j+15;
        	}
        	g.setColor(Color.BLUE);
    		g.drawLine(l-j+15,0,l-j+15,h);
        }        		
    	
    	g.setFont(new Font("Times New Roman", Font.BOLD, 11));
    	g.setColor(Color.black);
    	g.drawString("P1",13,92);
    	g.drawString("P2",13,77);
    	g.drawString("P3",13,62);
    	g.drawString("P4",13,47);
    	g.drawString("P5",13,32);
    	g.drawString("P6",13,17);
	
    	int count=2;
    	for( k=01;k<71;k++){
    		if(k<10)g.drawString(" 0"+String.valueOf(k)+" ",12+count*15,115);
    		else g.drawString(" "+String.valueOf(k)+" ",12+count*15,115);
    		count++;
    	}
	}
	
	
	
	public void disegnaSoluzione(Graphics g, ArrayList<CreaLinee>  lineesFCFSarray,ArrayList<Integer>  lineesFCFS,Boolean selectSoluzione,Boolean selectGriglia){
		
    	if(selectSoluzione==true) {
    		
    		for(int l=0;l<lineesFCFS.size();) {   
        		g.setColor(new Color(0, 204, 0));
    			g.drawLine(35+lineesFCFS.get(l)*15,103-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,103-lineesFCFS.get(l+3)*15);
    			if(lineesFCFS.get(l+1)==3) g.drawLine(35+lineesFCFS.get(l)*15,104-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,104-lineesFCFS.get(l+3)*15);
    			else g.drawLine(35+lineesFCFS.get(l)*15,102-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,102-lineesFCFS.get(l+3)*15);

    			g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
    			l=l+4;
    		}
    		g.setColor(Color.blue);

    		for(int l=0;l<lineesFCFSarray.size();l++) {    
        			g.drawString("●",30+lineesFCFSarray.get(l).getArrivo()*15,107-lineesFCFSarray.get(l).getProcesso()*15);
        					//92-l*15);
        	}

    	}
	}
	
	
}
