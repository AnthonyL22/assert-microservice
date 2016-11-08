package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertBetweenTest extends AssertBaseTest {

    @Test
    public void passAssertBetweenBadFormattedVariableArgsTest() {
        QssertService.assertBetween("my QssertService.assertion %s", 1, 0, 99, "is going to pass");
    }

    @Test
    public void passAssertBetweenStringComparisonTest() {
        QssertService.assertBetween("B", "A", "C");
    }

    @Test
    public void passAssertBetweenTwoStringsComparisonTest() {
        QssertService.assertBetween("BA", "AB", "ZZ");
    }

    @Test
    public void passAssertBetweenCharComparisonTest() {
        QssertService.assertBetween('M', 'A', 'T');
    }

    @Test
    public void passAssertBetweenIntegerComparisonTest() {
        QssertService.assertBetween(5, 1, 100000);
    }

    @Test
    public void passAssertBetweenFloatComparisonTest() {
        QssertService.assertBetween(5.0, 4.9999999, 5.01);
    }

    @Test
    public void passAssertBetweenLongComparisonTest() {
        QssertService.assertBetween(3333L, 3330L, 9999443747397L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenCharComparisonTest() {
        QssertService.assertBetween("Verify my QssertService.assertion", 'M', 'A', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenIntegerAsStringsComparisonTest() {
        QssertService.assertBetween("5", "1", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenStringComparisonTest() {
        QssertService.assertBetween("D", "A", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenTwoStringsComparisonTest() {
        QssertService.assertBetween("AA", "AB", "ZZ");
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenIntegerComparisonTest() {
        QssertService.assertBetween(100001, 1, 100000);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenFloatComparisonTest() {
        QssertService.assertBetween(5.012, 4.9999999, 5.01);
    }

    @Test(expected = AssertionError.class)
    public void failAssertBetweenLongComparisonTest() {
        QssertService.assertBetween(3329L, 3330L, 9999443747397L);
    }

}
