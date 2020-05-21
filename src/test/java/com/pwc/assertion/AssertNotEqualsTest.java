package com.pwc.assertion;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNotEqualsTest extends AssertBaseTest {

    @Test
    public void passAssertNotEqualsExtendedLoggingTest() {
        AssertService.assertNotEquals("my AssertService.assertion %s", "abcd", "abc", "is going to pass");
    }

    @Test
    public void passAssertNotEqualsStringTest() {
        AssertService.assertNotEquals("abcd", "abc");
    }

    @Test
    public void passAssertNotEqualsIntegerTest() {
        AssertService.assertNotEquals(2, 1);
    }

    @Test
    public void passAssertNotEqualsLongTest() {
        AssertService.assertNotEquals(1234L, 123L);
    }

    @Test
    public void passAssertNotEqualsObjectTest() {
        String[] foo = new String[] {"a", "b", "c"};
        String[] bar = new String[] {"a", "b", "c", "d"};
        AssertService.assertNotEquals(foo, bar);
    }

    @Test
    public void passAssertNotEqualsBooleanExpressionTest() {
        AssertService.assertNotEquals("x".equals("y"), StringUtils.equals("a", "a"));
    }

    @Test
    public void passAssertNotEqualsBooleanTest() {
        AssertService.assertNotEquals(true, false);
    }

    @Test
    public void passAssertNotEqualsFloatTest() {
        AssertService.assertNotEquals(1.3, 1.2);
    }

    @Test
    public void passAssertNotEqualsByteTest() {
        AssertService.assertNotEquals((byte) 0xe1, (byte) 0xe0);
    }

    @Test
    public void passAssertNotEqualsCharTest() {
        AssertService.assertNotEquals('a', 'b');
    }

    @Test
    public void passAssertNotEqualsLoggingTest() {
        AssertService.assertNotEquals("my AssertService.assertion %s %s", "abcd", "abc", 1, "is going to pass");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsStringTest() {
        AssertService.assertNotEquals("abc", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsIntegerTest() {
        AssertService.assertNotEquals(1, 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsLongTest() {
        AssertService.assertNotEquals(123L, 123L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsObjectTest() {
        String[] foo = new String[] {"a", "b", "c"};
        String[] bar = new String[] {"a", "b", "c"};
        AssertService.assertNotEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsDiffObjectsTest() {
        String foo = "x";
        String bar = foo;
        AssertService.assertNotEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsBooleanExpressionTest() {
        AssertService.assertNotEquals("x".equals("x"), StringUtils.equals("a", "a"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsBooleanTest() {
        AssertService.assertNotEquals(true, true);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsByteTest() {
        AssertService.assertNotEquals((byte) 0x4f, (byte) 0x4f);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotEqualsCharTest() {
        AssertService.assertNotEquals('a', 'a');
    }

}
