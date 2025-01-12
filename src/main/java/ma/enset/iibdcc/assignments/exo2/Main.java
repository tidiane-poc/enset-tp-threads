package ma.enset.iibdcc.assignments.exo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int somme = 0;
        int length = 100_000;
        int tableSplit = 15;
        int[] array = new int[length];
        ExecutorService executorService = Executors.newFixedThreadPool(tableSplit);
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        for (int i = 0; i < tableSplit; i++) {
            int startIndex = i * (length / tableSplit);
            int endIndex = (i + 1) * (length / tableSplit);
            Sommeur sommeur = new Sommeur(array, startIndex, endIndex);
            executorService.execute(sommeur);
            somme += sommeur.getSomme();
        }
        executorService.shutdown();
        System.out.println("Somme finale : " + somme);

    }
}
