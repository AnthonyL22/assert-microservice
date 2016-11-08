package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNotNullTest extends AssertBaseTest {

    @Test
    public void passAssertNotNullExtendedLoggingTest() {
        AssertService.assertNotNull("my AssertService.assertion %s %s", "foobar", 777, "is going to pass");
    }

    @Test
    public void passAssertNotNullStringTest() {
        AssertService.assertNotNull("abcdefghi");
    }

    @Test
    public void passAssertNotNullIntegerTest() {
        AssertService.assertNotNull(1);
    }

    @Test
    public void passAssertNotNullLongTest() {
        AssertService.assertNotNull(1234L);
    }

    @Test
    public void passAssertNotNullFloatTest() {
        AssertService.assertNotNull(1.2);
    }

    @Test
    public void passAssertNotNullByteTest() {
        AssertService.assertNotNull((byte) 0xe0);
    }

    @Test
    public void passAssertNotNullCharTest() {
        AssertService.assertNotNull('a');
    }

    @Test
    public void passAssertNotNullObjectTest() {
        AssertService.assertNotNull(new Object());
    }

    @Test
    public void passAssertNotNullBooleanTest() {
        AssertService.assertNotNull(true);
    }

    @Test
    public void passAssertNotNullEmptyTest() {
        AssertService.assertNotNull("");
    }

    @Test
    public void passAssertNotNullBlankTest() {
        AssertService.assertNotNull(" ");
    }

    @Test
    public void passAssertNotNullLoggingTest() {
        AssertService.assertNotNull("my AssertService.assertion will pass %s", "abc", "abcd");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotNullTest() {
        AssertService.assertNotNull(null);
    }

}
