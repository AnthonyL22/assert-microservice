package com.qualcomm.qssert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AssertFailTest {

    private RuntimeException mockRuntimeException;

    @Before
    public void setUp() {
        mockRuntimeException = mock(RuntimeException.class);
    }

    @Test(expected = AssertionError.class)
    public void assertFailTest() {
        QssertService.assertFail("Unit test failure in test=%s", this.getClass().getName());
    }

    @Test(expected = AssertionError.class)
    public void assertFailExceptionTest() {
        StackTraceElement stackTraceElement = new StackTraceElement("UnitTestClass", "badMethod", "UnitTestClass.java", 777);
        StackTraceElement[] stackTraceElements = new StackTraceElement[2];
        stackTraceElements[0] = stackTraceElement;
        mockRuntimeException.setStackTrace(stackTraceElements);
        QssertService.assertFail(mockRuntimeException);
        verify(mockRuntimeException, times(1)).setStackTrace(stackTraceElements);
    }

}
