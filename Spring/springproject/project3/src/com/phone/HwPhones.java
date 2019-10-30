package com.phone;

public class HwPhones implements Phone {
    /*私有域*/
    private String model;


    //************************************************************************

    /*构造器*/
    public HwPhones() {

    }

    public HwPhones(String model) {
        this.model = model;
    }

    //************************************************************************

    /*setter 方法*/
    public void setModel(String model) {
        this.model = model;
    }

    //************************************************************************
    @Override
    public void open() {
        System.out.println("华为，只为带来美好~");
    }

    @Override
    public void close() {
        System.out.println("华为，为您准备就绪~");
    }

    @Override
    public String[] runProgram(String program) {
        System.out.println(program + ": 运行中.....");
        return new String[]{program};
    }

    @Override
    public String toString() {
        return "Model: " + model;
    }
}
