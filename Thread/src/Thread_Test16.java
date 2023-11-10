public class Thread_Test16 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        System.out.println("wait之前");
        synchronized (object) {
            object.wait();
        }
        System.out.println("wait之后");
    }
}

