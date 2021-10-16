package com.cha.bridge.v4;

public class GG {
    public static void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    public static void give(MM mm, Gift g) {
        System.out.println(g + "gived!");
    }

    public static void main(String[] args) {
        MM m = new MM();
        GG.chase(m);
    }
}
