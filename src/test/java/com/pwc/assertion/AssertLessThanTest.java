package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertLessThanTest extends AssertBaseTest {

    @Test
    public void passAssertLessBadFormattedVariableArgsTest() {
        AssertService.assertLessThan("my AssertService.assertion %s %s", 0, 99, "is going to pass");
    }

    @Test
    public void passAssertLessStringComparisonTest() {
        AssertService.assertLessThan("B", "C");
    }

    @Test
    public void passAssertLessTwoStringsComparisonTest() {
        AssertService.assertLessThan("My comment here", "A", "BB");
    }

    @Test
    public void passAssertLessCharComparisonTest() {
        AssertService.assertLessThan('A', 'T');
    }

    @Test
    public void passAssertLessIntegerComparisonTest() {
        AssertService.assertLessThan(77, 778);
    }

    @Test
    public void passAssertLessNegativeIntegerComparisonTest() {
        AssertService.assertLessThan(-777, -776);
    }

    @Test
    public void passAssertLessFloatComparisonTest() {
        AssertService.assertLessThan(4.99999991, 5.0);
    }

    @Test
    public void passAssertLessLongComparisonTest() {
        AssertService.assertLessThan(3330L, 3331L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessLongComparisonSameTest() {
        AssertService.assertLessThan(3331L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessLongComparisonOutsideTest() {
        AssertService.assertLessThan(3330L, 3330L);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessCharComparisonTest() {
        AssertService.assertLessThan("Verify my AssertService.assertion", 'B', 'B');
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessIntegerAsStringsComparisonTest() {
        AssertService.assertLessThan("100001", "100000");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessStringComparisonTest() {
        AssertService.assertLessThan("D", "C");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessTwoStringsComparisonTest() {
        AssertService.assertLessThan("My Comment", "DDD", "DD");
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessIntegerComparisonTest() {
        AssertService.assertLessThan(200, 100);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessFloatComparisonTest() {
        AssertService.assertLessThan(4.9999999, 4.9999998);
    }

    @Test(expected = AssertionError.class)
    public void failAssertLessLongComparisonTest() {
        AssertService.assertLessThan(3330L, 1L);
    }

}
