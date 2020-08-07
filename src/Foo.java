import java.util.concurrent.CountDownLatch;

public class Foo {
    private  CountDownLatch cdl1 = new CountDownLatch(1);
    private CountDownLatch cdl2 = new CountDownLatch(2);

    public void first(Runnable r) {

        System.out.print("first");
        cdl1.countDown();
        cdl2.countDown();
    }
    public void second(Runnable r) {

        try {
            cdl1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("second");
        cdl2.countDown();

    }
    public void third(Runnable r) {
        try {
            cdl2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("third");

    }

}
