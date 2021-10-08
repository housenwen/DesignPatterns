package com.cha.factorymethod;

public class CarFactory {
    public static Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
