package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertContainsTest extends AssertBaseTest {

    @Test
    public void passAssertContainsExtendedLoggingTest() {
        QssertService.assertContains("my QssertService.assertion %s %s", "afoobarbc", "foobar", 777, "is going to pass");
    }

    @Test
    public void passAssertContainsStringTest() {
        QssertService.assertContains("abcdefghi", "def");
    }

    @Test
    public void passAssertContainsCaseSensitiveTest() {
        QssertService.assertContains("ABCDEFGHI", "DEF");
    }

    @Test
    public void passAssertContainsBlankTest() {
        QssertService.assertContains("abcdefghi", "");
    }

    @Test
    public void passAssertContainsLoggingTest() {
        QssertService.assertContains("my QssertService.assertion will pass", "abc", "abc");
    }

    @Test
    public void passAssertContainsNotInOrderTest() {
        QssertService.assertContainsNotInOrder("my message", "transforming the way people everywhere live", "live", "way", "transforming");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsNotInOrderForeignStringTest() {
        QssertService.assertContainsNotInOrder("my message", "transforming the way people everywhere live", "live", "foo", "way", "transforming");
    }

    @Test
    public void passAssertContainsAllItemsTest() {
        QssertService.assertContainsInOrder("my message", "transforming the way people everywhere live", "the", "everywhere");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsInOrderOutOfOrderTest() {
        QssertService.assertContainsInOrder("my message", "transforming the way people everywhere live", "everywhere", "the");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsInOrderOutOfOrderForeignStringTest() {
        QssertService.assertContainsInOrder("my message", "transforming the way people everywhere live", "foo", "the");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsStringTest() {
        QssertService.assertContains("abcd", "mno");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsLongerStringTest() {
        QssertService.assertContains("foobar", "afoobarbc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsCaseSensitiveTest() {
        QssertService.assertContains("ABCDEFGHI", "def");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsSimilarStringTest() {
        QssertService.assertContains("abcdefghi", "de f");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsInvalidCaseStringTest() {
        QssertService.assertContains("abcdefghi", "deF");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsSourceBlankTest() {
        QssertService.assertContains("", "abc");
    }

    @Test(expected = NullPointerException.class)
    public void failAssertContainsNullTest() {
        QssertService.assertContains("abcdefghi", null);
    }

}
