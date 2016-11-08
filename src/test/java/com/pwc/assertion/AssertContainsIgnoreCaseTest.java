package com.pwc.assertion;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertContainsIgnoreCaseTest extends AssertBaseTest {

    @Test
    public void passAssertContainsIgnoreCaseExtendedLoggingTest() {
        AssertService.assertContainsIgnoreCase("my AssertService.assertion %s", StringUtils.upperCase("afoobarbc"), "foobar", "is going to pass");
    }

    @Test
    public void passAssertContainsIgnoreCaseStringTest() {
        AssertService.assertContainsIgnoreCase("ABCDEFGHIJK", "def");
    }

    @Test
    public void passAssertContainsIgnoreCaseSensitiveTest() {
        AssertService.assertContainsIgnoreCase("ABCDEFGHI", "HI");
    }

    @Test
    public void passAssertContainsIgnoreCaseBlankTest() {
        AssertService.assertContainsIgnoreCase("abcdefghi", "");
    }

    @Test
    public void passAssertContainsIgnoreCaseLoggingTest() {
        AssertService.assertContainsIgnoreCase("my AssertService.assertion will pass", "ABCDEFGHI", "def");
    }

    @Test
    public void passAssertContainsIgnoreCaseBothBlankTest() {
        AssertService.assertContainsIgnoreCase("", "");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseStringTest() {
        AssertService.assertContainsIgnoreCase("abcd", "mno");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseLongerStringTest() {
        AssertService.assertContainsIgnoreCase("FOOBAR", "afoobarbc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseSensitiveTest() {
        AssertService.assertContainsIgnoreCase("ABCDEFGHI", "DFE");
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseNullTest() {
        AssertService.assertContainsIgnoreCase("abcdefghi", null);
    }

    @Test(expected = AssertionError.class)
    public void failAssertContainsIgnoreCaseBlankTest() {
        AssertService.assertContainsIgnoreCase("", " ");
    }

}
