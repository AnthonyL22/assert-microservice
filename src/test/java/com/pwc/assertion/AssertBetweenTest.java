package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertBetweenTest extends AssertBaseTest {

    @Test
    public void passAssertBetweenBadFormattedVariableArgsTest() {
        AssertService.assertBetween("my AssertService.assertion %s", 1, 0, 99, "is going to pass");
    }

    @Test
    public void passAssertBetweenStringComparisonTest() {
        AssertService.assertBetween("B", "A", "C");
    }

    @Test
    public void passAssertBetweenTwoStringsComparisonTest() {
        AssertService.assertBetween("BA", "AB", "ZZ");
    }

    @Test
    public void passAssertBetweenCharComparisonTest() {
        AssertService.assertBetween('M', 'A', 'T');
    }

    @Test
    public void passAssertBetweenIntegerComparisonTest() {
        AssertService.assertBetween(5, 1, 100000);
    }

    @Test
    public void passAssertBetweenFloatComparisonTest() {
        AssertService.assertBetween(5.0, 4.9999999, 5.01);
    }

    @Test
    public void passAssertBetweenLongComparisonTest() {
        AssertService.assertBetween(3333L, 3330L, 9999443747397L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenCharComparisonTest() {
        AssertService.assertBetween("Verify my AssertService.assertion", 'M', 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenIntegerAsStringsComparisonTest() {
        AssertService.assertBetween("5", "1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenStringComparisonTest() {
        AssertService.assertBetween("D", "A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenTwoStringsComparisonTest() {
        AssertService.assertBetween("AA", "AB", "ZZ");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenIntegerComparisonTest() {
        AssertService.assertBetween(100001, 1, 100000);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenFloatComparisonTest() {
        AssertService.assertBetween(5.012, 4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenLongComparisonTest() {
        AssertService.assertBetween(3329L, 3330L, 9999443747397L);
    }

}
