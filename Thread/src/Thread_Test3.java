class MyRunnable implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("hello t");
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Thread_Test3 {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();

        while(true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
