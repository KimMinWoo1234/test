package com.minwoo_20220507;

public class CommonCalcultate {
    private  int amount;
    public CommonCalcultate() {
        amount = 0;
    }
    public synchronized void plus(int value) {
        amount += value;
    }
    public synchronized void minus(int value) {
        amount -= value;
    }
    public synchronized int getAmount() {
        return amount;
    }
}
