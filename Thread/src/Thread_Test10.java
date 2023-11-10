public class Thread_Test10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello t");
        });
        t.start();

        t.join();

        System.out.println("hello main");
    }
}
