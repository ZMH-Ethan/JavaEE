class Counter {
    private int count = 100000;
    public void add() {
        synchronized (this) {
            count++;
        }
    }
    public int getCount() {
        return count;
    }
}
public class Thread_Test13 {
    public static void main(String[] args) throws InterruptedException{

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });

        t1.start();
        t2.start();

        //等两个线程结束查看结果
        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}
