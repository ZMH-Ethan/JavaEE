import com.ww.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanExample {
    public static void main(String[] args) {
        //1、得到容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //2、获取Bean
        User user = context.getBean("user",User.class);
        //3、使用Bean
        System.out.println(user.sayHi("Ethan"));
    }
}
