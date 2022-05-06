package model;

public class TavolaAtomica 
{
    private boolean b[];        // le bacchette
    private final int NFIL;     // il numero di filosofi
    // crea le NFIL bacchette e le inizializza a true (presenti)
    // NOTA: non serve sincronizzarlo e' prima della creazione dei filosofi
    
    TavolaAtomica(int i) 
    { 
        int j;
        NFIL=i;                 // memorizza il numero dei filosofi
        b = new boolean[NFIL];  // crea le bacchette
        for (j=0;j<NFIL;j++)    // inizializza le bacchette a true
            b[j] = true;
    }
    // raccoglie le bacchette in modo atomico
    synchronized void raccogli(int i) throws InterruptedException
    {
        // finche' non ci sono le due bacchette attende
        while (!(b[i] && b[(i+1)%NFIL]))
            wait();
            
        // raccoglie entrambe le bacchette
        b[i]=false;             // deposita la bacchetta sx
        b[(i+1)%NFIL] = false;  // deposita la bacchetta dx
    }
    // deposita entrambe le bacchette e notifichiamo TUTTI i filosofi
    synchronized void deposita(int i) 
    {
        b[i]=true;              // deposita la bacchetta sx
        b[(i+1)%NFIL] = true;   // deposita la bacchetta dx
        notifyAll();            // notifica tutti i filosofi
    }
}