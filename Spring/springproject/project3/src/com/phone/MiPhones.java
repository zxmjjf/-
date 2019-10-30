package com.phone;

import java.io.FileNotFoundException;

public class MiPhones implements Phone {
    /*私有域*/
    private String model;

    //************************************************************************

    /*构造器*/
    public MiPhones() {

    }

    public MiPhones(String model) {
        this.model = model;
    }

    //************************************************************************

    /*setter 方法*/
    public void setModel(String model) {
        this.model = model;
    }

    //************************************************************************

    /*继承*/
    @Override
    public void open() {
        System.out.println("小米手机，用心创造服务！");
    }

    @Override
    public void close() {
        System.out.println("小米手机，追求卓越品质！");
    }

    @Override
    public String[] runProgram(String program) {
        System.out.println(program + "正在运行....");
        open();
        try {
            throwException();
        } catch (FileNotFoundException ignored) {

        }
        return new String[]{program, "jjf1"};
    }

    @Override
    public String toString() {
        return "Model: " + model;
    }
}
