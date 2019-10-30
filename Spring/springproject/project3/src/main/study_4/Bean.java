package main.study_4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/study_4/bean-configure.xml");

        Student student = factory.getBean("nonConstructor", Student.class);
        System.out.println(student.toString());
    }
}
