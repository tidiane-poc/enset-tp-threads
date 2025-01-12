package ma.enset.iibdcc.assignments.exo2;

public class Sommeur implements Runnable {
    private int somme;
    private int startIndex;
    private int endIndex;
    private int[] array;

    public Sommeur(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }

    public int getSomme() {
        return somme;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " : " + startIndex + " - " + endIndex);
        for (int i = startIndex; i < endIndex; i++) {
            somme += array[i];
        }
    }
}
