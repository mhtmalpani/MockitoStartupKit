package com.mhtmalpani.mockitosession.bonus;

/**
 * Created on April 21, 2017
 *
 * @author Mohit Malpani
 */

public class VoidMethodClass {

    protected SomeOtherClass someOtherClass;

    public VoidMethodClass(SomeOtherClass someOtherClass) {
        this.someOtherClass = someOtherClass;
    }

    public void myMethod() {

        someOtherClass.foo();
    }
}
