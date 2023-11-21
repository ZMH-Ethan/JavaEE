import javax.rmi.CORBA.Tie;

public class IoCTest {
    public static void main(String[] args) {
        Tire tire = new Tire(20);
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.run();
    }

    static class Car {
        private Framework framework;
        public Car(Framework framework) {
            this.framework = framework;
        }
        public void run() {
            framework.init();
        }
    }

    static class Framework {
        private Bottom bottom;
        public Framework(Bottom bottom) {
            this.bottom = bottom;
        }
        public void init() {
            bottom.init();
        }
    }

    static class Bottom {
        private Tire tire;
        public Bottom(Tire tire) {
            this.tire = tire;
        }
        public void init() {
            tire.init();
        }
    }

    static class Tire {
        private int size;
        public Tire(int size) {
            this.size = size;
        }
        public void init() {
            System.out.println("轮胎： " + size);
        }
    }
}
