package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertCustomMatcherSimilarStringsTest extends AssertBaseTest {

    @Test(expected = AssertionError.class)
    public void failExactMatchUnrealisticSimilarityRatingNumbersTest() {
        final double EXACT_MATCH_RATING = 1.0;
        AssertService.assertSimilarity("0.6 percent match", "12345", "12", EXACT_MATCH_RATING);
    }

    @Test
    public void passExactMatchUnrealisticSimilarityRatingTest() {
        final double EXACT_MATCH_RATING = 1.0;
        AssertService.assertSimilarity(SOURCE, SOURCE, EXACT_MATCH_RATING);
    }

    @Test
    public void passExactMatchUnrealisticSimilarityRatingDifferentCasingTest() {
        final double EXACT_MATCH_RATING = 1.0;
        AssertService.assertSimilarity("100 percent match", SOURCE, SOURCE.toLowerCase(), EXACT_MATCH_RATING);
    }

    @Test
    public void passExactSimilarityMatchTest() {
        final double EXACT_MATCH_RATING = 0.90;
        AssertService.assertSimilarity("0.92 match", SOURCE, SOURCE, EXACT_MATCH_RATING);
        AssertService.assertSimilarity(SOURCE, SOURCE, EXACT_MATCH_RATING);
    }

    @Test
    public void passHighMatch() {
        final double EXACT_MATCH_RATING = 0.6;
        AssertService.assertSimilarity("0.63 match", SOURCE, TARGET, EXACT_MATCH_RATING);
        AssertService.assertSimilarity(SOURCE, TARGET, EXACT_MATCH_RATING);
    }

    @Test
    public void passMediumMatch() {
        final double EXACT_MATCH_RATING = 0.3;
        AssertService.assertSimilarity("0.4 match", SOURCE, SOURCE + " and should be visited", EXACT_MATCH_RATING);
        AssertService.assertSimilarity(SOURCE, SOURCE + " and should be visited", EXACT_MATCH_RATING);
    }

    @Test(expected = AssertionError.class)
    public void failLowMatch() {
        final double EXACT_MATCH_RATING = 0.5;
        AssertService.assertSimilarity("0.23 match", SOURCE, "adfadfadfa", EXACT_MATCH_RATING);
        AssertService.assertSimilarity(SOURCE, "adfadfadfa", EXACT_MATCH_RATING);
    }

    @Test(expected = AssertionError.class)
    public void failNearlyZeroMatch() {
        final double EXACT_MATCH_RATING = 1.0;
        AssertService.assertSimilarity("Check how Similar", SOURCE, "ljasdkljfldjsfadsjlfja", EXACT_MATCH_RATING);
        AssertService.assertSimilarity(SOURCE, "ljasdkljfldjsfadsjlfja", EXACT_MATCH_RATING);
    }

}
