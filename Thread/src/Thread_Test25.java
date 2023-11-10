import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_Test25 {
    public static void main(String[] args) {
        //创建固定包含10个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //此处并非直接new一个对象，而是使用Executros中的一个静态方法完成对象的构造
        //这样的模式称为工厂模式（是为了解决构造方法重载的局限性）
        pool.submit(new Runnable() {  //ExecutorService类中的submit方法可以注册一个任务到线程池中
            @Override
            public void run() {
                System.out.println("haoleiou");
            }
        });
    }
}
