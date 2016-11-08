package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNotNullTest extends AssertBaseTest {

    @Test
    public void passAssertNotNullExtendedLoggingTest() {
        QssertService.assertNotNull("my QssertService.assertion %s %s", "foobar", 777, "is going to pass");
    }

    @Test
    public void passAssertNotNullStringTest() {
        QssertService.assertNotNull("abcdefghi");
    }

    @Test
    public void passAssertNotNullIntegerTest() {
        QssertService.assertNotNull(1);
    }

    @Test
    public void passAssertNotNullLongTest() {
        QssertService.assertNotNull(1234L);
    }

    @Test
    public void passAssertNotNullFloatTest() {
        QssertService.assertNotNull(1.2);
    }

    @Test
    public void passAssertNotNullByteTest() {
        QssertService.assertNotNull((byte) 0xe0);
    }

    @Test
    public void passAssertNotNullCharTest() {
        QssertService.assertNotNull('a');
    }

    @Test
    public void passAssertNotNullObjectTest() {
        QssertService.assertNotNull(new Object());
    }

    @Test
    public void passAssertNotNullBooleanTest() {
        QssertService.assertNotNull(true);
    }

    @Test
    public void passAssertNotNullEmptyTest() {
        QssertService.assertNotNull("");
    }

    @Test
    public void passAssertNotNullBlankTest() {
        QssertService.assertNotNull(" ");
    }

    @Test
    public void passAssertNotNullLoggingTest() {
        QssertService.assertNotNull("my QssertService.assertion will pass %s", "abc", "abcd");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNotNullTest() {
        QssertService.assertNotNull(null);
    }

}
