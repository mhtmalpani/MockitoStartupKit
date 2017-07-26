package com.mhtmalpani.mockitosession.mockito;

import com.mhtmalpani.mockitosession.calculatorExample.CalculatorService;
import com.mhtmalpani.mockitosession.calculatorExample.MathApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created on March 10, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(MockitoJUnitRunner.class)
public class AddingBehaviorTest {

    private MathApplication classUnderTest;

    @Mock
    CalculatorService mockedService;


    @Before
    public void setUp() throws Exception {

        classUnderTest = new MathApplication();
        classUnderTest.setCalculatorService(mockedService);
    }


    @Test
    public void test_addition_basic() throws Exception {

        classUnderTest.add(2, 3);
    }


    @Test
    public void test_addition_NotImplemented() {

        assertEquals(5, classUnderTest.add(2, 3));
    }


    @Test
    public void test_addition_usingMock_addedBehavior() throws Exception {

        when(mockedService.add(2, 3)).thenReturn(5);

        when(mockedService.add(3, 5)).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return 8;
            }
        });

        assertEquals(5, classUnderTest.add(2, 3));
        assertEquals(8, classUnderTest.add(3, 5));
    }


    @Test
    public void test_addition_usingMock_addedBehavior_matchAnything() throws Exception {

        when(mockedService.add(anyInt(), anyInt())).thenReturn(10);

        assertEquals(10, classUnderTest.add(2, 3));
    }

}
