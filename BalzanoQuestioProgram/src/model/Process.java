package model;



public class Process implements Comparable<Process>
{
	public int arrivo;		
	public int nomeProcesso;
	public int durataRimanente;
	public int durataOriginale;
	public int tempoimpiegato;
	public boolean finito;
	
	public Process()
	{
		arrivo=0;
		durataRimanente=0;
		durataOriginale=0;
		tempoimpiegato=0;
		nomeProcesso=0;
		finito=false;
	}
	public int getArrivo() 
	{
        return arrivo;
    }
	public int getNomeProcesso() 
	{
	        return nomeProcesso;
	}
	
	@Override
    public int compareTo(Process o)
    {
        if (this.arrivo != o.getArrivo()) 
        {
            return this.arrivo - o.getArrivo();
        }
        Integer k=Integer.valueOf( this.nomeProcesso);
        Integer l=Integer.valueOf( o.getNomeProcesso());

        return k.compareTo(l);    }
}
