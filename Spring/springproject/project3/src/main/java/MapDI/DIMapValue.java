package main.java.MapDI;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DIMapValue {
    Map<Object, Object> map;

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/java/MapDI/MapDI.xml");
        DIMapValue diMapValue = factory.getBean("map1", DIMapValue.class);
        System.out.println(diMapValue.getMap());
    }
}
