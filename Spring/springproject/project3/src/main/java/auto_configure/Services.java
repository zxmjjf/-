package main.java.auto_configure;


import org.springframework.stereotype.Component;

@Component
public class Services {
    public Services() {
        System.out.println("Services 构造器");
    }

    public void say() {
        System.out.println("Services: I can do for any things whit you!");
    }
}
