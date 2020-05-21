package com.pwc.assertion;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class AssertThatTest extends AssertBaseTest {

    @Test(expected = AssertionError.class)
    public void hardAssertionFailureTest() {
        AssertService assertService = new AssertService(true);
        assertService.assertThat("Unit Test", true, CoreMatchers.is(false));
    }

    @Test
    public void equalsLoggingTest() {
        AssertService.assertEquals("The testing of EQUALS logging", "x", "x");
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of EQUALS logging is 'x' was 'x'");
    }

    @Test
    public void notEqualsLoggingTest() {
        AssertService.assertNotEquals("The testing of NOT EQUALS logging", "x", "y");
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of NOT EQUALS logging is not 'y' was 'x'");
    }

    @Test
    public void containsLoggingTest() {
        AssertService.assertContains("The testing of CONTAINS logging", "abcxdefg", "x");
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of CONTAINS logging is a string containing 'x' was 'abcxdefg'");
    }

    @Test
    public void notContainsLoggingTest() {
        AssertService.assertNotContains("The testing of NOT CONTAINS logging", "yyyyyyabc", "x");
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of NOT CONTAINS logging not a string containing 'x' was 'yyyyyyabc'");
    }

    @Test
    public void nullLoggingTest() {
        AssertService.assertNull("The testing of NULL logging", null);
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of NULL logging is null was null");
    }

    @Test
    public void trueFalseLoggingTest() {
        AssertService.assertTrue("The testing of BOOLEAN logging", true, true);
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of BOOLEAN logging is <true> was <true>");
    }

    @Test
    public void betweenLoggingTest() {
        AssertService.assertBetween("The testing of BETWEEN logging", 5, 4, 6);
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of BETWEEN logging is (a value greater than <4> and a value less than <6>)");
    }

    @Test
    public void betweenOrEqualLoggingTest() {
        AssertService.assertBetweenOrEqual("The testing of BETWEEN OR EQUAL logging", 4, 4, 6);
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of BETWEEN OR EQUAL logging is (a value equal to or greater than <4> " + "and a value less than or equal to <6>)");
    }

    @Test
    public void collectionInOrderLoggingTest() {
        ArrayList actual = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        AssertService.assertCollectionInOrder("The testing of Collection IN ORDER logging", actual, new Object[] {1, 2, 3, 4, 5});
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of Collection IN ORDER logging is iterable containing [<1>, <2>, <3>, <4>, <5>]");
    }

    @Test
    public void collectionNotInOrderLoggingTest() {
        ArrayList actual = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        AssertService.assertCollectionNotInOrder("The testing of Collection NOT IN ORDER logging", actual, new Object[] {4, 3, 2, 1, 5});
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of Collection NOT IN ORDER logging is not iterable containing [<4>, <3>, <2>, <1>, <5>] " + "was <[1, 2, 3, 4, 5]>");
    }

    @Test
    public void assertRegexLoggingTest() {
        AssertService.assertRegexTrue("The testing of REGEX logging", REGEXABLE_SNIPPET, "^.*?Build\\ Time/Date:.*?\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z.*?$");
        Assert.assertEquals(AssertService.getOutputMessage(), "The testing of REGEX logging is matches regex='^.*?Build\\ Time/Date:.*?\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z.*?$' "
                        + "was 'foobar Build Time/Date: 2015-06-24T16:42:52Z foobar'");
    }

}
