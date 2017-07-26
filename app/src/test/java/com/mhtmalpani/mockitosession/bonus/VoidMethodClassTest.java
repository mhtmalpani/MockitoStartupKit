package com.mhtmalpani.mockitosession.bonus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created on April 20, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(MockitoJUnitRunner.class)
public class VoidMethodClassTest {

    private VoidMethodClass classUnderTest;

    @Spy
    private SomeOtherClass someOtherClass;


    @Before
    public void setUp() throws Exception {

        classUnderTest = new VoidMethodClass(someOtherClass);
    }


    @Test
    public void testVoidMethod_Simple() throws Exception {

        classUnderTest.myMethod();

        verify(someOtherClass, times(1)).foo();
        verify(someOtherClass, times(1)).bar();
    }

    @Test
    public void testVoidMethod_doNothing() throws Exception {

        doNothing().when(someOtherClass).foo();

        classUnderTest.myMethod();

        verify(someOtherClass, never()).bar();
    }


    @Test (expected = RuntimeException.class)
    public void testVoidMethod_throwException() throws Exception {

        doThrow(new RuntimeException()).when(someOtherClass).foo();

        classUnderTest.myMethod();
    }
}

