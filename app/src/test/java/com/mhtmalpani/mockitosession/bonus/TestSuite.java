package com.mhtmalpani.mockitosession.bonus;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created on April 20, 2017
 *
 * @author Mohit Malpani
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ParameterizedTest.class,
        ParameterizedTestUsingConstructor.class
})
public class TestSuite {
}
