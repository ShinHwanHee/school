package com.Shin0507;

public class ModifyAmountThread extends Thread{
    private CommonCalculate calc;
    private boolean addflag;
    public ModifyAmountThread(CommonCalculate calc, boolean addflag) {
        this.calc=calc;
        this.addflag=addflag;
    }
    public void run(){
        for(int loop=0;loop<10000;loop++){
            if(addflag) {
                calc.plus(1);
            }else {
                calc.minus(1);
            }
        }
    }
}
