package model;



public class ProcessAverage implements Comparable<ProcessAverage>{

	
	public int arrivo;		
	public int nomeProcesso;
	public int durataRimanente;
	public int durataOriginale;
	public int tempoimpiegato;
	public boolean finito;
	
	public ProcessAverage(int arrivo, int processo)
	{
		this.arrivo=arrivo;
		nomeProcesso=processo;
	}
	
	public int getArrivo() 
	{
        return arrivo;
    }
	public int getNomeProcesso() 
	{
	        return nomeProcesso;
	}
	
	
	
    public int compareTo(ProcessAverage o)
    {
        if (this.nomeProcesso != o.getNomeProcesso()) 
        {
            return this.nomeProcesso - o.getNomeProcesso();
        }
        Integer k=Integer.valueOf( this.nomeProcesso);
        Integer l=Integer.valueOf( o.getNomeProcesso());

        return k.compareTo(l);
    }
}

/*
 * 
       	
       	*/