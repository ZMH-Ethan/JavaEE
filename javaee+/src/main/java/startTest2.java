import com.ww.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.security.cert.X509Certificate;

public class startTest2 {
    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        User user = (User) beanFactory.getBean("user");
        System.out.println(user.sayHi("Ethan"));
    }
}
