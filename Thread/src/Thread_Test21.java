import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Thread_Test21 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        //生产者
        Thread t1 = new Thread(() -> {
            int value = 0;
            while (true) {
                try {
                    System.out.println("生产元素：" + value);
                    queue.put(value);
                    value++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();

        //消费者
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    int value = queue.take();
                    System.out.println("消费元素：" + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t2.start();
    }
}
