package com.cha.bridge.v4;

public class WarmGift extends Gift {
    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }

    @Override
    public String toString() {
        return "WarmGift{}";
    }
}
