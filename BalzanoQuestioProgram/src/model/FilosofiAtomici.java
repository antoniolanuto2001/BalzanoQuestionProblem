package model;

public class FilosofiAtomici implements Runnable
{
 	static final int NTHREAD=5;             // numero di filosofi
    final int index;                        // indice locale del filosofo
    static TavolaAtomica tavolaAtomica= new TavolaAtomica(NTHREAD); // monitor statico/condiviso
    
   public FilosofiAtomici(int i) 
   {
	   index=i;
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
}
