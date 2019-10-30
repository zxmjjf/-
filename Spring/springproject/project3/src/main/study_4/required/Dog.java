package main.study_4.required;

public class Dog {
    Eatting dogEat;

    public Dog() {

    }

    public Dog(Eatting eatting) {
        dogEat = eatting;
        System.out.println("构造器被调用。。。");
    }

    //@Required
    public void setDogEat(Eatting dogEat) {
        System.out.println("set方法被调用！");
        this.dogEat = dogEat;
    }

    public void postConstructor() {
        System.out.println("postConstructor");
    }
}
