package main.study_4.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigurationTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"main/study_4/configuration/Configuration.xml"});

        /*Animal dog = (Animal) context.getBean("myDog");
        dog.say();*/

        /*BeforeMethod.xml*/
        /*Animal dog = context.getBean("proxy", Animal.class);
        dog.say();
        dog.food();*/

        /*Configuration.xml*/
        Animal dog = context.getBean("proxy", Animal.class);
        dog.say();
        dog.food();


    }
}
