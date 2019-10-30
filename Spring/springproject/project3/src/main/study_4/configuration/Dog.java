package main.study_4.configuration;

public class Dog implements Animal {
    private String name = null;
    @Override
    public void say() {
        System.out.println(name + ": 汪..汪..");
    }
    /* setter 方法*/
    public void setName(String name) {
        this.name = name;
    }

    public void food() {
        System.out.println("Dogs eat bones...");
    }
}
