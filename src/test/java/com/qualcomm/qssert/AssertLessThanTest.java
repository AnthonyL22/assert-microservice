package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertLessThanTest extends AssertBaseTest {

    @Test
    public void passAssertLessBadFormattedVariableArgsTest() {
        QssertService.assertLessThan("my QssertService.assertion %s %s", 0, 99, "is going to pass");
    }

    @Test
    public void passAssertLessStringComparisonTest() {
        QssertService.assertLessThan("B", "C");
    }

    @Test
    public void passAssertLessTwoStringsComparisonTest() {
        QssertService.assertLessThan("My comment here", "A", "BB");
    }

    @Test
    public void passAssertLessCharComparisonTest() {
        QssertService.assertLessThan('A', 'T');
    }

    @Test
    public void passAssertLessIntegerComparisonTest() {
        QssertService.assertLessThan(77, 778);
    }

    @Test
    public void passAssertLessNegativeIntegerComparisonTest() {
        QssertService.assertLessThan(-777, -776);
    }

    @Test
    public void passAssertLessFloatComparisonTest() {
        QssertService.assertLessThan(4.99999991, 5.0);
    }

    @Test
    public void passAssertLessLongComparisonTest() {
        QssertService.assertLessThan(3330L, 3331L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessLongComparisonSameTest() {
        QssertService.assertLessThan(3331L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessLongComparisonOutsideTest() {
        QssertService.assertLessThan(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessCharComparisonTest() {
        QssertService.assertLessThan("Verify my QssertService.assertion", 'B', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessIntegerAsStringsComparisonTest() {
        QssertService.assertLessThan("100001", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessStringComparisonTest() {
        QssertService.assertLessThan("D", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessTwoStringsComparisonTest() {
        QssertService.assertLessThan("My Comment", "DDD", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessIntegerComparisonTest() {
        QssertService.assertLessThan(200, 100);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessFloatComparisonTest() {
        QssertService.assertLessThan(4.9999999, 4.9999998);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessLongComparisonTest() {
        QssertService.assertLessThan(3330L, 1L);
    }

}
