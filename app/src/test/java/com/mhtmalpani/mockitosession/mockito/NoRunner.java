package com.mhtmalpani.mockitosession.mockito;

import com.mhtmalpani.mockitosession.calculatorExample.CalculatorService;
import com.mhtmalpani.mockitosession.calculatorExample.MathApplication;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

public class NoRunner {

    private MathApplication classUnderTest;

    @Mock
    CalculatorService mockedService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedService);
    }


    @Test
    public void test_addition_usingMock() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);

        assertEquals(5, classUnderTest.add(2, 3));

        verify(mockedService).add(2, 3);
    }
}
