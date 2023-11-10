public class Thread_Test9 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            // currentThread 是获取到当前线程实例.
            // 此处 currentThread 得到的对象就是 t
            // isInterrupted 就是 t 对象里自带的一个标志位.
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello t");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
            }
        });
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 把 t 内部的标志位给设置成 true
        t.interrupt();
    }
}
