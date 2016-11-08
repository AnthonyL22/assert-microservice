package com.pwc.assertion;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertFalseTest extends AssertBaseTest {

    @Test
    public void passBadFormattedVariableArgsTest() {
        AssertService.assertFalse("my AssertService.assertion %s %s", false, "is going to pass");
    }

    @Test
    public void passAssertFalseExtendedLoggingTest() {
        AssertService.assertFalse("my AssertService.assertion %s %s", false, "is going to pass");
    }

    @Test
    public void passAssertFalseBooleanTest() {
        AssertService.assertFalse(false);
    }

    @Test
    public void passAssertFalseStringComparisonTest() {
        AssertService.assertFalse("a".equals("b"));
    }

    @Test
    public void passAssertFalseIntegerComparisonTest() {
        AssertService.assertFalse(1 == 21);
    }

    @Test
    public void passAssertFalseStringTest() {
        AssertService.assertFalse(StringUtils.containsNone("abc", "a"));
    }

    @Test
    public void passAssertFalseNullTest() {
        AssertService.assertFalse(Boolean.parseBoolean(null));
    }

    @Test
    public void passAssertFalseLongComparisonTest() {
        AssertService.assertFalse(777L == 7778L);
    }

    @Test
    public void passAssertFalseFloatComparisonTest() {
        AssertService.assertFalse(22.7 == 22.8);
    }

    @Test
    public void passAssertFalseByteComparisonTest() {
        AssertService.assertFalse((byte) 0xe0 == (byte) 0xe2);
    }

    @Test
    public void passAssertFalseCharComparisonTest() {
        AssertService.assertFalse('B' == 'b');
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseStringTest() {
        AssertService.assertFalse(StringUtils.containsNone("abc", "z"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseBooleanTest() {
        AssertService.assertFalse(true);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseIntegerComparisonTest() {
        AssertService.assertFalse(1 == 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseLongComparisonTest() {
        AssertService.assertFalse(777L == 777L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseFloatComparisonTest() {
        AssertService.assertFalse(22.7 == 22.7);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseByteComparisonTest() {
        AssertService.assertFalse((byte) 0xe0 == (byte) 0xe0);
    }

    @Test(expected = AssertionError.class)
    public void failAssertFalseCharComparisonTest() {
        AssertService.assertFalse('B' == 'B');
    }

}
