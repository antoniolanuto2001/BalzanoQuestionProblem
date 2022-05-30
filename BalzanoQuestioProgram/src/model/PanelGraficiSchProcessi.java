
package model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelGraficiSchProcessi extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int xMin=0, xMax=50, yMin=0, yMax=40;//valore degli estremi del piao cartesiano
	int l=1100, h=118;//salvo dimensioni della finestra in delle variabili per renderle piï¿½ facili da utilizzare e da modificare
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
    	g.drawLine(30,h-i, l,h-i);
		i=i+15;
	}
	g.setColor(Color.BLUE);
	g.drawLine(0,h-15, l,h-15);
	g.setColor(Color.lightGray);

	for(j=0;j<1075;) {
		g.drawLine(l-j,0,l-j,h+15);
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
    			g.drawLine(25,h-i, l,h-i);
    			i=i+15;
    		}
    		g.setColor(Color.BLUE);
    		g.drawLine(0,h-15, l,h-15);
    		g.setColor(Color.lightGray);

    		for(j=0;j<1075;) {
    			g.drawLine(l-j,0,l-j,h-15);
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
	
	
	
	public void disegnaSoluzioneFCFS(Graphics g, ArrayList<CreaLinee>  lineesFCFSarray,ArrayList<Integer>  lineesFCFS,Boolean selectSoluzione,Boolean selectGriglia){
		
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
	
	public void disegnaSoluzioneSJF(Graphics g, ArrayList<CreaLinee>  lineesFCFSarray,ArrayList<Integer>  lineesFCFS,Boolean selectSoluzione,Boolean selectGriglia){
		
    	if(selectSoluzione==true) {
    		
    		for(int l=0;l<lineesFCFS.size();) {   
        		g.setColor(new Color(0, 204, 0));
    			g.drawLine(35+lineesFCFS.get(l)*15,103-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,103-lineesFCFS.get(l+3)*15);
    			if(lineesFCFS.get(l+1)==3 || lineesFCFS.get(l+1)==2 || lineesFCFS.get(l+1)==6) g.drawLine(35+lineesFCFS.get(l)*15,104-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,104-lineesFCFS.get(l+3)*15);
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
	
public void disegnaSoluzioneSJFP(Graphics g, ArrayList<CreaLinee>  lineesFCFSarray,ArrayList<Integer>  lineesFCFS,Boolean selectSoluzione,Boolean selectGriglia){
	
	int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0;
	
		if(selectSoluzione==true) {
    		for(int l=0;l<lineesFCFS.size();) { 
    			if(lineesFCFS.get(l+1)>0) {
    				
    				g.setColor(new Color(0, 204, 0));
	    			g.drawLine(35+lineesFCFS.get(l)*15,103-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,103-lineesFCFS.get(l+3)*15);
	    			if(lineesFCFS.get(l+1)!=4)g.drawLine(35+lineesFCFS.get(l)*15,104-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,104-lineesFCFS.get(l+3)*15);
	    			else g.drawLine(35+lineesFCFS.get(l)*15,102-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,102-lineesFCFS.get(l+3)*15);
	    			
	    			if(a1==0 && lineesFCFS.get(l+1)==1) {
	    				g.setColor(new Color(0, 204, 0));
	    				g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
	    				a1=1;
	    			}
	    			if(a2==0 && lineesFCFS.get(l+1)==2) {
	    				g.setColor(new Color(0, 204, 0));
	    				g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
	    				a2=1;
	    			}
	    			if(a3==0 && lineesFCFS.get(l+1)==3) {
	    				g.setColor(new Color(0, 204, 0));
	    				g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
	    				a3=1;
	    			}
	    			if(a4==0 && lineesFCFS.get(l+1)==4) {
	    				g.setColor(new Color(0, 204, 0));
	    				g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
	    				a4=1;
	    			}
	    			if(a5==0 && lineesFCFS.get(l+1)==5) {
	    				g.setColor(new Color(0, 204, 0));
	    				g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
	    				a5=1;
	    			}
	    			if(a6==0 && lineesFCFS.get(l+1)==6) {
	    				g.setColor(new Color(0, 204, 0));
	    				g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
	    				a6=1;
	    			}

    			}
    			l=l+4;
    		}
    		g.setColor(Color.blue);

    		for(int l=0;l<lineesFCFSarray.size();l++) {    
        			g.drawString("●",30+lineesFCFSarray.get(l).getArrivo()*15,107-lineesFCFSarray.get(l).getProcesso()*15);
        					//92-l*15);
        	}

    	}
	}

public void disegnaSoluzioneRR(Graphics g, ArrayList<CreaLinee>  lineesFCFSarray,ArrayList<Integer>  lineesFCFS,Boolean selectSoluzione,Boolean selectGriglia){
	if(selectSoluzione==true) {
		
		for(int l=0;l<lineesFCFS.size();) { 
			if(lineesFCFS.get(l)>0) {
    		g.setColor(new Color(0, 204, 0));
			g.drawLine(35+lineesFCFS.get(l)*15,103-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,103-lineesFCFS.get(l+3)*15);
			g.drawLine(35+lineesFCFS.get(l)*15,104-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,104-lineesFCFS.get(l+3)*15);
			 //g.drawLine(35+lineesFCFS.get(l)*15,102-lineesFCFS.get(l+1)*15,35+lineesFCFS.get(l+2)*15,102-lineesFCFS.get(l+3)*15);
			g.drawString("●",30+lineesFCFS.get(l)*15,107-lineesFCFS.get(l+1)*15);
			}
			l=l+4;
		}
		g.setColor(Color.blue);

		for(int l=0;l<lineesFCFSarray.size();l++) {    
    			g.drawString("●",30+lineesFCFSarray.get(l).getArrivo()*15,107-lineesFCFSarray.get(l).getProcesso()*15);
    					//92-l*15);
    	}

	}
}
	
/*	public void disegnaSoluzioneSJFP(Graphics g, ArrayList<CreaLinee>  lineesFCFSarray,  ArrayList<Integer>  lineesFCFS, Boolean selectSoluzione,Boolean selectGriglia){
			
			int completo = 0;
	    	int lineetotali=0;
	    	int [] attivo = new int[lineesFCFSarray.size()];
	    	Arrays.fill(attivo, 0);
	    	int minimo=999;
	    	int minimodurata=9999;
	    	int corrente;
	    	int indexprocesso=0;
	    	if(selectSoluzione==true) {
		
				g.setColor(Color.blue);


				
	    		for(int l=0;l<lineesFCFSarray.size();l++)
	    		{    
	        			g.drawString("●",30+lineesFCFSarray.get(l).getArrivo()*15,107-lineesFCFSarray.get(l).getProcesso()*15);
	        					//92-l*15);
	        	}
	    		
	    		
	    		for(int l=0;l<lineesFCFSarray.size();l++) 
	    		{    
	    			lineesFCFSarray.get(indexprocesso).aggiorna=lineesFCFSarray.get(l).getArrivo();
	    			System.out.println("P"+(l+1)+"  "+lineesFCFSarray.get(l).getArrivo()+" P"+lineesFCFSarray.get(l).getProcesso()+" D"+lineesFCFSarray.get(l).getDurata()+"");
	    			if(lineesFCFSarray.get(l).getArrivo()<minimo)
	    			{
	    				minimo=lineesFCFSarray.get(l).getArrivo();
	    			}
	    			lineetotali+=lineesFCFSarray.get(l).getDurata();
	    		}
	    		g.setColor(new Color(0, 204, 0));
	    		System.out.println("Durata totale : "+lineetotali);
	    		System.out.println("Minimo totale : "+minimo);
	    		corrente=minimo;
	    		while (completo!=lineetotali)
	    		{
	    			minimodurata=9999;
	    			for (int i = 0; i < lineesFCFSarray.size(); i++) 
	    			{
	    				if((lineesFCFSarray.get(i).getDurata()<minimodurata )&& (lineesFCFSarray.get(i).getArrivo() <= corrente) && (attivo[i]!=lineesFCFSarray.get(i).getDurata()))
		    			{
		    				minimodurata=lineesFCFSarray.get(i).getDurata();
		    				indexprocesso=i;	
		    			}
	    				
					}
	    			
 	    			attivo[indexprocesso]++;	
		    		System.out.println("index processo estratto : "+ (indexprocesso+1));
		    		g.setColor(new Color(0, 204, 0));
		    		g.drawLine(35+lineesFCFSarray.get(indexprocesso).aggiorna*15,103-lineesFCFSarray.get(indexprocesso).getProcesso()*15,35+lineesFCFSarray.get(indexprocesso).getArrivo()*17,103-lineesFCFSarray.get(indexprocesso).getProcesso()*15);
		    		System.out.println("Stampa  questo : "+ (35+lineesFCFSarray.get(indexprocesso).getArrivo()));
		    		completo++;
	    			corrente++;
				}
	
	    	}
		}
*/
}


