package com.mhtmalpani.mockitosession.bonus;

import com.mhtmalpani.mockitosession.mockito.AddingBehaviorTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created on April 20, 2017
 *
 * @author Mohit Malpani
 */

public class TestRunner {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(AddingBehaviorTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
