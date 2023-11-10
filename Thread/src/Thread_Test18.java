class A {
    //唯一实例
    private static A instance = new A();  //被static修饰，该属性是类的属性,jvm中，每个类的类对象只有唯一一份，类对象里的这个成员自然也是唯一一份

    //获取实例的方法
    public static A getInstance() {
        return instance;  //单纯的读操作
    }

    //禁止new实例(将构造方法设为private)
    private A(){}
}
public class Thread_Test18 {
    public static void main(String[] args) {
        A instance1 = A.getInstance();
        A instance2 = A.getInstance();
        //// 此时 s1 和 s2 是同一个对象!!
    }
}
