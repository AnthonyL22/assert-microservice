package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertCustomMatcherCollectionContainsTest extends AssertBaseTest {

    @Test
    public void passCollectionContainsTest() {
        QssertService.assertCollectionContains("Check Collection Contains", COLLECTION_SAMPLE, "777");
    }

    @Test
    public void passCollectionContainsMultipleParenthesisTest() {
        QssertService.assertCollectionContains("Check Collection Contains a string with Multiple Parans", COLLECTION_WITH_PARENTHESIS_ADVANCED_SAMPLE, "Rule 777(1)(d) - Over Here");
    }

    @Test
    public void passCollectionContainsParenthesisTest() {
        QssertService.assertCollectionContains("Check Collection Contains a string with parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples(12) are good");
    }

    @Test
    public void passCollectionContainsPartialParenthesisTest() {
        QssertService.assertCollectionContains("Check Collection Contains a string with partial parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples(12");
    }

    @Test
    public void passCollectionContainsMinPartialParenthesisTest() {
        QssertService.assertCollectionContains("Check Collection Contains a string with minimal partial parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples(");
    }

    @Test
    public void passCollectionContainsIntegersTest() {
        QssertService.assertCollectionContains("Check Collection Contains", COLLECTION_ORDERING_SAMPLE, "33");
    }

    @Test
    public void passCollectionNotContainsTest() {
        QssertService.assertCollectionNotContains("Check Collection Not Contains", COLLECTION_SAMPLE, "787");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionContainsTest() {
        QssertService.assertCollectionContains("Check Collection Contains", COLLECTION_SAMPLE, "888");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionContainsIntegersTest() {
        QssertService.assertCollectionContains("Check Collection Contains", COLLECTION_ORDERING_SAMPLE, "334");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionNotContainsTest() {
        QssertService.assertCollectionNotContains("Check Collection Not Contains", COLLECTION_SAMPLE, "777");
    }

    @Test(expected = AssertionError.class)
    public void failCollectionContainsParenthesisTest() {
        QssertService.assertCollectionContains("Check Collection Contains a string with parans", COLLECTION_WITH_PARENTHESIS_SAMPLE, "apples are good");
    }

}
