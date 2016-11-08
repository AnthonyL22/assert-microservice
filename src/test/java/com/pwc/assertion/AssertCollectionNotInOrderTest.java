package com.pwc.assertion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertCollectionNotInOrderTest extends AssertBaseTest {

    @Test
    public void assertCollectionNotInOrderTest() {
        AssertService.assertCollectionNotInOrder("Check Collection Not In Order", COLLECTION_ORDERING_SAMPLE, "22", "11", "33", "444");
    }

    @Test
    public void assertCollectionNotInButMissingCollectionElementsOrderTest() {
        AssertService.assertCollectionNotInOrder("Check Collection Not In Order", COLLECTION_ORDERING_SAMPLE, "22", "11");
    }

    @Test
    public void assertCollectionInOrderTest() {
        AssertService.assertCollectionNotInOrder("Check Collection Not In Order", COLLECTION_ORDERING_SAMPLE, "22", "11", "33", "444");
    }

    @Test(expected = AssertionError.class)
    public void assertCollectionInOrderShouldFailTest() {
        AssertService.assertCollectionNotInOrder("Check Collection In Order and Should Fail", COLLECTION_ORDERING_SAMPLE, "11", "22", "33", "444");
    }

}
