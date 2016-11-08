package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertBetweenOrEqualTest extends AssertBaseTest {

    @Test
    public void passAssertBetweenOrEqualBadFormattedVariableArgsTest() {
        AssertService.assertBetweenOrEqual("my AssertService.assertion %s %s", 0, 0, 99, "is going to pass");
    }

    @Test
    public void passAssertBetweenOrEqualStringComparisonTestTest() {
        AssertService.assertBetweenOrEqual("B", "A", "C");
    }

    @Test
    public void passAssertBetweenOrEqualTwoStringsComparisonTest() {
        AssertService.assertBetweenOrEqual("ZZ", "AB", "ZZ");
    }

    @Test
    public void passAssertBetweenOrEqualCharComparisonTest() {
        AssertService.assertBetweenOrEqual('T', 'A', 'T');
    }

    @Test
    public void passAssertBetweenOrEqualIntegerComparisonTest() {
        AssertService.assertBetweenOrEqual(100000, 1, 100000);
    }

    @Test
    public void passAssertBetweenOrEqualFloatComparisonTest() {
        AssertService.assertBetweenOrEqual(4.99999991, 4.9999999, 5.01);
    }

    @Test
    public void passAssertBetweenOrEqualFloatComparisonInsideTest() {
        AssertService.assertBetweenOrEqual(5.00, 4.9999999, 5.01);
    }

    @Test
    public void passAssertBetweenOrEqualLongComparisonTest() {
        AssertService.assertBetweenOrEqual(3330L, 3330L, 9999443747397L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualLongComparisonOutsideTest() {
        AssertService.assertBetweenOrEqual(9999443747398L, 3330L, 9999443747397L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualFloatComparisonOutsideTest() {
        AssertService.assertBetweenOrEqual(4.90, 4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualCharComparisonTest() {
        AssertService.assertBetweenOrEqual("Verify my AssertService.assertion", 'C', 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualIntegerAsStringsComparisonTest() {
        AssertService.assertBetweenOrEqual("100001", "1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualStringComparisonTest() {
        AssertService.assertBetweenOrEqual("a", "A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualTwoStringsComparisonTest() {
        AssertService.assertBetweenOrEqual("M", "AB", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualIntegerComparisonTest() {
        AssertService.assertBetweenOrEqual(0, 1, 100000);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualFloatComparisonTest() {
        AssertService.assertBetweenOrEqual(5.011, 4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualLongComparisonTest() {
        AssertService.assertBetweenOrEqual(9999443747400L, 3330L, 9999443747397L);
    }

}
