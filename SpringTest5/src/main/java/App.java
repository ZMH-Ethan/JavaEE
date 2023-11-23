import com.java.Ethan.Controller.UserController;
import com.java.Ethan.Model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserController userController = context.getBean("userController", UserController.class);
        System.out.println(userController.getUser().toString());
    }
}
