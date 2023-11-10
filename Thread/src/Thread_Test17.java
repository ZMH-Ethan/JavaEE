public class Thread_Test17 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("wait开始");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("wait结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();

        Thread.sleep(1000);

        Thread t2 = new Thread(() -> {
            synchronized (locker) {  //notify()也要放在synchronized中使用
                System.out.println("notify开始");
                locker.notify();
                System.out.println("notify结束");
            }
        });

        t2.start();
    }
}
