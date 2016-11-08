package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertContainsTest extends AssertBaseTest {

    @Test
    public void passAssertContainsExtendedLoggingTest() {
        AssertService.assertContains("my AssertService.assertion %s %s", "afoobarbc", "foobar", 777, "is going to pass");
    }

    @Test
    public void passAssertContainsStringTest() {
        AssertService.assertContains("abcdefghi", "def");
    }

    @Test
    public void passAssertContainsCaseSensitiveTest() {
        AssertService.assertContains("ABCDEFGHI", "DEF");
    }

    @Test
    public void passAssertContainsBlankTest() {
        AssertService.assertContains("abcdefghi", "");
    }

    @Test
    public void passAssertContainsLoggingTest() {
        AssertService.assertContains("my AssertService.assertion will pass", "abc", "abc");
    }

    @Test
    public void passAssertContainsNotInOrderTest() {
        AssertService.assertContainsNotInOrder("my message", "transforming the way people everywhere live", "live", "way", "transforming");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsNotInOrderForeignStringTest() {
        AssertService.assertContainsNotInOrder("my message", "transforming the way people everywhere live", "live", "foo", "way", "transforming");
    }

    @Test
    public void passAssertContainsAllItemsTest() {
        AssertService.assertContainsInOrder("my message", "transforming the way people everywhere live", "the", "everywhere");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsInOrderOutOfOrderTest() {
        AssertService.assertContainsInOrder("my message", "transforming the way people everywhere live", "everywhere", "the");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsInOrderOutOfOrderForeignStringTest() {
        AssertService.assertContainsInOrder("my message", "transforming the way people everywhere live", "foo", "the");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsStringTest() {
        AssertService.assertContains("abcd", "mno");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsLongerStringTest() {
        AssertService.assertContains("foobar", "afoobarbc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsCaseSensitiveTest() {
        AssertService.assertContains("ABCDEFGHI", "def");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsSimilarStringTest() {
        AssertService.assertContains("abcdefghi", "de f");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsInvalidCaseStringTest() {
        AssertService.assertContains("abcdefghi", "deF");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsSourceBlankTest() {
        AssertService.assertContains("", "abc");
    }

    @Test(expected = NullPointerException.class)
    public void failAssertContainsNullTest() {
        AssertService.assertContains("abcdefghi", null);
    }

}
