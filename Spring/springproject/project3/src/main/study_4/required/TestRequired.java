package main.study_4.required;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRequired {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/study_4/required/required.xml");

        Dog dog = factory.getBean("dog1", Dog.class);
        //dog.setDogEat(new Eatting());
        dog.dogEat.eat();
    }
}
