package model;

import java.util.LinkedList;

/* monitor TavolaAtomica per la gestione atomica delle bacchette */
public class TavolaCoda {
    private boolean b[];        // le bacchette
    private final int NFIL;     // il numero di filosofi
    private LinkedList<Integer> coda;// coda esplicita

    // crea le NFIL bacchette e le inizializza a true (presenti)
    // NOTA: non serve sincronizzarlo e' prima della creazione dei filosofi
    TavolaCoda(int i) { 
        int j;
        NFIL=i;                 // memorizza il numero dei filosofi
        b = new boolean[NFIL];  // crea le bacchette
        for (j=0;j<NFIL;j++)    // inizializza le bacchette a true
            b[j] = true;
        coda = new LinkedList<Integer>();   // crea la coda esplicita
    }
    // raccoglie le bacchette in modo atomico
    synchronized void raccogli(int i) throws InterruptedException {
        // accoda il filosofo
        coda.add(i);

        // finche' non è il primo della coda o non ci sono le due bacchette o attende
        while (i != coda.peek() || !(b[i] && b[(i+1)%NFIL]))
            wait();

        // toglie il filosofo dalla coda
        coda.remove();
            
        // raccoglie entrambe le bacchette
        b[i]=false;             // deposita la bacchetta sx
        b[(i+1)%NFIL] = false;  // deposita la bacchetta dx
        notifyAll();            // notifica eventuali filosofi che 
                                // potrebbero mangiare ma non erano i primi
                                // della coda
    }
    // deposita entrambe le bacchette e notifichiamo TUTTI i filosofi
    synchronized void deposita(int i) {
        b[i]=true;              // deposita la bacchetta sx
        b[(i+1)%NFIL] = true;   // deposita la bacchetta dx
        notifyAll();            // notifica tutti i filosofi
    }
}

