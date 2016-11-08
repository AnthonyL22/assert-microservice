package com.qualcomm.qssert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertContainsIgnoreCaseTest extends AssertBaseTest {

    @Test
    public void passAssertContainsIgnoreCaseExtendedLoggingTest() {
        QssertService.assertContainsIgnoreCase("my QssertService.assertion %s", StringUtils.upperCase("afoobarbc"), "foobar", "is going to pass");
    }

    @Test
    public void passAssertContainsIgnoreCaseStringTest() {
        QssertService.assertContainsIgnoreCase("ABCDEFGHIJK", "def");
    }

    @Test
    public void passAssertContainsIgnoreCaseSensitiveTest() {
        QssertService.assertContainsIgnoreCase("ABCDEFGHI", "HI");
    }

    @Test
    public void passAssertContainsIgnoreCaseBlankTest() {
        QssertService.assertContainsIgnoreCase("abcdefghi", "");
    }

    @Test
    public void passAssertContainsIgnoreCaseLoggingTest() {
        QssertService.assertContainsIgnoreCase("my QssertService.assertion will pass", "ABCDEFGHI", "def");
    }

    @Test
    public void passAssertContainsIgnoreCaseBothBlankTest() {
        QssertService.assertContainsIgnoreCase("", "");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseStringTest() {
        QssertService.assertContainsIgnoreCase("abcd", "mno");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseLongerStringTest() {
        QssertService.assertContainsIgnoreCase("FOOBAR", "afoobarbc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseSensitiveTest() {
        QssertService.assertContainsIgnoreCase("ABCDEFGHI", "DFE");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseNullTest() {
        QssertService.assertContainsIgnoreCase("abcdefghi", null);
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseBlankTest() {
        QssertService.assertContainsIgnoreCase("", " ");
    }

}
