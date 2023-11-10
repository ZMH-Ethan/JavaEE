import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread_Test28 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //这只是创建了个任务
        Callable<Integer> callable = new Callable<Integer> () {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 1000; i++) {
                    sum += 1;
                }
                return sum;
            }
        };
        //还需要找个线程来完成这个任务
        //Thread不能直接传callable
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());
    }
}
