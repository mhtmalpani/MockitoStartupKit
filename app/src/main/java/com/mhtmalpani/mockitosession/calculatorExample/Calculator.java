package com.mhtmalpani.mockitosession.calculatorExample;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

public class Calculator implements CalculatorService {

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int subtract(int x, int y) {
        return x - y;
    }

    @Override
    public int multiply(int x, int y) {
        return x * y;
    }

    @Override
    public double divide(int x, int y) {
        throw new RuntimeException("Not Implemented");
    }
}
