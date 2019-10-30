package main.study_4.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfigration {
    @Bean
    public Dog dog() {
        System.out.println("make dog]");
        Dog dog = new Dog();
        dog.setName("ImDog");
        return dog;
    }

    @Bean
    public Cat cat() {
        System.out.println("make cat]");
        return new Cat();
    }

    @Bean
    public BeforeSay beforeSay() {
        return new BeforeSay();
    }
}
