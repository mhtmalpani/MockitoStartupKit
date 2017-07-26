package com.mhtmalpani.mockitosession.calculatorExample;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

public class MathApplication {

    private CalculatorService mCalculatorService;

    public void setCalculatorService(CalculatorService mCalculatorService) {
        this.mCalculatorService = mCalculatorService;
    }

    public int add(int a, int b) {
        return mCalculatorService.add(a, b);
    }

    public int subtract(int a, int b) {
        return mCalculatorService.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return mCalculatorService.multiply(a, b);
    }

    public double divide(int a, int b) {
        return mCalculatorService.divide(a, b);
    }

}
