package com.cha.factorymethod;

public class Main {
    public static void main(String[] args) {
        Moveable m = CarFactory.create();
        Moveable m1 = CarFactory.create();
        System.out.println(m==m1);
        System.out.println(m.hashCode());
        System.out.println(m1.hashCode());
        m.go();
    }
}
