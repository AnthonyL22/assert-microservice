package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertLessThanOrEqualTest extends AssertBaseTest {

    @Test
    public void passAssertLessThanOrEqualBadFormattedVariableArgsTest() {
        AssertService.assertLessThanOrEqual("my AssertService.assertion %s %s", 99, 99, "is going to pass");
    }

    @Test
    public void passAssertLessThanOrEqualStringComparisonSimilarTest() {
        AssertService.assertLessThanOrEqual("angel", "mangie");
    }

    @Test
    public void passLessThanOrEqualCaseSensitiveTest() {
        AssertService.assertLessThanOrEqual("AAA", "BBBB");
    }

    @Test(expected = AssertionError.class)
    public void failLessThanOrEqualCaseSensitiveTest() {
        AssertService.assertLessThanOrEqual("aaa", "BBBB");
    }

    @Test
    public void passAssertLessThanOrEqualStringComparisonTest() {
        AssertService.assertLessThanOrEqual("A", "C");
    }

    @Test
    public void passAssertLessThanOrEqualStringComparisonSameTest() {
        AssertService.assertLessThanOrEqual("D", "D");
    }

    @Test
    public void passAssertLessThanOrEqualTwoStringsComparisonTest() {
        AssertService.assertLessThanOrEqual("MM", "MN");
    }

    @Test
    public void passAssertLessThanOrEqualCharComparisonTest() {
        AssertService.assertLessThanOrEqual('M', 'N');
    }

    @Test
    public void passAssertLessThanOrEqualCharComparisonSameTest() {
        AssertService.assertLessThanOrEqual('M', 'M');
    }

    @Test
    public void passAssertLessThanOrEqualIntegerComparisonTest() {
        AssertService.assertLessThanOrEqual(1, 2);
    }

    @Test
    public void passAssertLessThanOrEqualIntegerComparisonSameTest() {
        AssertService.assertLessThanOrEqual(1, 1);
    }

    @Test
    public void passAssertLessThanOrEqualFloatComparisonSameTest() {
        AssertService.assertLessThanOrEqual(4.9999999, 4.9999999);
    }

    @Test
    public void passAssertLessThanOrEqualFloatComparisonTest() {
        AssertService.assertLessThanOrEqual(4.9999999, 5.01);
    }

    @Test
    public void passAssertLessThanOrEqualLongComparisonTest() {
        AssertService.assertLessThanOrEqual(3330L, 10000L);
    }

    @Test
    public void passAssertLessThanOrEqualLongComparisonSameTest() {
        AssertService.assertLessThanOrEqual(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualLongComparisonOutsideTest() {
        AssertService.assertLessThanOrEqual(5L, 1L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualFloatComparisonOutsideTest() {
        AssertService.assertLessThanOrEqual(5.01, 4.9999999);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualCharComparisonTest() {
        AssertService.assertLessThanOrEqual("Verify my failAssertLessThanOrEqualCharComparison", 'B', 'A');
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualIntegerAsStringsComparisonTest() {
        AssertService.assertLessThanOrEqual("999999999", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualStringComparisonTest() {
        AssertService.assertLessThanOrEqual("D", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualTwoStringsComparisonTest() {
        AssertService.assertLessThanOrEqual("DE", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualIntegerComparisonTest() {
        AssertService.assertLessThanOrEqual(4, 3);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualFloatComparisonTest() {
        AssertService.assertLessThanOrEqual(5.01, 4.99);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessThanOrEqualLongComparisonTest() {
        AssertService.assertLessThanOrEqual(9999443747397L, 9999443747396L);
    }

}
