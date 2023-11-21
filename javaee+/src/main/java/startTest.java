import com.ww.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class startTest {
    public static void main(String[] args) {
        //1、得到Spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //2、得到Bean[依赖查找--->IoC的一种实现]
        User user = (User) context.getBean("user");
        //3、使用Bean对象
        System.out.println(user.sayHi("Ethan"));
    }
}
