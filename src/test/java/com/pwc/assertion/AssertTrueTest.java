package com.pwc.assertion;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertTrueTest extends AssertBaseTest {

    @Test
    public void passBadFormattedVariableArgsTest() {
        AssertService.assertTrue("my AssertService.assertion %s %s %s %s %s %s %s", true, "is going to pass", 1, 2, 3);
    }

    @Test
    public void passAssertTrueExtendedLoggingTest() {
        AssertService.assertTrue("my AssertService.assertion %s %s", true, "is going to pass");
    }

    @Test
    public void passAssertTrueBooleanTest() {
        AssertService.assertTrue(true);
    }

    @Test
    public void passAssertTrueStringComparisonTest() {
        AssertService.assertTrue("a".equals("a"));
    }

    @Test
    public void passAssertTrueIntegerComparisonTest() {
        AssertService.assertTrue(1 == 1);
    }

    @Test
    public void passAssertTrueStringTest() {
        AssertService.assertTrue(StringUtils.containsNone("abc", "z"));
    }

    @Test
    public void passAssertTrueLongComparisonTest() {
        AssertService.assertTrue(777L == 777L);
    }

    @Test
    public void passAssertTrueFloatComparisonTest() {
        AssertService.assertTrue(22.7 == 22.7);
    }

    @Test
    public void passAssertTrueByteComparisonTest() {
        AssertService.assertTrue((byte) 0xe0 == (byte) 0xe0);
    }

    @Test
    public void passAssertTrueCharComparisonTest() {
        AssertService.assertTrue('B' == 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueNullTest() {
        AssertService.assertTrue(Boolean.parseBoolean(null));
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueStringTest() {
        AssertService.assertTrue(StringUtils.containsNone("abc", "a"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueBooleanTest() {
        AssertService.assertTrue(false);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueIntegerComparisonTest() {
        AssertService.assertTrue(1 != 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueLongComparisonTest() {
        AssertService.assertTrue(777L != 777L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueFloatComparisonTest() {
        AssertService.assertTrue(22.7 != 22.7);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueByteComparisonTest() {
        AssertService.assertTrue((byte) 0xe0 != (byte) 0xe0);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueCharComparisonTest() {
        AssertService.assertTrue('B' != 'B');
    }

}
