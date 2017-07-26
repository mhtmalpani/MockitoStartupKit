package com.mhtmalpani.mockitosession.mockito;

import com.mhtmalpani.mockitosession.calculatorExample.CalculatorService;
import com.mhtmalpani.mockitosession.calculatorExample.MathApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
public class VerifyBehaviorTest {

    private MathApplication classUnderTest;

    @Mock
    CalculatorService mockedService;

    @Before
    public void setUp() throws Exception {

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedService);
    }


    @Test
    public void test_addition_usingMock_verifyBehavior() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedService).add(2, 3);
    }


    @Test
    public void test_multiplication_usingMock_verifyBehavior_NoInvocationError() throws Exception {

        when(mockedService.multiply(3, 5)).thenReturn(15);

        assertEquals(15, classUnderTest.multiply(3, 5));

        verify(mockedService).add(3, 5);
    }
}
