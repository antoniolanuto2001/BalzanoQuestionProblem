package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraficaIndicatoreSemafori extends JPanel{
	
	private int x=0;
	private int y=0;
	private int w=0;
	private int h=0;
	
	
		//set x,y,altezza,larghezza
		public GraficaIndicatoreSemafori(int x, int y, int w, int h) {
			
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;
			
			this.setBackground(Color.YELLOW);
			this.setBounds(this.x, this.y, this.w, this.h);
		}
		
		
		public int getX() {
			return this.x;
		}

	
	   @Override
	   public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.setColor(Color.YELLOW);
	       
	      Graphics2D g2d = (Graphics2D) g;
	      g2d.setStroke(new BasicStroke(3));
	      g2d.drawLine(x, y, w, h);
	   }
	   
	   
	   //limite raggiunto=true - limite non raggiunto=false
	    public boolean LimitReached() {
	    	return x == 300;
	    }
	    
	   //muovi in avanti
	    public void moveForward(){
	    	
	    	this.x += 1;	
	    	//debug
	    	System.out.println("Valore dell'indicatore portato a: "+this.x);
	    	
	    }
	    
	    //ritorna al punto di partenza
	    public void Reset() {
	    	this.x=0;
	    	//debug
	    	System.out.println("Valore dell'indicatore riportato a: "+this.x);
	    }
	    

}
