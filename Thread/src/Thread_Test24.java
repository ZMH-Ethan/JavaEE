import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class MyTask implements Comparable<MyTask>{
    public Runnable runnable;
    public long time;  //时间戳（当前时间与基准时间1970年01月01日00点的毫秒数之差）

    //MyTask构造方法
    public MyTask(Runnable runnable,long delay) {
        this.runnable = runnable;
        //取当前时间戳加上delay，就是我们任务要执行的时间戳
        this.time = delay + System.currentTimeMillis();
    }

    @Override
    public int compareTo(MyTask o) {
        //这样写意味着每次取出的是时间最小的元素
        return (int)(this.time - o.time);
    }
}

class MyTimer {
    private BlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    //创建一个锁对象
    private Object locker = new Object();

    public void schedule(Runnable runnable,long delay) throws InterruptedException {
        //根据参数构造MyTask，直接插入队列即可
        MyTask myTask = new MyTask(runnable,delay);
        queue.put(myTask);
        synchronized (locker) {
            locker.notify();
        }
    }

    public MyTimer() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        MyTask myTask = queue.take();
                        long curTime = System.currentTimeMillis();  //获取当前时间
                        if (myTask.time <= curTime) {
                            //时间到了，执行任务
                            myTask.runnable.run();
                        }else {
                            //时间还没到,把刚才取出的任务重新塞回队列
                            queue.put(myTask);
                            locker.wait(myTask.time - curTime);  //加上wait等待到规定时间再执行，如果加上了新元素，就唤醒wait，重新取队首元素并判定
                        }
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        thread.start();
    }
}
public class Thread_Test24 {
    public static void main(String[] args) throws InterruptedException {
        MyTimer mytimer = new MyTimer();
        mytimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 4");
            }
        },4000);
        mytimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        },3000);
        mytimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        },2000);
        mytimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        },1000);
        System.out.println("hello 0");
    }
}
