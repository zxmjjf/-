package main.java.auto_configure.child;

import main.java.auto_configure.Services;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author jjf
 * @version 2019-10-22 17:42
 * <decribe>测试bean自动装配</decribe>
 */

@Component
public class Customer {
    @Qualifier("servicesJjf")
    @Autowired //等价于xml文件的property元素 + setter方法
    private Services services;

    /*@Autowired
    private int anInt;*/
    /*public Customer(Services service) {
        this.services = service;
        System.out.println("Customer 构造器");
    }*/

    public void setServices(Services services) {
        System.out.println("setter方法");
        this.services = services;
    }

    public Services getServices() {
        return services;
    }

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/java/auto_configure/Auto-configure.xml");
        Customer customer = factory.getBean("customer", Customer.class);
        customer.getServices().say();

    }
}
