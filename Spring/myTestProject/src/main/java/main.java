import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import robots.Chacki;

/**
 * Created by iliashebanov on 14.04.17.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com.xml");
        Chacki chacki = (Chacki) applicationContext.getBean("chacki");
        chacki.dance();
        chacki.action();
    }
}
