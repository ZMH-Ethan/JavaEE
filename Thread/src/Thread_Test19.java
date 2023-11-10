class B {
    volatile private static B instance = null;

//    public static B getInstance() {
//        if (instance == null) {
//            synchronized (B.instance) {
//                instance = new B();
//            }
//        }
//        return instance;
//    }

//    public static B getInstance() {
//        synchronized (B.instance) {
//            if (instance == null) {
//                instance = new B();
//            }
//        }
//        return instance;
//    }
public static B getInstance() {
    if (instance == null) {
        synchronized (instance) {
            if (instance == null) {
                instance = new B();
            }
        }
    }
    return instance;
}

    private B() {
    }
}
public class Thread_Test19 {
    public static void main(String[] args) {
        B instance1 = B.getInstance();
        B instance2 = B.getInstance();
        System.out.println(instance1 == instance2);
    }
}
