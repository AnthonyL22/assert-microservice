package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNullTest extends AssertBaseTest {

    @Test
    public void passAssertNullExtendedLoggingTest() {
        QssertService.assertNull("my QssertService.assertion %s %s", null, 777, "is going to pass");
    }

    @Test
    public void passAssertNullStringTest() {
        QssertService.assertNull(null);
    }

    @Test
    public void passAssertNullLoggingTest() {
        QssertService.assertNull("my %s QssertService.assertion %s will pass %s", null, 1, 2, 3);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullCharTest() {
        QssertService.assertNull(' ');
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullObjectTest() {
        QssertService.assertNull(new Object());
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullEmptyTest() {
        QssertService.assertNull("");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullBlankTest() {
        QssertService.assertNull(" ");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullZeroTest() {
        QssertService.assertNull(0);
    }

}
