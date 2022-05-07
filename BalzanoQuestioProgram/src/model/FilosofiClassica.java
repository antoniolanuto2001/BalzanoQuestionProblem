package model;


public class FilosofiClassica implements Runnable 
{
    final int index;                        // indice locale del filosofo
    private boolean exit;
    static final int NTHREAD=5;             // numero di filosofi
    static TavolaClassica tavolaClassica= new TavolaClassica(NTHREAD);   // monitor statico/condiviso
    
    /**
     * @brief Costruttore
     * 
     * @param i Index del Filosofo
     */
    public FilosofiClassica(int i)
    {
        index = i;
        exit = true;
    }
    
    // il thread esegue il codiceFilosofo a meno di interruzioni
    /**
     * @brief Funzione che esegue il run classico dei filosofi
     */
    @Override
    public void run() 
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
        while (exit)
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
    /**
     * @brief Funzione che Stopa Esecuzione del thread associato
     */
    public void stop()
    {
    	exit = false;
    }
    /**
     * @brief Funzione che Riavvia l' Esecuzione del thread associato
     */
    
    public void resume()
    {
    	exit = true;
    }
   
}
