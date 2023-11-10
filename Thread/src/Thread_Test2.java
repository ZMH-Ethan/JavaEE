class MyThread2 extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("hello t");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Thread_Test2 {
    public static void main(String[] args) {
        Thread t = new MyThread2();
        t.start();
        while(true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
