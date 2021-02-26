package codingtest.hypc;

public class P2 implements Runnable {

    private String name;

    public P2(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new P2("1"));
        Thread t2 = new Thread(new P2("2"));
        Thread t3 = new Thread(new P2("3"));
        Thread t4 = new Thread(new P2("4"));
        Thread t5 = new Thread(new P2("5"));

        t5.start();
        t3.start();
        t1.start();
        t3.join();
        t2.start();
        t1.join();
        t4.start();
        t2.join();
        t4.join();
        t5.join();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(name);
        } catch (InterruptedException ignored) {
        }
    }
}
