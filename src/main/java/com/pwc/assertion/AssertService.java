package com.pwc.assertion;

import com.jayway.restassured.path.json.JsonPath;
import com.pwc.assertion.matcher.CustomMatchers;
import com.pwc.logging.helper.LoggerHelper;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

import static com.pwc.logging.service.LoggerService.LOG;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.nullValue;

@Component
public class AssertService {

    private static AssertController assertController = new AssertController();
    private static boolean enableHardAssertions = false;
    private static String outputMessage;

    public AssertService() {
    }

    /**
     * Constructor to enable or disable assertions globally
     *
     * @param enableHardAssertions enable/disable setting
     */
    public AssertService(final boolean enableHardAssertions) {
        AssertService.enableHardAssertions = enableHardAssertions;
    }

    /**
     * Base method for all assertions
     *
     * @param message       message description
     * @param actual        actual value to assert upon
     * @param actualMatcher Matcher to use for the assertion
     */
    public static void assertThat(String message, Object actual, Matcher actualMatcher) {
        StringDescription stringDescription = new StringDescription();
        stringDescription.appendText(message + " ");
        actualMatcher.describeTo(stringDescription);
        actualMatcher.describeMismatch(actual, stringDescription.appendText(" "));
        outputMessage = StringUtils.replace(stringDescription.toString(), "\"", "\'").trim();
        if (!actualMatcher.matches(actual)) {
            if (enableHardAssertions) {
                Assert.fail(outputMessage);
            } else {
                assertFail(outputMessage);
            }
        } else {
            assertPass(outputMessage);
        }
    }

    public static void assertThat(final Object actual, final Matcher actualMatcher) {
        assertThat("", actual, actualMatcher);
    }

    public static void assertEquals(final Object actualObj, final Object expectedObj) {
        assertThat(actualObj, CoreMatchers.is(equalTo(expectedObj)));
    }

    public static void assertEquals(final String message, final Object actual, final Object expected, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(equalTo(expected)));
    }

    public static void assertEqualsIgnoreCase(final String actual, final String expected) {
        assertThat(actual, CoreMatchers.is(equalToIgnoringCase(expected)));
    }

    public static void assertEqualsIgnoreCase(final String message, final String actual, final String expected, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(equalToIgnoringCase(expected)));
    }

    public static void assertNotEquals(final Object actual, final Object expected) {
        assertThat(actual, CoreMatchers.is((not(equalTo(expected)))));
    }

    public static void assertNotEquals(final String message, final Object actual, final Object expected, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is((not(equalTo(expected)))));
    }

    public static void assertContainsInOrder(final String message, final String source, String... target) {
        assertThat(message, source, CoreMatchers.is(stringContainsInOrder(Arrays.asList(target))));
    }

    public static void assertContainsNotInOrder(final String message, final String source, String... target) {
        assertThat(message, source, CoreMatchers.is(new CustomMatchers.StringContainsNotInOrderMatcher(Arrays.asList(target))));
    }

    public static void assertContains(final String source, final String target) {
        assertThat(source, CoreMatchers.is(containsString(target)));
    }

    public static void assertContains(final String message, final String source, final String target, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), source, CoreMatchers.is(containsString(target)));
    }

    public static void assertContainsIgnoreCase(final String source, final String target) {
        assertTrue(StringUtils.containsIgnoreCase(source, target));
    }

    public static void assertContainsIgnoreCase(final String message, final String source, final String target, final Object... messageArgs) {
        assertTrue(message, StringUtils.containsIgnoreCase(source, target), messageArgs);
    }

    public static void assertNotContains(final String source, final String target) {
        assertThat(source, CoreMatchers.not(containsString(target)));
    }

    public static void assertNotContains(final String message, final String source, final String target, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), source, CoreMatchers.not(containsString(target)));
    }

    public static void assertNotNull(final Object actual) {
        assertThat(actual, CoreMatchers.is(not(nullValue())));
    }

    public static void assertNotNull(final String message, final Object actual, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(not(nullValue())));
    }

    public static void assertNull(final Object actual) {
        assertThat(actual, CoreMatchers.is(nullValue()));
    }

    public static void assertNull(final String message, final Object actual, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(nullValue()));
    }

    public static void assertFalse(final boolean actual) {
        assertThat(actual, CoreMatchers.is(false));
    }

    public static void assertFalse(final String message, final boolean actual, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(false));
    }

    public static void assertTrue(final boolean actual) {
        assertThat(actual, CoreMatchers.is(true));
    }

    public static void assertTrue(final String message, final boolean actual, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(true));
    }

    public static void assertBetween(final Object actual, final Object lowerBound, final Object upperBound) {
        assertThat(actual, CoreMatchers.is(both(greaterThan((Comparable) lowerBound)).and(lessThan((Comparable) upperBound))));
    }

    public static void assertBetween(final String message, final Object actual, final Object lowerBound, final Object upperBound, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(both(greaterThan((Comparable) lowerBound)).and(lessThan((Comparable) upperBound))));
    }

    public static void assertBetweenOrEqual(final Object actual, final Object lowerBound, final Object upperBound) {
        assertThat(actual, CoreMatchers.is(both(greaterThanOrEqualTo((Comparable) lowerBound)).and(lessThanOrEqualTo((Comparable) upperBound))));
    }

    public static void assertBetweenOrEqual(final String message, final Object actual, final Object lowerBound, final Object upperBound, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(both(greaterThanOrEqualTo((Comparable) lowerBound)).and(lessThanOrEqualTo((Comparable) upperBound))));
    }

    public static void assertGreaterThan(final Object actual, final Object expected) {
        assertThat(actual, CoreMatchers.is(greaterThan((Comparable) expected)));
    }

    public static void assertGreaterThan(final String message, final Object actual, final Object expected, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(greaterThan((Comparable) expected)));
    }

    public static void assertGreaterThanOrEqual(final Object actual, final Object expected) {
        assertThat(actual, CoreMatchers.is(greaterThanOrEqualTo((Comparable) expected)));
    }

    public static void assertGreaterThanOrEqual(final String message, final Object actual, final Object expected, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(greaterThanOrEqualTo((Comparable) expected)));
    }

    public static void assertLessThan(final Object actual, final Object expected) {
        assertThat(actual, CoreMatchers.is(lessThan((Comparable) expected)));
    }

    public static void assertLessThan(final String message, final Object actual, final Object expected, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(lessThan((Comparable) expected)));
    }

    public static void assertLessThanOrEqual(final Object actual, final Object expected) {
        assertThat(actual, CoreMatchers.is(lessThanOrEqualTo((Comparable) expected)));
    }

    public static void assertLessThanOrEqual(final String message, final Object actual, final Object expected, final Object... messageArgs) {
        assertThat(LoggerHelper.formatMessage(message, messageArgs), actual, CoreMatchers.is(lessThanOrEqualTo((Comparable) expected)));
    }

    public static void assertCollectionInOrder(final String message, final Collection actualSources, Object... elements) {
        assertThat(message, actualSources, CoreMatchers.is(contains(elements)));
    }

    public static void assertCollectionNotInOrder(final String message, final Collection actualSources, Object... elements) {
        assertThat(message, actualSources, CoreMatchers.is(not(contains(elements))));
    }

    public static void assertCollectionContains(final String message, final Collection actualSources, final Object expected) {
        assertThat(message, actualSources, CoreMatchers.is(new CustomMatchers.CollectionContainsMatcher(expected)));
    }

    public static void assertCollectionNotContains(final String message, final Collection actualSources, final Object expected) {
        assertThat(message, actualSources, CoreMatchers.is(not(new CustomMatchers.CollectionContainsMatcher(expected))));
    }

    public static void assertRegexTrue(final String message, final Object actual, final String regex) {
        assertThat(message, actual, CoreMatchers.is(new CustomMatchers.RegexMatcher(regex)));
    }

    public static void assertRegexFalse(final String message, final Object actual, final String regex) {
        assertThat(message, actual, CoreMatchers.is(not(new CustomMatchers.RegexMatcher(regex))));
    }

    public static void assertJsonFieldEquals(final JsonPath actualSource, final Object expectedField, final Object expected) {
        assertJsonFieldEquals("", actualSource, expectedField, expected);
    }

    public static void assertJsonFieldEquals(final String message, final JsonPath actualSource, final Object expectedField, final Object expected) {
        assertThat(message, actualSource, CoreMatchers.is(new CustomMatchers.JsonMatcher(expectedField, expected)));
    }

    public static void assertJsonFieldNotEquals(final JsonPath actualSource, final Object expectedField, final Object expected) {
        assertJsonFieldNotEquals("", actualSource, expectedField, expected);
    }

    public static void assertJsonFieldNotEquals(final String message, final JsonPath actualSource, final Object expectedField, final Object expected) {
        assertThat(message, actualSource, CoreMatchers.is(not(new CustomMatchers.JsonMatcher(expectedField, expected))));
    }

    public static void assertJsonContainsField(final JsonPath actualSource, final String expectedField) {
        assertJsonContainsField("", actualSource, expectedField);
    }

    public static void assertJsonContainsField(final String message, final JsonPath actualSource, final Object expectedField) {
        assertThat(message, actualSource, CoreMatchers.is(new CustomMatchers.JsonMatcher(expectedField, null)));
    }

    public static void assertJsonNotContainsField(final JsonPath actualSource, final Object expectedField) {
        assertJsonNotContainsField("", actualSource, expectedField);
    }

    public static void assertJsonNotContainsField(final String message, final JsonPath actualSource, final Object expectedField) {
        assertThat(message, actualSource, CoreMatchers.is(not(new CustomMatchers.JsonMatcher(expectedField, null))));
    }

    public static void assertPass(String message, final Object... messageArgs) {
        message = LoggerHelper.formatMessage(message, messageArgs);
        LOG(message);
        assertController.pass(message);
    }

    public static void assertFail(String message, final Object... messageArgs) {
        message = LoggerHelper.formatMessage(message, messageArgs);
        LOG(message);
        assertController.fail(message);
    }

    public static void assertFail(Throwable e) {
        LOG(e.getMessage() + ": " + LoggerHelper.convertStackTrace(e));
        assertController.fail(e.getMessage(), e);
    }

    public boolean isEnableHardAssertions() {
        return enableHardAssertions;
    }

    public void setEnableHardAssertions(boolean enableHardAssertions) {
        this.enableHardAssertions = enableHardAssertions;
    }

    public static String getOutputMessage() {
        return outputMessage;
    }

}
