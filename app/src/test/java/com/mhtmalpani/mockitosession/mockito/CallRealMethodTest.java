package com.mhtmalpani.mockitosession.mockito;

import com.mhtmalpani.mockitosession.calculatorExample.Calculator;
import com.mhtmalpani.mockitosession.calculatorExample.MathApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(MockitoJUnitRunner.class)
public class CallRealMethodTest {

    private MathApplication classUnderTest;

    @Mock
    Calculator mockedObject;

    @Before
    public void setUp() throws Exception {

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedObject);
    }


    @Test
    public void test_addition_usingMock_stubbedMethod() throws Exception {

        when(mockedObject.add(2, 3)).thenReturn(10);

        assertEquals(10, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);
    }


    @Test
    public void test_addition_usingMock_stubbedMethod_Failure() throws Exception {

        when(mockedObject.add(2, 3)).thenCallRealMethod();

        assertEquals(10, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);
    }


    @Test
    public void test_addition_usingMock_stubbedMethod_callRealMethod() throws Exception {

        when(mockedObject.add(2, 3)).thenCallRealMethod();

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);
    }


    @Test(expected = RuntimeException.class)
    public void test_Exception() throws Exception {

        when(mockedObject.divide(anyInt(), anyInt())).thenCallRealMethod();

        classUnderTest.divide(18, 3);
    }
}
