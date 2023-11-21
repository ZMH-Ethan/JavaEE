import com.Ethan.User;
import com.sun.javaws.ui.ApplicationIconGenerator;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class startClass {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("com.Ethan.User");
        BeanFactory context = new XmlBeanFactory(new ClassPathResource("com.Ethan.User"));
//        User user = (User) context.getBean("user");
        User user = context.getBean("user",User.class);
        System.out.println(user.sayHi("Ethan"));
    }
}
