import java.util.Timer;
import java.util.TimerTask;

public class Thread_Test23 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        },1000);
    }
}
