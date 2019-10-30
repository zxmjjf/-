package com.phone;

import java.io.FileNotFoundException;

public interface Phone {
    void open();

    void close();

    /*用于返回增强*/
    String[] runProgram(String program);

    /*用于抛出增强*/
    default void throwException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    /*toString*/
    String toString();
}
