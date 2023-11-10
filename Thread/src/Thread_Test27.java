import java.util.concurrent.atomic.AtomicInteger;

public class Thread_Test27 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num = new AtomicInteger(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                num.getAndIncrement();  //相当于num++
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                num.getAndIncrement();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //get()获取数值
        System.out.println(num.get());
    }
}
