package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertEqualsIgnoreCaseTest extends AssertBaseTest {

    @Test
    public void passAssertEqualsIgnoreCaseExtendedLoggingTest() {
        AssertService.assertEqualsIgnoreCase("my AssertService.assertion %s", "ABC", "abc", "is going to pass");
    }

    @Test
    public void passAssertEqualsIgnoreCaseStringTest() {
        AssertService.assertEqualsIgnoreCase("ABC", "abc");
    }

    @Test
    public void passAssertEqualsIgnoreCaseLowerStringTest() {
        AssertService.assertEqualsIgnoreCase("abc", "abc");
    }

    @Test
    public void passAssertEqualsIgnoreCaseIntegerTest() {
        AssertService.assertEqualsIgnoreCase("1", "1");
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsIgnoreCaseStringTest() {
        AssertService.assertEqualsIgnoreCase("ABCD", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsIgnoreLowerCaseStringTest() {
        AssertService.assertEqualsIgnoreCase("abcd", "abc");
    }

}
