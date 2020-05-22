package com.pwc.assertion.matcher;

import com.jayway.restassured.path.json.JsonPath;
import com.pwc.logging.helper.LoggerHelper;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CustomMatchers {

    /**
     * Assert if an object is contained within a Collection.
     * <p>
     * Note: toString() is called on each item in the collection to perform the RegEx
     */
    public static class CollectionContainsMatcher extends BaseMatcher {

        private static final String COLLECTION_CONTAINS_REGEX = "^.*?%s.*?$";
        private static final String COLLECTION_WITH_PARENTHESIS_CONTAINS_REGEX = "^.*?%s.*?$";
        private static Pattern pattern;
        protected Object expected;

        public CollectionContainsMatcher(Object expected) {
            this.expected = expected;
            if (expected instanceof String) {
                if (StringUtils.containsAny(expected.toString(), "()".toCharArray())) {
                    expected = StringUtils.replace(expected.toString(), "(", "\\(");
                    expected = StringUtils.replace(expected.toString(), ")", "\\)");
                    pattern = Pattern.compile(LoggerHelper.formatMessage(COLLECTION_WITH_PARENTHESIS_CONTAINS_REGEX, expected));
                    return;
                }

            }
            pattern = Pattern.compile(LoggerHelper.formatMessage(COLLECTION_CONTAINS_REGEX, expected));
        }

        @Override
        public boolean matches(Object actual) {
            List actualList = (List) actual;
            for (Object a : actualList) {
                java.util.regex.Matcher m = pattern.matcher(a.toString());
                if (m.matches()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("collection contains ");
            description.appendText(String.format("expected='%s'", expected));
            description.appendText(LoggerHelper.formatMessage("expected='%s'", expected));
        }
    }

    /**
     * String Similarity matcher to find how similar two Strings are.
     */
    public static class StringSimilarMatcher extends BaseMatcher {

        private final String sourceString;
        private final String targetString;
        private final double acceptableAmountOfSimilarity;

        public StringSimilarMatcher(String source, String target, double acceptableSimilarity) {
            this.sourceString = source;
            this.targetString = target;
            this.acceptableAmountOfSimilarity = acceptableSimilarity;
        }

        @Override
        public boolean matches(Object o) {
            double similarityRating = calculateSimilarity(sourceString, targetString);
            return StringUtils.equalsIgnoreCase(sourceString, targetString) || similarityRating >= acceptableAmountOfSimilarity;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(String.format("'%s' %s%s similar", targetString, acceptableAmountOfSimilarity, "%%"));
        }

        /**
         * Calculates the similarity (a number within 0 and 1) between two strings. 1.0 being an exact match and < 1.0 is
         * potentially less similar.
         *
         * @param baseString   source String to base similarity off of
         * @param targetString String to compare to
         * @return similarity rating
         */
        private static double calculateSimilarity(String baseString, String targetString) {

            String longer = baseString;
            String shorter = targetString;
            if (baseString.length() < targetString.length()) {
                longer = targetString;
                shorter = baseString;
            }
            int longerLength = longer.length();
            if (longerLength == 0) {
                return 1.0;
            }
            return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
        }

        /**
         * Similarity distance based on Levenshtein Distance algorithm.
         * http://rosettacode.org/wiki/Levenshtein_distance#Java
         *
         * @param baseString   source String to base similarity off of
         * @param targetString String to compare to
         * @return distance
         */
        private static int editDistance(String baseString, String targetString) {

            baseString = baseString.toLowerCase();
            targetString = targetString.toLowerCase();
            String finalTargetString = targetString;
            String finalBaseString = baseString;
            int[] costs = new int[targetString.length() + 1];

            IntStream.range(0, baseString.length()).forEach(i -> {
                int lastValue = i;
                for (int j = 0; j <= finalTargetString.length(); j++) {
                    if (i == 0) {
                        costs[j] = j;
                    } else {
                        if (j > 0) {
                            int newValue = costs[j - 1];
                            if (finalBaseString.charAt(i - 1) != finalTargetString.charAt(j - 1)) {
                                newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                            }
                            costs[j - 1] = lastValue;
                            lastValue = newValue;
                        }
                    }
                }
                if (i > 0) {
                    costs[finalTargetString.length()] = lastValue;
                }

            });

            return costs[targetString.length()];
        }

    }

    /**
     * Regex based matcher to find matching regex condition.
     */
    public static class RegexMatcher extends BaseMatcher {
        private final String regex;

        public RegexMatcher(String regex) {
            this.regex = regex;
        }

        @Override
        public boolean matches(Object o) {
            return ((String) o).matches(regex);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(String.format("matches regex='%s'", regex));
        }
    }

    /**
     * Asserts if a given String contains sub-strings in no particular order.
     */
    public static class StringContainsNotInOrderMatcher extends TypeSafeMatcher<String> {
        private final Iterable<String> substrings;

        public StringContainsNotInOrderMatcher(Iterable<String> substrings) {
            this.substrings = substrings;
        }

        public boolean matchesSafely(String s) {
            int fromIndex;
            Iterator stringIterator = this.substrings.iterator();

            do {
                if (!stringIterator.hasNext()) {
                    return true;
                }
                fromIndex = 0;
                String substring = (String) stringIterator.next();
                fromIndex = s.indexOf(substring, fromIndex);
            } while (fromIndex > -1);

            return false;
        }

        @Override
        public void describeMismatchSafely(String item, Description mismatchDescription) {
            mismatchDescription.appendText("was \"").appendText(item).appendText("\"");
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("a string containing ").appendValueList("", ", ", "", this.substrings).appendText(" in no particular order");
        }

    }

    /**
     * JSON matcher to find matching conditions.
     */
    public static class JsonMatcher extends BaseMatcher {

        private String expected;
        private final Object associated;

        public JsonMatcher(Object expected, Object associated) {
            this.expected = expected.toString();
            this.associated = associated;
        }

        @Override
        public boolean matches(Object actual) {
            JsonPath actualJsonPath = (JsonPath) actual;
            if (associated != null) {
                if (StringUtils.startsWith(expected, "$") && StringUtils.contains(expected, ".")) {
                    return matchesDeepJson(actualJsonPath);
                } else {
                    return StringUtils.equals(actualJsonPath.get(expected).toString(), String.valueOf(associated));
                }

            } else {
                return actualJsonPath.get(expected) != null;
            }

        }

        @Override
        public void describeTo(Description description) {
            if (associated != null) {
                description.appendText(String.format("JSON has item='%s' with value='%s'", expected, associated));
            } else {
                description.appendText(String.format("JSON has item='%s'", expected));
            }
        }

        private boolean matchesDeepJson(JsonPath actualJsonPath) {
            expected = StringUtils.remove(expected, "$");
            String[] queryList = StringUtils.split(expected, ".");
            HashMap resultMap = null;
            for (String query : queryList) {
                if (resultMap == null) {
                    resultMap = actualJsonPath.get(query);
                } else {
                    if (!(resultMap.get(query) instanceof Map)) {
                        return StringUtils.equals(resultMap.get(query).toString(), associated.toString());
                    } else {
                        resultMap = (HashMap) resultMap.get(query);
                    }
                }
            }
            return false;
        }
    }

}
