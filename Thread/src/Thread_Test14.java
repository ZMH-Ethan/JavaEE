public class Thread_Test14 {
    public static void main(String[] args) {

    }
}
class Counter2 {
    private int count = 100000;

    synchronized public static void test() {

    }

    public static void test2() {
        synchronized (Counter.class) {

        }
    }


//    synchronized public void add() {
//            count++;
//    }

//    public void add() {
//        synchronized (this) {
//            count++;
//        }
//    }


    public int getCount() {
        return count;
    }
}