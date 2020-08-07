import java.util.concurrent.CountDownLatch;

public class Foo {
    private  CountDownLatch start2Thread = new CountDownLatch(1);
    private CountDownLatch start3Thread = new CountDownLatch(2);

    public void first(Runnable r) {

        System.out.print("first");
        start2Thread.countDown();
        start3Thread.countDown();
    }
    public void second(Runnable r) {

        try {
            start2Thread.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("second");
        start3Thread.countDown();

    }
    public void third(Runnable r) {
        try {
            start3Thread.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("third");

    }

}
