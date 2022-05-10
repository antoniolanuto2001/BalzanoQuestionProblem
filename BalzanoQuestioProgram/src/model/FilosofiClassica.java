package model;

import java.nio.file.ProviderNotFoundException;

import javax.swing.JTextArea;

public class FilosofiClassica implements Runnable 
{
    final int index;       // indice locale del filosofo
    public JTextArea textAreaLog ;
    private boolean exit;
    public boolean pronto;
    public int tempoPensa;
    public int tempoMangia;
    public int tempoEsecuzione;
    public boolean deadlockCheck;
    private int iterazioniDeadlock;
    static final int NTHREAD=5;             // numero di filosofi
    static TavolaClassica tavolaClassica= new TavolaClassica(NTHREAD);   // monitor statico/condiviso
    
    /**
     * @brief Costruttore
     * 
     * @param i Index del Filosofo
     */
    public FilosofiClassica(int i ,JTextArea logEntraneTextArea)
    {
        index = i;
        exit = true;
        pronto = false;
        textAreaLog=logEntraneTextArea;
        deadlockCheck=false;
        tempoPensa=500;
        tempoMangia=800;
        tempoEsecuzione=500;
        iterazioniDeadlock=0;
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
        	System.out.println("Il filosofo "+index+" e' partito ");
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
        	pronto = false;
        	 Thread.sleep(tempoPensa);
             System.out.println("Filosofo ["+ index +"] pensa a :  "+ tempoPensa + "  velocita ");
             textAreaLog.append("Filosofo ["+ index +"] pensa ... \n");
             tavolaClassica.raccogli_sx(index);   // raccoglie la bacchetta sinistra
    
            // Decommentare per forzare lo stallo
            //Thread.sleep(1000);
            tavolaClassica.raccogli_dx(index);   // raccoglie la bacchetta destra
            if (tempoPensa==tempoMangia &&tempoMangia==3000) 
            {
				iterazioniDeadlock++;
				if (iterazioniDeadlock==3) 
				{
					deadlockCheck=true;
					stop();
				}
			}
            else 
            {
            	iterazioniDeadlock=0;
			}
            //MANGIA
            pronto = true;
            Thread.sleep(tempoMangia);
            System.out.println("Filosofo [" + index + "] mangia a : "+ tempoMangia + "  velocita ");
            textAreaLog.append("Filosofo [" + index + "] mangia ...\n");
            tavolaClassica.deposita_sx(index);   // deposita la bacchetta sinistra
            tavolaClassica.deposita_dx(index);   // deposita la bacchetta destra 
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
    	iterazioniDeadlock=0;
    }
    /**
     * @brief Funzione che Riavvia l' Esecuzione del thread associato
     */
    
    public void resume()
    {
    	exit = true;
    	pronto = false;
    	iterazioniDeadlock=0;
    	deadlockCheck=false;
    }
   
}
