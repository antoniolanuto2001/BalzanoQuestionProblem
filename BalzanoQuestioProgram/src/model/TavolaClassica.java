package model;

/* monitor Tavola per la gestione delle bacchette */
public class TavolaClassica
{
    private boolean b[];        // le bacchette
    private final int NFIL;     // il numero di filosofi

    // crea le NFIL bacchette e le inizializza a true (presenti)
    // NOTA: non serve sincronizzarlo e' prima della creazione dei filosofi
    TavolaClassica(int i) 
    { 
        int j;
        NFIL=i;                 // memorizza il numero dei filosofi
        b = new boolean[NFIL];  // crea le bacchette
        for (j=0;j<NFIL;j++)    // inizializza le bacchette a true
            b[j] = true;
    }

    // raccoglie la bacchetta sinistra
    synchronized void raccogli_sx(int i) throws InterruptedException 
    {
        while (!b[i]) // finche' non e' disponibile attende
            wait();
            
        // raccoglie la bacchetta
        b[i]=false;
    }
    // raccoglie la bacchetta destra
    synchronized void raccogli_dx(int i) throws InterruptedException 
    {
        raccogli_sx((i+1)%NFIL); // la dx e' sx del filosofo successivo
    }   

    // deposita la bacchetta sinistra e notifica TUTTI i filosofi
    synchronized void deposita_sx(int i) {
        b[i]=true;      // raccoglie la bacchetta
        notifyAll();    // notifica tutti
    }
    // deposita la bacchetta destra e notifica TUTTI i filosofi
    synchronized void deposita_dx(int i) {
        deposita_sx((i+1)%NFIL); // la dx e' sx del filosofo successivo
    }   
}