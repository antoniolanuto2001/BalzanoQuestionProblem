
package model;

import java.util.ArrayList;

public class CreaLinee implements Comparable<CreaLinee>{
	
	int arrivo,durata, processo;
	int x,y;
	ArrayList<Integer> punti=new ArrayList<Integer>();
	ArrayList<Integer> linee=new ArrayList<Integer>();

	public CreaLinee(int x1, int y1) {
		this.processo=x1;
		this.arrivo=y1;
	}
	
	public CreaLinee(int processo, int arrivo,int durata) {
		this.processo=processo;
		this.arrivo=arrivo;
		this.durata=durata;
	}
	public void creaDistanza(int processo, int arrivo,int durata) {
		
		linee.add(Integer.valueOf(processo));
		linee.add(Integer.valueOf(arrivo));
		linee.add(Integer.valueOf(durata));

	}
	
	public ArrayList<Integer> ritornaPunti(){
		return punti;
	}
	public ArrayList<Integer> ritornaLinee(){
		return linee;
	}
	
	public int getProcesso() {
		return processo;
	}
	public int getArrivo() {
		return arrivo;
	}
	public int getDurata() {
		return durata;
	}
	
	public void setProcesso(int processo) {
		this.processo=processo;
	}
	public void setArrivo(int arrivo) {
		this.arrivo=arrivo;
	}
	public void setDurata(int durata) {
		this.durata=durata;
	}
	
	public int compareTo(CreaLinee linea)
    {
        if (this.arrivo != linea.getArrivo()) {
            return this.arrivo - linea.getArrivo();
        }
        Integer k=Integer.valueOf( this.processo);
        Integer l=Integer.valueOf( linea.getProcesso());

        return k.compareTo(l);
    }
}