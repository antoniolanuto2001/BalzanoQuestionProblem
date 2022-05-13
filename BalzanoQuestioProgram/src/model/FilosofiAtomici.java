package model;

import javax.swing.JTextArea;

public class FilosofiAtomici implements Runnable
{
    final int index;                        // indice locale del filosofo
    private boolean exit;
    public JTextArea textAreaLog ;
    public boolean pronto;
    public int tempoPensa;
    public int tempoMangia;
    public int tempoEsecuzione;
    static final int NTHREAD=5;             // numero di filosofi
    static TavolaAtomica tavolaAtomica= new TavolaAtomica(NTHREAD); // monitor statico/condiviso
    
    
   public FilosofiAtomici(int i ,JTextArea logEntraneTextArea) 
   {
	   index=i;
	   exit = true;
	   textAreaLog=logEntraneTextArea;
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
            System.out.println("Filosofo Atomico" + index +" pensa");
            Thread.sleep(tempoPensa);
            
            
            
            textAreaLog.append("Filosofo Atomico ["+ index +"] pensa ... \n");
            tavolaAtomica.raccogli(index);  // raccoglie atomicamente le bacchette
            //MANGIA
            pronto=true;
            System.out.println("Filosofo Atomico" + index +" mangia");
            textAreaLog.append("Filosofo Atomico [" + index + "] mangia ...\n");
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
