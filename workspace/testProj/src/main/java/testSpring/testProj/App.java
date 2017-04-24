package testSpring.testProj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext testName = new ClassPathXmlApplicationContext("context.xml");
		// Model501 model501 = (Model501) testName.getBean("m501");
		// model501.dance();
		// model501.action();
	}
}
