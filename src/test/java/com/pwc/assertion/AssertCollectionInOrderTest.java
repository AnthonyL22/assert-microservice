package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertCollectionInOrderTest extends AssertBaseTest {

    @Test
    public void collectionInOrderTest() {
        AssertService.assertCollectionInOrder("Check Collection In Order", COLLECTION_ORDERING_SAMPLE, "11", "22", "33", "444");
    }

    @Test(expected = AssertionError.class)
    public void collectionInOrderButMissingCollectionElementsTest() {
        AssertService.assertCollectionInOrder("Check Collection In Order", COLLECTION_ORDERING_SAMPLE, "11", "22");
    }

    @Test(expected = AssertionError.class)
    public void collectionNotInOrderTest() {
        AssertService.assertCollectionInOrder("Check Collection In Order", COLLECTION_ORDERING_SAMPLE, "22", "11", "33", "444");
    }

}
