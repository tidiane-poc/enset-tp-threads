package ma.enset.iibdcc.assignments.exo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int somme = 0;
        int length = 100_000;
        int tableSplit = 5;
        int[] array = new int[length];
        Sommeur[] sommeurs = new Sommeur[tableSplit];
        ExecutorService executorService = Executors.newFixedThreadPool(tableSplit);
        for (int i = 0; i < length; i++) {
            array[i] = i*2;
        }
        for (int i = 0; i < tableSplit; i++) {
            int startIndex = i * (length / tableSplit);
            int endIndex = (i == (tableSplit - 1)) ? length : (i + 1) * (length / tableSplit);
            Sommeur sommeur = new Sommeur(array, startIndex, endIndex);
            sommeurs[i] = sommeur;
            executorService.execute(sommeur);
        }
        executorService.shutdown();
        for (int i = 0; i < tableSplit; i++) {
            somme += sommeurs[i].getSomme();
//            System.out.println(sommeurs[i].toString());
        }
        System.out.println("Somme finale : " + somme);

    }
}
