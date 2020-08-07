import java.util.concurrent.CountDownLatch;

public class Main {

    private static Foo foo = new Foo();

    private static CountDownLatch start2Thread = new CountDownLatch(1);
    private static CountDownLatch start3Thread = new CountDownLatch(2);


    public static void main(String[] args) {




        new Thread(new Thread3()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread1()).start();


    }

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            foo.first();
            start2Thread.countDown();
            start3Thread.countDown();
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            try {
                start2Thread.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foo.second();
            start3Thread.countDown();
        }
    }

    public static class Thread3 implements Runnable {

        @Override
        public void run() {
            try {
                start3Thread.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foo.third();

        }
    }

}
