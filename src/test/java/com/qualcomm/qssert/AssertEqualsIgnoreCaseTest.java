package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertEqualsIgnoreCaseTest extends AssertBaseTest {

    @Test
    public void passAssertEqualsIgnoreCaseExtendedLoggingTest() {
        QssertService.assertEqualsIgnoreCase("my QssertService.assertion %s", "ABC", "abc", "is going to pass");
    }

    @Test
    public void passAssertEqualsIgnoreCaseStringTest() {
        QssertService.assertEqualsIgnoreCase("ABC", "abc");
    }

    @Test
    public void passAssertEqualsIgnoreCaseLowerStringTest() {
        QssertService.assertEqualsIgnoreCase("abc", "abc");
    }

    @Test
    public void passAssertEqualsIgnoreCaseIntegerTest() {
        QssertService.assertEqualsIgnoreCase("1", "1");
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsIgnoreCaseStringTest() {
        QssertService.assertEqualsIgnoreCase("ABCD", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsIgnoreLowerCaseStringTest() {
        QssertService.assertEqualsIgnoreCase("abcd", "abc");
    }

}
