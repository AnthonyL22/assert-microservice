package com.qualcomm.qssert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertTrueTest extends AssertBaseTest {

    @Test
    public void passBadFormattedVariableArgsTest() {
        QssertService.assertTrue("my QssertService.assertion %s %s %s %s %s %s %s", true, "is going to pass", 1, 2, 3);
    }


    @Test
    public void passAssertTrueExtendedLoggingTest() {
        QssertService.assertTrue("my QssertService.assertion %s %s", true, "is going to pass");
    }

    @Test
    public void passAssertTrueBooleanTest() {
        QssertService.assertTrue(true);
    }

    @Test
    public void passAssertTrueStringComparisonTest() {
        QssertService.assertTrue("a".equals("a"));
    }

    @Test
    public void passAssertTrueIntegerComparisonTest() {
        QssertService.assertTrue(1 == 1);
    }

    @Test
    public void passAssertTrueStringTest() {
        QssertService.assertTrue(StringUtils.containsNone("abc", "z"));
    }

    @Test
    public void passAssertTrueLongComparisonTest() {
        QssertService.assertTrue(777L == 777L);
    }

    @Test
    public void passAssertTrueFloatComparisonTest() {
        QssertService.assertTrue(22.7 == 22.7);
    }

    @Test
    public void passAssertTrueByteComparisonTest() {
        QssertService.assertTrue((byte) 0xe0 == (byte) 0xe0);
    }

    @Test
    public void passAssertTrueCharComparisonTest() {
        QssertService.assertTrue('B' == 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueNullTest() {
        QssertService.assertTrue(Boolean.parseBoolean(null));
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueStringTest() {
        QssertService.assertTrue(StringUtils.containsNone("abc", "a"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueBooleanTest() {
        QssertService.assertTrue(false);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueIntegerComparisonTest() {
        QssertService.assertTrue(1 != 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueLongComparisonTest() {
        QssertService.assertTrue(777L != 777L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueFloatComparisonTest() {
        QssertService.assertTrue(22.7 != 22.7);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueByteComparisonTest() {
        QssertService.assertTrue((byte) 0xe0 != (byte) 0xe0);
    }

    @Test(expected = AssertionError.class)
    public void failAssertTrueCharComparisonTest() {
        QssertService.assertTrue('B' != 'B');
    }

}
