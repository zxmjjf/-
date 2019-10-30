package main.study_4.configuration;

public class Cat implements Animal {
    private String name = null;
    @Override
    public void say() {
        System.out.println(name + ": 喵..喵...");
    }

    @Override
    public void food() {

    }

    /*setter 方法*/
    public void setName(String name) {
        this.name = name;
    }
}
