package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertCollectionNotInOrderTest extends AssertBaseTest {

    @Test
    public void assertCollectionNotInOrderTest() {
        QssertService.assertCollectionNotInOrder("Check Collection Not In Order", COLLECTION_ORDERING_SAMPLE, "22", "11", "33", "444");
    }

    @Test
    public void assertCollectionNotInButMissingCollectionElementsOrderTest() {
        QssertService.assertCollectionNotInOrder("Check Collection Not In Order", COLLECTION_ORDERING_SAMPLE, "22", "11");
    }

    @Test
    public void assertCollectionInOrderTest() {
        QssertService.assertCollectionNotInOrder("Check Collection Not In Order", COLLECTION_ORDERING_SAMPLE, "22", "11", "33", "444");
    }

    @Test(expected = AssertionError.class)
    public void assertCollectionInOrderShouldFailTest() {
        QssertService.assertCollectionNotInOrder("Check Collection In Order and Should Fail", COLLECTION_ORDERING_SAMPLE, "11", "22", "33", "444");
    }

}
