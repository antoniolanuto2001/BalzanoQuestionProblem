package model;

public class lineaRR implements Comparable<lineaRR>{

	int x1, x2, y1, y2;
	
	public lineaRR(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
	
	public int getX1() {
		return x1;
	}
	
	public int getY1() {
		return y1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getY2() {
		return y2;
	}
	
	
	public void setX1(int newvalue) {
		x1=newvalue;
	}
	
	public void setY1(int newvalue) {
		y1=newvalue;
	}
	
	public void setX2(int newvalue) {
		x2=newvalue;
	}
	
	public void setY2(int newvalue) {
		y2=newvalue;
	}
	public int compareTo(lineaRR linea)
    {
		 if (this.x1 != linea.getX1()) {
	            return this.x1 - linea.getX1();
	        }
	        Integer k=Integer.valueOf( this.y1);
	        Integer l=Integer.valueOf( linea.getY1());

	        return k.compareTo(l);
    }
}
