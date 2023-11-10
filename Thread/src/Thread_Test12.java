public class Thread_Test12 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello t");
        });

        System.out.println(t.getState());

        t.start();
    }
}
