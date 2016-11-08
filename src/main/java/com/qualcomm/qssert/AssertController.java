package com.qualcomm.qssert;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import java.util.Map;

import static com.qualcomm.qherkin.QherkinLoggerService.LOG;

public class AssertController extends Assertion {

    private Map<AssertionError, IAssert> verificationFailuresMap = Maps.newLinkedHashMap();

    /**
     * Override the TestNG default Assert life cycle
     *
     * @param assertCommand assertion command to execute
     */
    @Override
    public void executeAssert(IAssert assertCommand) {
        try {
            assertCommand.doAssert();
            onAssertSuccess(assertCommand);
        } catch (AssertionError ex) {
            onAssertFailure(assertCommand, ex);
            verificationFailuresMap.put(ex, assertCommand);
        }
    }

    /**
     * Altered path through Assertion lifecycle to override what we can do with
     * TestNGs assertion
     *
     * @param assertCommand assertion command to execute
     */
    @Override
    protected void doAssert(IAssert assertCommand) {
        executeAssert(assertCommand);
    }

    /**
     * Successful assertion override for special handling of passed
     * Assertions
     *
     * @param assertCommand current Assertion
     */
    @Override
    public void onAssertSuccess(IAssert assertCommand) {
        //Future Implementation
    }

    /**
     * Failures assertion override for special handling of failed
     * Assertions
     *
     * @param assertCommand ignored object
     * @param ex            Assertion error
     */
    @Override
    public void onAssertFailure(IAssert assertCommand, AssertionError ex) {
        logAssertionInformation(ex);
    }

    /**
     * Last piece of assertion chain to be called during @AfterClass to
     * check for and pop assertion errors accordingly
     */
    @AfterMethod(alwaysRun = true)
    public void assertionTearDown() {
        if (!verificationFailuresMap.isEmpty()) {
            ITestResult result = Reporter.getCurrentTestResult();
            LOG(true, "Number of Failures: %s", verificationFailuresMap.size());
            result.setStatus(ITestResult.FAILURE);
        }
    }

    /**
     * Utility method to call force a call to pass assertions
     *
     * @param msg assertion message
     */
    public void pass(final String msg) {
        assertTrue(true, msg);
    }

    /**
     * Output all assertion logging in a user-friendly fashion (WIP)
     *
     * @param currentError current exception that was thrown in event of failure
     */
    private void logAssertionInformation(AssertionError currentError) {
        if (currentError != null) {
            try {
                Reporter.getCurrentTestResult().setThrowable(currentError);
            } catch (Exception e) {
                throw new AssertionError(currentError);
            }
        }
    }

    public void setVerificationFailuresMap(Map<AssertionError, IAssert> verificationFailuresMap) {
        this.verificationFailuresMap = verificationFailuresMap;
    }

}
