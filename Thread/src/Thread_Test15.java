import java.util.Scanner;

public class Thread_Test15 {
//    public static int flag = 0;
    volatile public static int flag = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag == 0) {

            }
            System.out.println("循环结束，t1线程结束");
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数： ");
            flag = scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}