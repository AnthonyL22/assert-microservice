package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertNullTest extends AssertBaseTest {

    @Test
    public void passAssertNullExtendedLoggingTest() {
        AssertService.assertNull("my AssertService.assertion %s %s", null, 777, "is going to pass");
    }

    @Test
    public void passAssertNullStringTest() {
        AssertService.assertNull(null);
    }

    @Test
    public void passAssertNullLoggingTest() {
        AssertService.assertNull("my %s AssertService.assertion %s will pass %s", null, 1, 2, 3);
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullCharTest() {
        AssertService.assertNull(' ');
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullObjectTest() {
        AssertService.assertNull(new Object());
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullEmptyTest() {
        AssertService.assertNull("");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullBlankTest() {
        AssertService.assertNull(" ");
    }

    @Test(expected = AssertionError.class)
    public void failAssertNullZeroTest() {
        AssertService.assertNull(0);
    }

}
