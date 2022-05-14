package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class GraficaSemaforo extends JComponent
{
	Color go = Color.gray;
	Color stop = Color.gray;
	
	/*public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, 150, 250);
		
		g.setColor(Color.black);
		g.drawRect(0, 0, 150, 250);
		
		//green circle
		g.setColor(stop);
		g.fillOval(50, 20, 50, 50);
		
		
		//red circle
		g.setColor(go);
		g.fillOval(50, 100, 50, 50);
	}*/
	
	
	
	
    public void paint(Graphics g)
    {
        g.drawRect(0, 0, 150, 250);
        g.drawOval(50, 20, 50, 50);
        g.drawOval(50, 100, 50, 50);
 
    }
}
