package com.qualcomm.qssert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertEqualsTest extends AssertBaseTest {

    @Test
    public void passAssertEqualsExtendedLoggingTest() {
        QssertService.assertEquals("my QssertService.assertion %s", "abc", "abc", "is going to pass");
    }

    @Test
    public void passAssertEqualsStringTest() {
        QssertService.assertEquals("abc", "abc");
    }

    @Test
    public void passAssertEqualsIntegerTest() {
        QssertService.assertEquals(1, 1);
    }

    @Test
    public void passAssertEqualsLongTest() {
        QssertService.assertEquals(123L, 123L);
    }

    @Test
    public void passAssertEqualsObjectTest() {
        String[] foobar = new String[]{"a", "b", "c"};
        QssertService.assertEquals(foobar, foobar);
    }

    @Test
    public void passAssertEqualsBooleanExpressionTest() {
        QssertService.assertEquals("x".equals("x"), StringUtils.equals("a", "a"));
    }

    @Test
    public void passAssertEqualsBooleanTest() {
        QssertService.assertEquals(true, true);
    }

    @Test
    public void passAssertEqualsFloatTest() {
        QssertService.assertEquals(1.2, 1.2);
    }

    @Test
    public void passAssertEqualsByteTest() {
        QssertService.assertEquals((byte) 0xe0, (byte) 0xe0);
    }

    @Test
    public void passAssertEqualsCharTest() {
        QssertService.assertEquals('a', 'a');
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsStringTest() {
        QssertService.assertEquals("abcd", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsIntegerTest() {
        QssertService.assertEquals(2, 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsLongTest() {
        QssertService.assertEquals(1234L, 123L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsObjectTest() {
        String[] foo = new String[]{"a", "b", "c"};
        String[] bar = new String[]{"a", "b", "c", "d"};
        QssertService.assertEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsDiffObjectsTest() {
        String foo = "x";
        int bar = 1;
        QssertService.assertEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsBooleanExpressionTest() {
        QssertService.assertEquals("x".equals("y"), StringUtils.equals("a", "a"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsBooleanTest() {
        QssertService.assertEquals(true, false);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsByteTest() {
        QssertService.assertEquals((byte) 0xe0, (byte) 0x4f);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsCharTest() {
        QssertService.assertEquals('a', "a");
    }

}
