package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertGreaterThanTest extends AssertBaseTest {

    @Test
    public void passAssertGreaterBadFormattedVariableArgsTest() {
        AssertService.assertGreaterThan("my AssertService.assertion %s %s", 100, 0, 99, "is going to pass");
    }

    @Test
    public void passAssertGreaterStringComparisonTest() {
        AssertService.assertGreaterThan("D", "C");
    }

    @Test
    public void passAssertGreaterTwoStringsComparisonTest() {
        AssertService.assertGreaterThan("My comment here", "ZZ", "BB");
    }

    @Test
    public void passAssertGreaterCharComparisonTest() {
        AssertService.assertGreaterThan('T', 'A');
    }

    @Test
    public void passAssertGreaterIntegerComparisonTest() {
        AssertService.assertGreaterThan(778, 77);
    }

    @Test
    public void passAssertGreaterFloatComparisonTest() {
        AssertService.assertGreaterThan(5.0, 4.99999991);
    }

    @Test
    public void passAssertGreaterLongComparisonTest() {
        AssertService.assertGreaterThan(3331L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterLongComparisonSameTest() {
        AssertService.assertGreaterThan(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterLongComparisonOutsideTest() {
        AssertService.assertGreaterThan(3329L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterCharComparisonTest() {
        AssertService.assertGreaterThan("Verify my AssertService.assertion", 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterIntegerAsStringsComparisonTest() {
        AssertService.assertGreaterThan("1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterStringComparisonTest() {
        AssertService.assertGreaterThan("A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterTwoStringsComparisonTest() {
        AssertService.assertGreaterThan("My Comment", "AB", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterIntegerComparisonTest() {
        AssertService.assertGreaterThan(0, 1);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterFloatComparisonTest() {
        AssertService.assertGreaterThan(4.9999998, 4.9999999);
    }

    @Test(expected = AssertionError.class)
    public void failAssertGreaterLongComparisonTest() {
        AssertService.assertGreaterThan(0L, 3330L);
    }

}
