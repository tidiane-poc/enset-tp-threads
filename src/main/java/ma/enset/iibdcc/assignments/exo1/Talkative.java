package ma.enset.iibdcc.assignments.exo1;

public class Talkative implements Runnable {
    private int count;
    private String name;

    public Talkative(String name, int count) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + " : " +count);
        }
    }
}
