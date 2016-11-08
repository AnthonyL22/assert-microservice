package com.pwc.assertion;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AssertServiceTest {

    private AssertService mockAssertService;

    @Before
    public void setUp() {
        mockAssertService = mock(AssertService.class);
    }

    @Test
    public void softAssertByDefaultTest() {
        Assert.assertFalse(mockAssertService.isEnableHardAssertions());
    }

    @Test
    public void hardAssertionEnabledTest() {
        AssertService assertService = new AssertService(true);
        Assert.assertTrue(assertService.isEnableHardAssertions());
    }

    @Test
    public void hardAssertionDisabledTest() {
        AssertService assertService = new AssertService(false);
        Assert.assertFalse(assertService.isEnableHardAssertions());
    }

    @Test
    public void modifyAssertionHandlingDuringUseTest() {
        AssertService assertService = new AssertService(false);
        Assert.assertFalse(assertService.isEnableHardAssertions());
        assertService.setEnableHardAssertions(true);
        Assert.assertTrue(assertService.isEnableHardAssertions());
    }

}
