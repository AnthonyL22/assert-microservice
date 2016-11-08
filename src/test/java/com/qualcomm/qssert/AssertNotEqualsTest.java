package com.qualcomm.qssert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNotEqualsTest extends AssertBaseTest {

    @Test
    public void passAssertNotEqualsExtendedLoggingTest() {
        QssertService.assertNotEquals("my QssertService.assertion %s", "abcd", "abc", "is going to pass");
    }

    @Test
    public void passAssertNotEqualsStringTest() {
        QssertService.assertNotEquals("abcd", "abc");
    }

    @Test
    public void passAssertNotEqualsIntegerTest() {
        QssertService.assertNotEquals(2, 1);
    }

    @Test
    public void passAssertNotEqualsLongTest() {
        QssertService.assertNotEquals(1234L, 123L);
    }

    @Test
    public void passAssertNotEqualsObjectTest() {
        String[] foo = new String[]{"a", "b", "c"};
        String[] bar = new String[]{"a", "b", "c", "d"};
        QssertService.assertNotEquals(foo, bar);
    }

    @Test
    public void passAssertNotEqualsBooleanExpressionTest() {
        QssertService.assertNotEquals("x".equals("y"), StringUtils.equals("a", "a"));
    }

    @Test
    public void passAssertNotEqualsBooleanTest() {
        QssertService.assertNotEquals(true, false);
    }

    @Test
    public void passAssertNotEqualsFloatTest() {
        QssertService.assertNotEquals(1.3, 1.2);
    }

    @Test
    public void passAssertNotEqualsByteTest() {
        QssertService.assertNotEquals((byte) 0xe1, (byte) 0xe0);
    }

    @Test
    public void passAssertNotEqualsCharTest() {
        QssertService.assertNotEquals('a', 'b');
    }

    @Test
    public void passAssertNotEqualsLoggingTest() {
        QssertService.assertNotEquals("my QssertService.assertion %s %s", "abcd", "abc", 1, "is going to pass");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsStringTest() {
        QssertService.assertNotEquals("abc", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsIntegerTest() {
        QssertService.assertNotEquals(1, 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsLongTest() {
        QssertService.assertNotEquals(123L, 123L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsObjectTest() {
        String[] foo = new String[]{"a", "b", "c"};
        String[] bar = new String[]{"a", "b", "c"};
        QssertService.assertNotEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsDiffObjectsTest() {
        String foo = "x";
        String bar = foo;
        QssertService.assertNotEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsBooleanExpressionTest() {
        QssertService.assertNotEquals("x".equals("x"), StringUtils.equals("a", "a"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsBooleanTest() {
        QssertService.assertNotEquals(true, true);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsByteTest() {
        QssertService.assertNotEquals((byte) 0x4f, (byte) 0x4f);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsCharTest() {
        QssertService.assertNotEquals('a', 'a');
    }

}
