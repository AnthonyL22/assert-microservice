package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertGreaterThanTest extends AssertBaseTest {

    @Test
    public void passAssertGreaterBadFormattedVariableArgsTest() {
        QssertService.assertGreaterThan("my QssertService.assertion %s %s", 100, 0, 99, "is going to pass");
    }

    @Test
    public void passAssertGreaterStringComparisonTest() {
        QssertService.assertGreaterThan("D", "C");
    }

    @Test
    public void passAssertGreaterTwoStringsComparisonTest() {
        QssertService.assertGreaterThan("My comment here", "ZZ", "BB");
    }

    @Test
    public void passAssertGreaterCharComparisonTest() {
        QssertService.assertGreaterThan('T', 'A');
    }

    @Test
    public void passAssertGreaterIntegerComparisonTest() {
        QssertService.assertGreaterThan(778, 77);
    }

    @Test
    public void passAssertGreaterFloatComparisonTest() {
        QssertService.assertGreaterThan(5.0, 4.99999991);
    }

    @Test
    public void passAssertGreaterLongComparisonTest() {
        QssertService.assertGreaterThan(3331L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterLongComparisonSameTest() {
        QssertService.assertGreaterThan(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterLongComparisonOutsideTest() {
        QssertService.assertGreaterThan(3329L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterCharComparisonTest() {
        QssertService.assertGreaterThan("Verify my QssertService.assertion", 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterIntegerAsStringsComparisonTest() {
        QssertService.assertGreaterThan("1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterStringComparisonTest() {
        QssertService.assertGreaterThan("A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterTwoStringsComparisonTest() {
        QssertService.assertGreaterThan("My Comment", "AB", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterIntegerComparisonTest() {
        QssertService.assertGreaterThan(0, 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterFloatComparisonTest() {
        QssertService.assertGreaterThan(4.9999998, 4.9999999);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterLongComparisonTest() {
        QssertService.assertGreaterThan(0L, 3330L);
    }

}
