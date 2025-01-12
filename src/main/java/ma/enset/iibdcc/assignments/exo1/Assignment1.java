package ma.enset.iibdcc.assignments.exo1;

public class Assignment1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(new Talkative("Thread " + i, i*20)).start();
        }
    }
}
