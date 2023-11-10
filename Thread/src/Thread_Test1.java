public class Thread_Test1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello MyThread");
    }
}