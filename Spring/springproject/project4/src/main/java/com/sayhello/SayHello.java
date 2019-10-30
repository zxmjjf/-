package main.java.com.sayhello;

public class SayHello {
    private String context = "Hello World";
    private String people = "jjf";

    public void setContext(String context) {
        this.context = context;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public void sayHello() {
        System.out.println(people + ": " + context);
    }

}
