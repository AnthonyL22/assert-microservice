package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNotContainsTest extends AssertBaseTest {

    @Test
    public void passAssertNotContainsExtendedLoggingTest() {
        QssertService.assertNotContains("my QssertService.assertion %s %s", "afoobarbc", "foobars", 777, "is going to pass");
    }

    @Test
    public void passAssertNotContainsStringTest() {
        QssertService.assertNotContains("abcdefghi", "z");
    }

    @Test
    public void passAssertNotContainsCaseSensitiveTest() {
        QssertService.assertNotContains("ABCDEFGHI", "def");
    }

    @Test
    public void passAssertNotContainsSpaceTest() {
        QssertService.assertNotContains("abcdefghi", " ");
    }

    @Test
    public void passAssertNotContainsLoggingTest() {
        QssertService.assertNotContains("my QssertService.assertion will pass", "abc", "abcd");
    }

    @Test
    public void passAssertNotContainsLongerStringTest() {
        QssertService.assertNotContains("foobar", "afoobarbc");
    }

    @Test
    public void passAssertNotContainsSimilarStringTest() {
        QssertService.assertNotContains("abcdefghi", "de f");
    }

    @Test
    public void passAssertNotContainsInvalidCaseStringTest() {
        QssertService.assertNotContains("abcdefghi", "deF");
    }

    @Test
    public void passAssertNotContainsSourceBlankTest() {
        QssertService.assertNotContains("", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotContainsBlankTest() {
        QssertService.assertNotContains("abcdefghi", "");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotContainsCaseSensitiveTest() {
        QssertService.assertNotContains("ABCDEFGHI", "A");
    }

    @Test(expected = NullPointerException.class)
    public void failAssertNotContainsNullTest() {
        QssertService.assertNotContains("abcdefghi", null);
    }

}
