package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertCustomMatcherCollectionContainsTest extends AssertBaseTest {

    @Test
    public void passCollectionContainsTest() {
        AssertService.assertCollectionContains("Check Collection Contains", COLLECTION_SAMPLE, "777");
    }

    @Test
    public void passCollectionContainsMultipleParenthesisTest() {
        AssertService.assertCollectionContains("Check Collection Contains a string with Multiple Parans", COLLECTION_WITH_PARENTHESIS_ADVANCED_SAMPLE, "Rule 777(1)(d) - Over Here");
    }

    @Test
    public void passCollectionContainsParenthesisTest() {
        AssertService.assertCollectionContains("Check Collection Contains a string with parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples(12) are good");
    }

    @Test
    public void passCollectionContainsPartialParenthesisTest() {
        AssertService.assertCollectionContains("Check Collection Contains a string with partial parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples(12");
    }

    @Test
    public void passCollectionContainsMinPartialParenthesisTest() {
        AssertService.assertCollectionContains("Check Collection Contains a string with minimal partial parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples(");
    }

    @Test
    public void passCollectionContainsIntegersTest() {
        AssertService.assertCollectionContains("Check Collection Contains", COLLECTION_ORDERING_SAMPLE, "33");
    }

    @Test
    public void passCollectionNotContainsTest() {
        AssertService.assertCollectionNotContains("Check Collection Not Contains", COLLECTION_SAMPLE, "787");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionContainsTest() {
        AssertService.assertCollectionContains("Check Collection Contains", COLLECTION_SAMPLE, "888");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionContainsIntegersTest() {
        AssertService.assertCollectionContains("Check Collection Contains", COLLECTION_ORDERING_SAMPLE, "334");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionNotContainsTest() {
        AssertService.assertCollectionNotContains("Check Collection Not Contains", COLLECTION_SAMPLE, "777");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionContainsParenthesisTest() {
        AssertService.assertCollectionContains("Check Collection Contains a string with parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples are good");
    }

}
