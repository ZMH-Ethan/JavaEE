import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Thread_Test20 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        //put入队列
        queue.put("hello1");
        queue.put("hello2");
        queue.put("hello3");
        //take出队列
        String result = null;
        result = queue.take();
        System.out.println(result);
        result = queue.take();
        System.out.println(result);
        result = queue.take();
        System.out.println(result);
        result = queue.take();
        System.out.println(result);
    }
}
