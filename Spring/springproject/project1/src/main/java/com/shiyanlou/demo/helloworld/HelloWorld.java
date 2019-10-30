package main.java.com.shiyanlou.demo.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author jjf
 * <decribe>简单的打印字符串的类：输出</decribe>
 */
//@Component("HelloWorld")
//@Configuration
public class HelloWorld {

    private String name;

    private void setName(String n){
        this.name=n;
    }

    @Bean(name = "bean1")
    public HelloWorld getHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("jjf");
        return helloWorld;
    }

    @Bean(name = "bean2")
    public HelloWorld getHello1(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("zxm");
        return helloWorld;
    }

    @Bean(name = "bean3") //不能注解void方法
    public int printBean3() {
        System.out.println("通过bean3调用了此方法！");
        return 1;
    }

    public void printHello() {

        System.out.println(name);
    }
}
