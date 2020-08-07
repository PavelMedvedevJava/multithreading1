import java.util.concurrent.CountDownLatch;

public class Main {

    private static Foo foo = new Foo();

    public static void main(String[] args) {

        Thread a = new Thread(new Thread1());
        Thread b = (new Thread(new Thread2()));
        Thread c = (new Thread(new Thread3()));


        c.start();
        b.start();
        a.start();



    }

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            foo.first(this);
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            foo.second(this);
        }
    }

    public static class Thread3 implements Runnable {

        @Override
        public void run() {
            foo.third(this);
        }
    }

}
