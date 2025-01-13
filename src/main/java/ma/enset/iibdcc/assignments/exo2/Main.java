package ma.enset.iibdcc.assignments.exo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int somme = 0;
        int length = 100_000;
        int tableSplit = 20;
        int[] array = new int[length];
        Sommeur[] sommeurs = new Sommeur[tableSplit];
        ExecutorService executorService = Executors.newFixedThreadPool(tableSplit);
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        for (int i = 0; i < tableSplit; i++) {
            int startIndex = i * (length / tableSplit);
            int endIndex = (i == (tableSplit - 1)) ? length : (i + 1) * (length / tableSplit);
            Sommeur sommeur = new Sommeur(array, startIndex, endIndex);
            sommeurs[i] = sommeur;
            executorService.execute(sommeur);
        }
        executorService.shutdown();

        try {
            boolean finished = executorService.awaitTermination(1, TimeUnit.MINUTES);
            if (finished) {
                for (int i = 0; i < tableSplit; i++) {
                    somme += sommeurs[i].getSomme();
                }
                int rightSum = (length * (length - 1)) / 2;
                System.out.println("Somme finale : " + somme + " Right sum : " + rightSum + " diff : " + (rightSum - somme));
            }else {
                System.out.println("Not all threads finished in time");
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

    }
}
