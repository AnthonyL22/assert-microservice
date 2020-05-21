package com.pwc.assertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.IAssert;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AssertControllerTest {

    private AssertController assertController;
    private IAssert mockIAssert;
    private ITestResult mockITestResult;
    private AssertionError mockAssertionError;
    private Reporter mockReporter;
    private Map<AssertionError, IAssert> verificationFailuresMap;

    @Before
    public void setUp() {
        assertController = new AssertController();
        mockIAssert = mock(IAssert.class);
        mockITestResult = mock(ITestResult.class);
        mockAssertionError = mock(AssertionError.class);
        mockReporter = mock(Reporter.class);

        verificationFailuresMap = new HashMap<>();
        verificationFailuresMap.put(mockAssertionError, mockIAssert);
    }

    @After
    public void tearDown() {
        Reporter.setCurrentTestResult(null);
    }

    @Test
    public void assertionTearDownTest() {
        Reporter.setCurrentTestResult(mockITestResult);
        assertController.setVerificationFailuresMap(verificationFailuresMap);
        assertController.assertionTearDown();
        Assert.assertEquals(mockITestResult.getStatus(), 0);
    }

    @Test(expected = NullPointerException.class)
    public void assertionTearDownNullITestResultTest() {
        assertController.setVerificationFailuresMap(verificationFailuresMap);
        assertController.assertionTearDown();
    }

    @Test
    public void assertionTearDownEmptyFailureMapTest() {
        verificationFailuresMap.clear();
        assertController.setVerificationFailuresMap(verificationFailuresMap);
        assertController.assertionTearDown();
    }

    @Test
    public void executeAssertTest() {
        assertController.executeAssert(mockIAssert);
    }

    @Test
    public void doAssertTest() {
        assertController.doAssert(mockIAssert);
    }

    @Test
    public void onAssertSuccessTest() {
        assertController.onAssertSuccess(mockIAssert);
    }

    @Test
    public void onAssertFailureNullErrorTest() {
        assertController.onAssertFailure(mockIAssert, null);
    }

    @Test
    public void onAssertFailureReporterTest() {
        Reporter.setCurrentTestResult(mockITestResult);
        StackTraceElement stackTraceElement = new StackTraceElement("UnitTestClass", "badMethod", "UnitTestClass.java", 777);
        StackTraceElement[] stackTraceElements = new StackTraceElement[2];
        stackTraceElements[0] = stackTraceElement;
        mockAssertionError.setStackTrace(stackTraceElements);
        assertController.onAssertFailure(mockIAssert, mockAssertionError);
        verify(mockAssertionError, times(1)).setStackTrace(stackTraceElements);
    }

    @Test(expected = AssertionError.class)
    public void onAssertFailureExceptionTest() {
        StackTraceElement stackTraceElement = new StackTraceElement("UnitTestClass", "badMethod", "UnitTestClass.java", 777);
        StackTraceElement stackTraceElement2 = new StackTraceElement("UnitTest2Class", "reallyBadMethod", "UnitTest2Class.java", 12);
        StackTraceElement[] stackTraceElements = new StackTraceElement[2];
        stackTraceElements[0] = stackTraceElement;
        stackTraceElements[1] = stackTraceElement2;
        mockAssertionError.setStackTrace(stackTraceElements);
        assertController.onAssertFailure(mockIAssert, mockAssertionError);
        verify(mockAssertionError, times(1)).setStackTrace(stackTraceElements);
    }

}
