package com.mhtmalpani.mockitosession.mockito;

import com.mhtmalpani.mockitosession.calculatorExample.CalculatorService;
import com.mhtmalpani.mockitosession.calculatorExample.MathApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(MockitoJUnitRunner.class)
public class InorderTest {

    private MathApplication classUnderTest;

    @Mock
    CalculatorService mockedService;

    @Before
    public void setUp() throws Exception {

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedService);
    }


    @Test
    public void test_operators_usingMock_justVerify() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);
        when(mockedService.multiply(3, 5)).thenReturn(15);
        when(mockedService.subtract(7, 4)).thenReturn(3);

        assertEquals(5, classUnderTest.add(2, 3));
        assertEquals(15, classUnderTest.multiply(3, 5));
        assertEquals(3, classUnderTest.subtract(7, 4));

        verify(mockedService).add(2, 3);
        verify(mockedService).subtract(7, 4);
        verify(mockedService).multiply(3, 5);
    }


    @Test
    public void test_operators_usingMock_verifyInOrder_failure() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);
        when(mockedService.multiply(3, 5)).thenReturn(15);
        when(mockedService.subtract(7, 4)).thenReturn(3);

        assertEquals(5, classUnderTest.add(2, 3));
        assertEquals(15, classUnderTest.multiply(3, 5));
        assertEquals(3, classUnderTest.subtract(7, 4));

        InOrder inOrder = inOrder(mockedService);

        inOrder.verify(mockedService).add(2, 3);
        inOrder.verify(mockedService).subtract(7, 4);
        inOrder.verify(mockedService).multiply(3, 5);
    }


    @Test
    public void test_operators_usingMock_verifyInOrder() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);
        when(mockedService.multiply(3, 5)).thenReturn(15);
        when(mockedService.subtract(7, 4)).thenReturn(3);

        assertEquals(5, classUnderTest.add(2, 3));
        assertEquals(15, classUnderTest.multiply(3, 5));
        assertEquals(3, classUnderTest.subtract(7, 4));

        InOrder inOrder = inOrder(mockedService);

        inOrder.verify(mockedService).add(2, 3);
        inOrder.verify(mockedService).multiply(3, 5);
        inOrder.verify(mockedService).subtract(7, 4);
    }

}
