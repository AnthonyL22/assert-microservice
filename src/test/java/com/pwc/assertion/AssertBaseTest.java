package com.pwc.assertion;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssertBaseTest {

    AssertService mockAssertService;

    protected static final String REGEXABLE_SNIPPET = "foobar Build Time/Date: 2015-06-24T16:42:52Z foobar";
    protected static final String SOURCE = "Piha is great";
    protected static final String TARGET = "Piha Beach is great";
    protected static final List<String> COLLECTION_SAMPLE = new ArrayList<>(Arrays.asList("anth777ony", "robert", "tim"));
    protected static final List<String> COLLECTION_WITH_PARENTHESIS_SAMPLE = new ArrayList<>(Arrays.asList("jon", "apples(12) are good", "tim"));
    protected static final List<String> COLLECTION_WITH_PARENTHESIS_ADVANCED_SAMPLE = new ArrayList<>(Arrays.asList("jon", "Rule 777(1)(d) - Over Here", "tim", "anthony"));
    protected static final List<String> COLLECTION_ORDERING_SAMPLE = new ArrayList<>(Arrays.asList("11", "22", "33", "444"));

    @Before
    public void before() {
        mockAssertService = new AssertService();
    }

}
