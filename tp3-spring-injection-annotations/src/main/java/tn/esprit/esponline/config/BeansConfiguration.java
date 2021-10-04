package tn.esprit.esponline.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/* Use @Configuration annotation to tell spring AnnotationConfigApplicationContext that this class is bean configuration java class. */

@Configuration
@ComponentScan("tn.esprit.esponline")
public class BeansConfiguration
{
}
