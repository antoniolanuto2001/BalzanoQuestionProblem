package model;

public class FilosofiAtomici implements Runnable
{
    final int index;                        // indice locale del filosofo
    private boolean exit;
    public boolean pronto;
    public int tempoPensa;
    public int tempoMangia;
    public int tempoEsecuzione;
    static final int NTHREAD=5;             // numero di filosofi
    static TavolaAtomica tavolaAtomica= new TavolaAtomica(NTHREAD); // monitor statico/condiviso
    
    
   public FilosofiAtomici(int i) 
   {
	   index=i;
	   exit = true;
	   tempoPensa=500;
       tempoMangia=800;
       tempoEsecuzione=500;
   } 
   
   @Override
   public void run()  
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
        while(exit) 
        {
        	Thread.sleep(tempoEsecuzione);
            // PENSA 
        	pronto = false;
            System.out.println("Filosofo " + index +" pensa");
            Thread.sleep(tempoPensa);
            tavolaAtomica.raccogli(index);  // raccoglie atomicamente le bacchette
            //MANGIA
            pronto=true;
            System.out.println("Filosofo " + index +" mangia");
            Thread.sleep(tempoMangia);
            tavolaAtomica.deposita(index);  // deposita le bacchette
            pronto = false;
        }
    }
    /**
     * @brief Funzione che Stopa Esecuzione del thread associato
     */
    public void stop()
    {
    	exit = false;
    	pronto = false;
    }
    /**
     * @brief Funzione che Riavvia l' Esecuzione del thread associato
     */
    
    public void resume()
    {
    	exit = true;
    	pronto = false;
    }
}
