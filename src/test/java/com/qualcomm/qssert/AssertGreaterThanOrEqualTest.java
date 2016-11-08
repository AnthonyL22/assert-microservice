package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertGreaterThanOrEqualTest extends AssertBaseTest {

    @Test
    public void passAssertGreaterThanOrEqualBadFormattedVariableArgsTest() {
        QssertService.assertGreaterThanOrEqual("my QssertService.assertion %s %s", 99, 99, "is going to pass");
    }

    @Test
    public void passAssertGreaterThanOrEqualCaseSensitiveTest() {
        QssertService.assertGreaterThanOrEqual("baaa", "Baaa");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualCaseSensitiveTest() {
        QssertService.assertGreaterThanOrEqual("Baaa", "baaa");
    }

    @Test
    public void passAssertGreaterThanOrEqualStringComparisonTest() {
        QssertService.assertGreaterThanOrEqual("D", "C");
    }

    @Test
    public void passAssertGreaterThanOrEqualStringComparisonSameTest() {
        QssertService.assertGreaterThanOrEqual("D", "D");
    }

    @Test
    public void passAssertGreaterThanOrEqualTwoStringsComparisonTest() {
        QssertService.assertGreaterThanOrEqual("MN", "MM");
    }

    @Test
    public void passAssertGreaterThanOrEqualCharComparisonTest() {
        QssertService.assertGreaterThanOrEqual('N', 'M');
    }

    @Test
    public void passAssertGreaterThanOrEqualCharComparisonSameTest() {
        QssertService.assertGreaterThanOrEqual('M', 'M');
    }

    @Test
    public void passAssertGreaterThanOrEqualIntegerComparisonTest() {
        QssertService.assertGreaterThanOrEqual(100000, 1);
    }

    @Test
    public void passAssertGreaterThanOrEqualIntegerComparisonSameTest() {
        QssertService.assertGreaterThanOrEqual(1, 1);
    }

    @Test
    public void passAssertGreaterThanOrEqualFloatComparisonSameTest() {
        QssertService.assertGreaterThanOrEqual(4.9999999, 4.9999999);
    }

    @Test
    public void passAssertGreaterThanOrEqualFloatComparisonTest() {
        QssertService.assertGreaterThanOrEqual(5.01, 4.9999999);
    }

    @Test
    public void passAssertGreaterThanOrEqualLongComparisonTest() {
        QssertService.assertGreaterThanOrEqual(9999443747397L, 3330L);
    }

    @Test
    public void passAssertGreaterThanOrEqualLongComparisonSameTest() {
        QssertService.assertGreaterThanOrEqual(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualLongComparisonOutsideTest() {
        QssertService.assertGreaterThanOrEqual(1L, 2L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualFloatComparisonOutsideTest() {
        QssertService.assertGreaterThanOrEqual(4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualCharComparisonTest() {
        QssertService.assertGreaterThanOrEqual("Verify my QssertService.assertion", 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualIntegerAsStringsComparisonTest() {
        QssertService.assertGreaterThanOrEqual("1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualStringComparisonTest() {
        QssertService.assertGreaterThanOrEqual("A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualTwoStringsComparisonTest() {
        QssertService.assertGreaterThanOrEqual("AB", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualIntegerComparisonTest() {
        QssertService.assertGreaterThanOrEqual(1, 100000);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualFloatComparisonTest() {
        QssertService.assertGreaterThanOrEqual(4.99, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterThanOrEqualLongComparisonTest() {
        QssertService.assertGreaterThanOrEqual(9999443747396L, 9999443747397L);
    }

}
