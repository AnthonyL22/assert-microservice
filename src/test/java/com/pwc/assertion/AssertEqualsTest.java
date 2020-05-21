package com.pwc.assertion;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertEqualsTest extends AssertBaseTest {

    @Test
    public void passAssertEqualsExtendedLoggingTest() {
        AssertService.assertEquals("my AssertService.assertion %s", "abc", "abc", "is going to pass");
    }

    @Test
    public void passAssertEqualsStringTest() {
        AssertService.assertEquals("abc", "abc");
    }

    @Test
    public void passAssertEqualsIntegerTest() {
        AssertService.assertEquals(1, 1);
    }

    @Test
    public void passAssertEqualsLongTest() {
        AssertService.assertEquals(123L, 123L);
    }

    @Test
    public void passAssertEqualsObjectTest() {
        String[] foobar = new String[] {"a", "b", "c"};
        AssertService.assertEquals(foobar, foobar);
    }

    @Test
    public void passAssertEqualsBooleanExpressionTest() {
        AssertService.assertEquals("x".equals("x"), StringUtils.equals("a", "a"));
    }

    @Test
    public void passAssertEqualsBooleanTest() {
        AssertService.assertEquals(true, true);
    }

    @Test
    public void passAssertEqualsFloatTest() {
        AssertService.assertEquals(1.2, 1.2);
    }

    @Test
    public void passAssertEqualsByteTest() {
        AssertService.assertEquals((byte) 0xe0, (byte) 0xe0);
    }

    @Test
    public void passAssertEqualsCharTest() {
        AssertService.assertEquals('a', 'a');
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsStringTest() {
        AssertService.assertEquals("abcd", "abc");
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsIntegerTest() {
        AssertService.assertEquals(2, 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsLongTest() {
        AssertService.assertEquals(1234L, 123L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsObjectTest() {
        String[] foo = new String[] {"a", "b", "c"};
        String[] bar = new String[] {"a", "b", "c", "d"};
        AssertService.assertEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsDiffObjectsTest() {
        String foo = "x";
        int bar = 1;
        AssertService.assertEquals(foo, bar);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsBooleanExpressionTest() {
        AssertService.assertEquals("x".equals("y"), StringUtils.equals("a", "a"));
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsBooleanTest() {
        AssertService.assertEquals(true, false);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsByteTest() {
        AssertService.assertEquals((byte) 0xe0, (byte) 0x4f);
    }

    @Test(expected = AssertionError.class)
    public void failAssertEqualsCharTest() {
        AssertService.assertEquals('a', "a");
    }

}
