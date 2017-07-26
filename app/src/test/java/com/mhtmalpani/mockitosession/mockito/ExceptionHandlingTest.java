package com.mhtmalpani.mockitosession.mockito;

import com.mhtmalpani.mockitosession.calculatorExample.CalculatorService;
import com.mhtmalpani.mockitosession.calculatorExample.MathApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlingTest {

    private MathApplication classUnderTest;

    @Mock
    CalculatorService mockedService;

    @Before
    public void setUp() throws Exception {

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedService);
    }


    @Test
    public void test_addition_noMock_exception() throws Exception {

        assertEquals(5, classUnderTest.add(2, 3));
    }


    @Test (expected = RuntimeException.class)
    public void test_addition_usingMock_exception() throws Exception {

        doThrow(new RuntimeException("Not Implemented"))
                .when(mockedService)
                .add(anyInt(), anyInt());

        assertEquals(5, classUnderTest.add(2, 3));
    }

}
