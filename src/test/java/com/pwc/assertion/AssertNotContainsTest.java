package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNotContainsTest extends AssertBaseTest {

    @Test
    public void passAssertNotContainsExtendedLoggingTest() {
        AssertService.assertNotContains("my AssertService.assertion %s %s", "afoobarbc", "foobars", 777, "is going to pass");
    }

    @Test
    public void passAssertNotContainsStringTest() {
        AssertService.assertNotContains("abcdefghi", "z");
    }

    @Test
    public void passAssertNotContainsCaseSensitiveTest() {
        AssertService.assertNotContains("ABCDEFGHI", "def");
    }

    @Test
    public void passAssertNotContainsSpaceTest() {
        AssertService.assertNotContains("abcdefghi", " ");
    }

    @Test
    public void passAssertNotContainsLoggingTest() {
        AssertService.assertNotContains("my AssertService.assertion will pass", "abc", "abcd");
    }

    @Test
    public void passAssertNotContainsLongerStringTest() {
        AssertService.assertNotContains("foobar", "afoobarbc");
    }

    @Test
    public void passAssertNotContainsSimilarStringTest() {
        AssertService.assertNotContains("abcdefghi", "de f");
    }

    @Test
    public void passAssertNotContainsInvalidCaseStringTest() {
        AssertService.assertNotContains("abcdefghi", "deF");
    }

    @Test
    public void passAssertNotContainsSourceBlankTest() {
        AssertService.assertNotContains("", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotContainsBlankTest() {
        AssertService.assertNotContains("abcdefghi", "");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotContainsCaseSensitiveTest() {
        AssertService.assertNotContains("ABCDEFGHI", "A");
    }

    @Test(expected = NullPointerException.class)
    public void failAssertNotContainsNullTest() {
        AssertService.assertNotContains("abcdefghi", null);
    }

}
