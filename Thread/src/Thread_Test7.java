public class Thread_Test7 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("存活ing");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("即将死亡");
        });
        t.start();

        System.out.println(Thread.currentThread().getName()+ ": ID: " + t.getId());
        System.out.println(Thread.currentThread().getName() + ": 名称: " + t.getName());
        System.out.println(Thread.currentThread().getName() + ": 状态: " + t.getState());
        System.out.println(Thread.currentThread().getName() + ": 优先级: " + t.getPriority());
        System.out.println(Thread.currentThread().getName() + ": 后台线程: " + t.isDaemon());
        System.out.println(Thread.currentThread().getName() + ": 存活: " + t.isAlive());
        System.out.println(Thread.currentThread().getName() + ": 被中断: " + t.isInterrupted());
    }
}
