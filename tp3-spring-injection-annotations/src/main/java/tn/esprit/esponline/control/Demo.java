package tn.esprit.esponline.control;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tn.esprit.esponline.config.BeansConfiguration;

public class Demo {

	
	public static void main(String[] args) {

		System.out.println("In verifyBeans() : ");

		// Chargement du Conteneur Spring IoC : 
		//context = new ClassPathXmlApplicationContext("tp1-beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);

		System.out.println("Contains userControl " + context.containsBeanDefinition("userControl"));
		System.out.println("Contains userServiceImpl " + context.containsBeanDefinition("userService"));
		System.out.println("Contains userRepository " + context.containsBeanDefinition("userRepository"));

		System.out.println("Out of verifyBeans() : ");
	}
}