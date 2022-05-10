package model;

import java.util.LinkedList;

public class FilosofiCoda implements Runnable {
    static final int NTHREAD=5;             // numero di filosofi
    private boolean exit;
    public boolean pronto;
    public int tempoPensa;
    public int tempoMangia;
    public int tempoEsecuzione;
    final int index;                        // indice locale del filosofo
    static TavolaCoda t= new TavolaCoda(NTHREAD); // monitor statico/condiviso
    // il filosofo memorizza il proprio indice
    public FilosofiCoda(int i)
    {
        index = i;
        exit = true;
        pronto = false;
        tempoPensa=500;
        tempoMangia=800;
        tempoEsecuzione=500;
    }
    
    // il thread esegue il codiceFilosofo a meno di interruzioni
    @Override
    public void run()  {
        try { 
            codiceFilosofo(index);
        } catch (InterruptedException e) {
            System.out.println("Il filosofo "+index+" e' stato interrotto");
        }
    }
    // il filosofo pensa e mangia come al solito
    void codiceFilosofo(int index) throws InterruptedException {
        while(exit) {
        	
        	//PENSA
        	pronto = false;
        	Thread.sleep(tempoPensa);
            System.out.println("Filosofo  [" + index +"] pensa a :  "+ tempoPensa + "  velocita ");

            t.raccogli(index);  // raccoglie atomicamente le bacchette
          //MANGIA
            pronto = true;
            Thread.sleep(tempoMangia);
            System.out.println("Filosofo [" + index + "] mangia a : "+ tempoMangia + "  velocita ");
            t.deposita(index);  // deposita le bacchette
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
 
