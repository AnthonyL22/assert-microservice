package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertLessThanOrEqualTest extends AssertBaseTest {

    @Test
    public void passAssertLessThanOrEqualBadFormattedVariableArgsTest() {
        QssertService.assertLessThanOrEqual("my QssertService.assertion %s %s", 99, 99, "is going to pass");
    }

    @Test
    public void passAssertLessThanOrEqualStringComparisonSimilarTest() {
        QssertService.assertLessThanOrEqual("angel", "mangie");
    }

    @Test
    public void passLessThanOrEqualCaseSensitiveTest() {
        QssertService.assertLessThanOrEqual("AAA", "BBBB");
    }

    @Test(expected = AssertionError.class)
    public void failLessThanOrEqualCaseSensitiveTest() {
        QssertService.assertLessThanOrEqual("aaa", "BBBB");
    }

    @Test
    public void passAssertLessThanOrEqualStringComparisonTest() {
        QssertService.assertLessThanOrEqual("A", "C");
    }

    @Test
    public void passAssertLessThanOrEqualStringComparisonSameTest() {
        QssertService.assertLessThanOrEqual("D", "D");
    }

    @Test
    public void passAssertLessThanOrEqualTwoStringsComparisonTest() {
        QssertService.assertLessThanOrEqual("MM", "MN");
    }

    @Test
    public void passAssertLessThanOrEqualCharComparisonTest() {
        QssertService.assertLessThanOrEqual('M', 'N');
    }

    @Test
    public void passAssertLessThanOrEqualCharComparisonSameTest() {
        QssertService.assertLessThanOrEqual('M', 'M');
    }

    @Test
    public void passAssertLessThanOrEqualIntegerComparisonTest() {
        QssertService.assertLessThanOrEqual(1, 2);
    }

    @Test
    public void passAssertLessThanOrEqualIntegerComparisonSameTest() {
        QssertService.assertLessThanOrEqual(1, 1);
    }

    @Test
    public void passAssertLessThanOrEqualFloatComparisonSameTest() {
        QssertService.assertLessThanOrEqual(4.9999999, 4.9999999);
    }

    @Test
    public void passAssertLessThanOrEqualFloatComparisonTest() {
        QssertService.assertLessThanOrEqual(4.9999999, 5.01);
    }

    @Test
    public void passAssertLessThanOrEqualLongComparisonTest() {
        QssertService.assertLessThanOrEqual(3330L, 10000L);
    }

    @Test
    public void passAssertLessThanOrEqualLongComparisonSameTest() {
        QssertService.assertLessThanOrEqual(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualLongComparisonOutsideTest() {
        QssertService.assertLessThanOrEqual(5L, 1L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualFloatComparisonOutsideTest() {
        QssertService.assertLessThanOrEqual(5.01, 4.9999999);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualCharComparisonTest() {
        QssertService.assertLessThanOrEqual("Verify my failAssertLessThanOrEqualCharComparison", 'B', 'A');
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualIntegerAsStringsComparisonTest() {
        QssertService.assertLessThanOrEqual("999999999", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualStringComparisonTest() {
        QssertService.assertLessThanOrEqual("D", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualTwoStringsComparisonTest() {
        QssertService.assertLessThanOrEqual("DE", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualIntegerComparisonTest() {
        QssertService.assertLessThanOrEqual(4, 3);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualFloatComparisonTest() {
        QssertService.assertLessThanOrEqual(5.01, 4.99);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualLongComparisonTest() {
        QssertService.assertLessThanOrEqual(9999443747397L, 9999443747396L);
    }

}
