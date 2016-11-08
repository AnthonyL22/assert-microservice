package com.qualcomm.qssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertCustomMatcherRegexTest extends AssertBaseTest {

    @Test
    public void passNormalStringRegexTrueTest() {
        QssertService.assertRegexTrue("My Regex should return True Test", REGEXABLE_SNIPPET, "^.*?Build\\ Time/Date:.*?\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z.*?$");
    }

    @Test(expected = AssertionError.class)
    public void failNormalStringRegexTrueTest() {
        QssertService.assertRegexTrue("My Regex should return False Test", REGEXABLE_SNIPPET, "^.*?Build\\ Time/Date: abc ?\\w-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z.*?$");
    }

    @Test
    public void passNormalStringRegexFalseTest() {
        QssertService.assertRegexFalse("My Regex should return False Test", REGEXABLE_SNIPPET, "^.*?My Build\\ Time/Date:.*?\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z.*?$");
    }

    @Test(expected = AssertionError.class)
    public void failNormalStringRegexFalseTest() {
        QssertService.assertRegexFalse("My Regex should return True Test", REGEXABLE_SNIPPET, "^.*?Build\\ Time/Date:.*?\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z.*?$");
    }

}
