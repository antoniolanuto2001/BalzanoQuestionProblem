package model;

public class FilosofiModel implements Runnable 
{
    static final int NTHREAD=5;             // numero di filosofi
    final int index;                        // indice locale del filosofo
    static TavolaClassica tavolaClassica= new TavolaClassica(NTHREAD);   // monitor statico/condiviso
    static TavolaAtomica tavolaAtomica= new TavolaAtomica(NTHREAD);
    
    /**
     * @brief Costruttore
     * 
     * @param i Index del Filosofo
     */
    FilosofiModel(int i)
    {
        index = i;
    }
    
    // il thread esegue il codiceFilosofo a meno di interruzioni
    /**
     * @brief Funzione che esegue il run classico dei filosofi
     */
    public void runClassico() 
    {
        try 
        { 
            codiceFilosofoClassico(index);
        } 
        catch (InterruptedException e)
        {
            System.out.println("Il filosofo "+index+" e' stato interrotto");
        }
    }

    // il filosofo pensa e mangia come al solito
    void codiceFilosofoClassico(int index) throws InterruptedException 
    {
        while(true)
        {
            // PENSA 
            System.out.println("Filosofo " + index +" pensa");
            Thread.sleep(1000);
            
            tavolaClassica.raccogli_sx(index);   // raccoglie la bacchetta sinistra
            // Decommentare per forzare lo stallo
            //Thread.sleep(1000);
            tavolaClassica.raccogli_dx(index);   // raccoglie la bacchetta destra

            //MANGIA
            System.out.println("Filosofo " + index +" mangia");
            Thread.sleep(1000);

            tavolaClassica.deposita_sx(index);   // deposita la bacchetta sinistra
            tavolaClassica.deposita_dx(index);   // deposita la bacchetta destra
        }
    }
   
    public void runAtomico()  
    {
        try 
        { 
            codiceFilosofoAtomico(index);
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Il filosofo "+index+" e' stato interrotto");
        }
    }
    
    // il filosofo pensa e mangia come al solito
    void codiceFilosofoAtomico(int index) throws InterruptedException 
    {
        while(true) 
        {
            // PENSA 
            System.out.println("Filosofo " + index +" pensa");
            Thread.sleep(1000);
            tavolaAtomica.raccogli(index);  // raccoglie atomicamente le bacchette
            //MANGIA
            System.out.println("Filosofo " + index +" mangia");
            Thread.sleep(3000);
            tavolaAtomica.deposita(index);  // deposita le bacchette
        }
    }

    @Override
	public void run() {
		System.out.println("Eseguo solo questo ");
		
	}
   

}

