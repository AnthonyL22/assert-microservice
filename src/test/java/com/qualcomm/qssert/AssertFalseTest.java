package com.qualcomm.qssert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertFalseTest extends AssertBaseTest {

    @Test
    public void passBadFormattedVariableArgsTest() {
        QssertService.assertFalse("my QssertService.assertion %s %s", false, "is going to pass");
    }

    @Test
    public void passAssertFalseExtendedLoggingTest() {
        QssertService.assertFalse("my QssertService.assertion %s %s", false, "is going to pass");
    }

    @Test
    public void passAssertFalseBooleanTest() {
        QssertService.assertFalse(false);
    }

    @Test
    public void passAssertFalseStringComparisonTest() {
        QssertService.assertFalse("a".equals("b"));
    }

    @Test
    public void passAssertFalseIntegerComparisonTest() {
        QssertService.assertFalse(1 == 21);
    }

    @Test
    public void passAssertFalseStringTest() {
        QssertService.assertFalse(StringUtils.containsNone("abc", "a"));
    }

    @Test
    public void passAssertFalseNullTest() {
        QssertService.assertFalse(Boolean.parseBoolean(null));
    }

    @Test
    public void passAssertFalseLongComparisonTest() {
        QssertService.assertFalse(777L == 7778L);
    }

    @Test
    public void passAssertFalseFloatComparisonTest() {
        QssertService.assertFalse(22.7 == 22.8);
    }

    @Test
    public void passAssertFalseByteComparisonTest() {
        QssertService.assertFalse((byte) 0xe0 == (byte) 0xe2);
    }

    @Test
    public void passAssertFalseCharComparisonTest() {
        QssertService.assertFalse('B' == 'b');
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseStringTest() {
        QssertService.assertFalse(StringUtils.containsNone("abc", "z"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseBooleanTest() {
        QssertService.assertFalse(true);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseIntegerComparisonTest() {
        QssertService.assertFalse(1 == 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseLongComparisonTest() {
        QssertService.assertFalse(777L == 777L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseFloatComparisonTest() {
        QssertService.assertFalse(22.7 == 22.7);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseByteComparisonTest() {
        QssertService.assertFalse((byte) 0xe0 == (byte) 0xe0);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseCharComparisonTest() {
        QssertService.assertFalse('B' == 'B');
    }

}
