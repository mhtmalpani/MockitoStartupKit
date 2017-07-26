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
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(MockitoJUnitRunner.class)
public class ExpectingCallsTest {

    private MathApplication classUnderTest;

    @Mock
    CalculatorService mockedService;

    @Before
    public void setUp() throws Exception {

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedService);
    }


    @Test
    public void test_addition_usingMock_expectingCalls_oneCall() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedService, times(1)).add(2, 3);
    }


    @Test
    public void test_addition_usingMock_expectingCalls_oneCall_wrongParams() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedService, times(1)).add(7, 3);
    }


    @Test
    public void test_operators_usingMock_expectingCalls_multipleCalls_fails() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);
        when(mockedService.multiply(3, 5)).thenReturn(15);

        assertEquals(5, classUnderTest.add(2, 3));
        assertEquals(15, classUnderTest.multiply(3, 5));

        verify(mockedService, times(2)).add(2, 3);
    }


    @Test
    public void test_operators_usingMock_expectingCalls_multipleCalls() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);
        when(mockedService.add(3, 5)).thenReturn(8);
        when(mockedService.multiply(3, 5)).thenReturn(15);

        assertEquals(5, classUnderTest.add(2, 3));
        assertEquals(8, classUnderTest.add(3, 5));
        assertEquals(15, classUnderTest.multiply(3, 5));

        verify(mockedService, times(2)).add(anyInt(), anyInt());
        verify(mockedService, times(1)).multiply(anyInt(), anyInt());
    }


    @Test
    public void test_operators_usingMock_expectingCalls_never() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);
        when(mockedService.multiply(3, 5)).thenReturn(15);

        assertEquals(5, classUnderTest.add(2, 3));
        assertEquals(15, classUnderTest.multiply(3, 5));

        verify(mockedService, times(1)).add(anyInt(), anyInt());
        verify(mockedService, times(1)).multiply(anyInt(), anyInt());

        verify(mockedService, never()).subtract(anyInt(), anyInt());
    }

}
