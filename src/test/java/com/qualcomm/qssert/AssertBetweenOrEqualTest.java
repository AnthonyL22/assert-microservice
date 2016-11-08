package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertBetweenOrEqualTest extends AssertBaseTest {

    @Test
    public void passAssertBetweenOrEqualBadFormattedVariableArgsTest() {
        QssertService.assertBetweenOrEqual("my QssertService.assertion %s %s", 0, 0, 99, "is going to pass");
    }

    @Test
    public void passAssertBetweenOrEqualStringComparisonTestTest() {
        QssertService.assertBetweenOrEqual("B", "A", "C");
    }

    @Test
    public void passAssertBetweenOrEqualTwoStringsComparisonTest() {
        QssertService.assertBetweenOrEqual("ZZ", "AB", "ZZ");
    }

    @Test
    public void passAssertBetweenOrEqualCharComparisonTest() {
        QssertService.assertBetweenOrEqual('T', 'A', 'T');
    }

    @Test
    public void passAssertBetweenOrEqualIntegerComparisonTest() {
        QssertService.assertBetweenOrEqual(100000, 1, 100000);
    }

    @Test
    public void passAssertBetweenOrEqualFloatComparisonTest() {
        QssertService.assertBetweenOrEqual(4.99999991, 4.9999999, 5.01);
    }

    @Test
    public void passAssertBetweenOrEqualFloatComparisonInsideTest() {
        QssertService.assertBetweenOrEqual(5.00, 4.9999999, 5.01);
    }

    @Test
    public void passAssertBetweenOrEqualLongComparisonTest() {
        QssertService.assertBetweenOrEqual(3330L, 3330L, 9999443747397L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualLongComparisonOutsideTest() {
        QssertService.assertBetweenOrEqual(9999443747398L, 3330L, 9999443747397L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualFloatComparisonOutsideTest() {
        QssertService.assertBetweenOrEqual(4.90, 4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualCharComparisonTest() {
        QssertService.assertBetweenOrEqual("Verify my QssertService.assertion", 'C', 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualIntegerAsStringsComparisonTest() {
        QssertService.assertBetweenOrEqual("100001", "1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualStringComparisonTest() {
        QssertService.assertBetweenOrEqual("a", "A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualTwoStringsComparisonTest() {
        QssertService.assertBetweenOrEqual("M", "AB", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualIntegerComparisonTest() {
        QssertService.assertBetweenOrEqual(0, 1, 100000);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualFloatComparisonTest() {
        QssertService.assertBetweenOrEqual(5.011, 4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenOrEqualLongComparisonTest() {
        QssertService.assertBetweenOrEqual(9999443747400L, 3330L, 9999443747397L);
    }

}
