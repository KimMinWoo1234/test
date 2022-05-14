package com.minwoo_20220507;

public class ModifyAmountThread extends Thread {
    private CommonCalcultate calc;
    private boolean addFlag;
    public ModifyAmountThread(CommonCalcultate calc, boolean addFlag) {
        this.calc = calc;
        this.addFlag = addFlag;
    }
    public  void run() {
        for(int loop = 0; loop< 10000; loop++) {
            if(addFlag) {
                calc.plus(1);
            } else {
                calc.minus(1);
            }
        }
    }
}
