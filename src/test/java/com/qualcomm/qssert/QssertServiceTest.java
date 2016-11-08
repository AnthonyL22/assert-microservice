package com.qualcomm.qssert;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class QssertServiceTest {

    private QssertService mockQssertService;

    @Before
    public void setUp() {
        mockQssertService = mock(QssertService.class);
    }

    @Test
    public void softAssertByDefaultTest() {
        Assert.assertFalse(mockQssertService.isEnableHardAssertions());
    }

    @Test
    public void hardAssertionEnabledTest() {
        QssertService qssertService = new QssertService(true);
        Assert.assertTrue(qssertService.isEnableHardAssertions());
    }

    @Test
    public void hardAssertionDisabledTest() {
        QssertService qssertService = new QssertService(false);
        Assert.assertFalse(qssertService.isEnableHardAssertions());
    }

    @Test
    public void modifyAssertionHandlingDuringUseTest() {
        QssertService qssertService = new QssertService(false);
        Assert.assertFalse(qssertService.isEnableHardAssertions());
        qssertService.setEnableHardAssertions(true);
        Assert.assertTrue(qssertService.isEnableHardAssertions());
    }

}
