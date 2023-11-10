class MyBlockingQueue {
    //基于数组来实现队列
    private int[] items = new int[1000];
    //约定队列中的有效元素
    volatile private int head = 0;
    volatile private int tail = 0;
    volatile private int size = 0;
    //入队列
    synchronized public void put(int num) throws InterruptedException {
        if (size == items.length) {
//            System.out.println("队列已满");
//            return;
            //队列满时入队列-->阻塞等待
            this.wait();
        }
        //把新元素放在tail位置
        items[tail] = num;
        tail++;
        //此时如果tail达到了末尾，就需要从头再来
        if(tail == items.length) {
            tail = 0;
        }
        size++;
        //有元素入队列时，唤醒wait
        this.notify();
    }
    //出队列
    synchronized public Integer take() throws InterruptedException {
        //队列为空
        while (size == 0) {
//            return null;
            //队列空时出队列-->阻塞等待
            this.wait();
        }
        int value = items[head];
        head++;
        //出元素到空了
        if (head == items.length) {
            head = 0;
        }
        size--;
        //有元素出队列时，唤醒wait
        this.notify();
        return value;
    }
}
public class Thread_Test22 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue();

        //生产者
        Thread t1 = new Thread(() -> {
            int value = 0;
            while (true) {
                try {
                    System.out.println("生产元素：" + value);
                    queue.put(value);
                    value++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();

        //消费者
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    int value = queue.take();
                    System.out.println("消费元素：" + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t2.start();
    }
}