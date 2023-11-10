import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool {
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

    //此处实现固定数量的线程池
    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                try {
                    //需要在线程池内部有一个循环，保证一有任务就取
                    while (true) {
                        Runnable runnable = queue.take();
                        runnable.run();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
    }
}
public class Thread_Test26 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int num = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello dear " + num);
                }
            });
        }
    }
}
