package main.java.com.shiyanlou.demo;

import main.java.com.shiyanlou.demo.helloworld.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorld.class);
        HelloWorld obj = context.getBean("bean1",HelloWorld.class);
        HelloWorld obj1 = (HelloWorld) context.getBean("bean2");
        context.getBean("bean3");

        obj.printHello();
        obj1.printHello();
    }
}

