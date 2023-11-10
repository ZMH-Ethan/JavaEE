public class Thread_Test8 {
    public static boolean isQuit = false;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while(!isQuit) {
                System.out.println("hello t");
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t线程结束");
        });

        t.start();

        //在主线程中修改isQuit
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isQuit = true;
    }
}
