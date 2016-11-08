package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertGreaterThanOrEqualTest extends AssertBaseTest {

    @Test
    public void passAssertGreaterThanOrEqualBadFormattedVariableArgsTest() {
        AssertService.assertGreaterThanOrEqual("my AssertService.assertion %s %s", 99, 99, "is going to pass");
    }

    @Test
    public void passAssertGreaterThanOrEqualCaseSensitiveTest() {
        AssertService.assertGreaterThanOrEqual("baaa", "Baaa");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualCaseSensitiveTest() {
        AssertService.assertGreaterThanOrEqual("Baaa", "baaa");
    }

    @Test
    public void passAssertGreaterThanOrEqualStringComparisonTest() {
        AssertService.assertGreaterThanOrEqual("D", "C");
    }

    @Test
    public void passAssertGreaterThanOrEqualStringComparisonSameTest() {
        AssertService.assertGreaterThanOrEqual("D", "D");
    }

    @Test
    public void passAssertGreaterThanOrEqualTwoStringsComparisonTest() {
        AssertService.assertGreaterThanOrEqual("MN", "MM");
    }

    @Test
    public void passAssertGreaterThanOrEqualCharComparisonTest() {
        AssertService.assertGreaterThanOrEqual('N', 'M');
    }

    @Test
    public void passAssertGreaterThanOrEqualCharComparisonSameTest() {
        AssertService.assertGreaterThanOrEqual('M', 'M');
    }

    @Test
    public void passAssertGreaterThanOrEqualIntegerComparisonTest() {
        AssertService.assertGreaterThanOrEqual(100000, 1);
    }

    @Test
    public void passAssertGreaterThanOrEqualIntegerComparisonSameTest() {
        AssertService.assertGreaterThanOrEqual(1, 1);
    }

    @Test
    public void passAssertGreaterThanOrEqualFloatComparisonSameTest() {
        AssertService.assertGreaterThanOrEqual(4.9999999, 4.9999999);
    }

    @Test
    public void passAssertGreaterThanOrEqualFloatComparisonTest() {
        AssertService.assertGreaterThanOrEqual(5.01, 4.9999999);
    }

    @Test
    public void passAssertGreaterThanOrEqualLongComparisonTest() {
        AssertService.assertGreaterThanOrEqual(9999443747397L, 3330L);
    }

    @Test
    public void passAssertGreaterThanOrEqualLongComparisonSameTest() {
        AssertService.assertGreaterThanOrEqual(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualLongComparisonOutsideTest() {
        AssertService.assertGreaterThanOrEqual(1L, 2L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualFloatComparisonOutsideTest() {
        AssertService.assertGreaterThanOrEqual(4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualCharComparisonTest() {
        AssertService.assertGreaterThanOrEqual("Verify my AssertService.assertion", 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualIntegerAsStringsComparisonTest() {
        AssertService.assertGreaterThanOrEqual("1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualStringComparisonTest() {
        AssertService.assertGreaterThanOrEqual("A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualTwoStringsComparisonTest() {
        AssertService.assertGreaterThanOrEqual("AB", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualIntegerComparisonTest() {
        AssertService.assertGreaterThanOrEqual(1, 100000);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualFloatComparisonTest() {
        AssertService.assertGreaterThanOrEqual(4.99, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualLongComparisonTest() {
        AssertService.assertGreaterThanOrEqual(9999443747396L, 9999443747397L);
    }

}
