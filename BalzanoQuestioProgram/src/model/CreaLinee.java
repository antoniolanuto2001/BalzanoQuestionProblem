//RIUFSRJKFHFJAEHFIUGUIGHGJSGH
//hfjsgfjrsgf

package model;

import java.util.ArrayList;

public class CreaLinee {
	
	int x1,x2,y1,y2;
	ArrayList<Integer> punti=new ArrayList<Integer>();
	ArrayList<Integer> linee=new ArrayList<Integer>();

	public ArrayList<Integer> creaDistanza(int processo, int arrivo,int durata) {
		
		y1=processo;
		x1=arrivo;
		x2=durata;
		linee.add(Integer.valueOf(y1));
		linee.add(Integer.valueOf(x1));
		linee.add(Integer.valueOf(x2));

		return linee;
	}

	public ArrayList<Integer> creaPunti(int x1, int y1) {
		
		this.x1=x1;
		this.y1=y1;
		punti.add(Integer.valueOf(x1));
		punti.add(Integer.valueOf(y1));

		return punti;
	}
	public ArrayList<Integer> ritornaPunti(){
		return punti;
	}
	public ArrayList<Integer> ritornaLinee(){
		return linee;
	}
}
