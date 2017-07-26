package com.mhtmalpani.mockitosession.mockito;

import com.mhtmalpani.mockitosession.calculatorExample.Calculator;
import com.mhtmalpani.mockitosession.calculatorExample.MathApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    private MathApplication classUnderTest;

    @Spy
    Calculator mockedObject;

    @Before
    public void setUp() throws Exception {

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedObject);
    }


    @Test
    public void test_addition_usingMock_simpleCase() throws Exception {

        when(mockedObject.add(2, 3)).thenReturn(5);

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);
    }


    @Test
    public void test_addition_usingSpy() throws Exception {

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);
    }


    @Test
    public void test_addition_usingSpy_stubMethod_previousCaseFails() throws Exception {

        when(mockedObject.add(2, 3)).thenReturn(10);

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);
    }


    @Test
    public void test_addition_usingSpy_stubMethod() throws Exception {

        when(mockedObject.add(2, 3)).thenReturn(10);

        assertEquals(10, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);
    }


    @Test (expected = RuntimeException.class)
    public void test_addition_usingSpy_stubMethodAndActualMethod() throws Exception {

        when(mockedObject.add(2, 3)).thenReturn(10);

        assertEquals(10, classUnderTest.add(2, 3));

        verify(mockedObject).add(2, 3);


        classUnderTest.divide(16, 4);
    }

}
