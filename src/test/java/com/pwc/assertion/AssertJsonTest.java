package com.pwc.assertion;

import com.jayway.restassured.path.json.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssertJsonTest extends AssertBaseTest {

    public static final String TEST_JSON =
            "{\"uuid\": 777," +
                    "        \"firstName\": \"Bar\"," +
                    "        \"middleName\": \"K\"," +
                    "        \"superhero\": true," +
                    "        \"sleepy\": false," +
                    "        \"lastName\": \"Foo\"," +
                    "        \"emailAddress\": \"foobar@emailme.com\"," +
                    "        \"hireDate\": \"2007-07-02\"," +
                    "        \"officeCountry\": {" +
                    "          \"name\": \"US\"," +
                    "          \"description\": \"United States\"," +
                    "          \"displayValue\": \"United States\"," +
                    "          \"usa\": true," +
                    "          \"pct\": false," +
                    "          \"foreign\": false," +
                    "          \"ep\": false," +
                    "          \"vietnam\": false," +
                    "          \"jikp\": false," +
                    "          \"identifyingValue\": \"814\"" +
                    "        }," +
                    "        \"officeCity\": \"San Diego\"," +
                    "        \"_links\": {" +
                    "          \"self\": {" +
                    "            \"href\": \"http://foobar.com/api/me-webservice/employees/123\"" +
                    "          }," +
                    "          \"employee\": {" +
                    "            \"href\": \"http://foobar.com/api/you-webservice/employees/321\"" +
                    "          }" +
                    "        }" +
                    "      }";
    private static final JsonPath JSON_PATH = new JsonPath(TEST_JSON);

    @Test
    public void assertJsonFieldEqualsBooleanTrueTest() {
        AssertService.assertJsonFieldEquals(JSON_PATH, "superhero", true);
    }

    @Test
    public void assertJsonFieldEqualsBooleanFalseTest() {
        AssertService.assertJsonFieldEquals(JSON_PATH, "sleepy", "false");
    }

    @Test
    public void assertJsonFieldEqualsDeeperInnerJSONTest() {
        AssertService.assertJsonFieldEquals(JSON_PATH, "$_links.self.href", "http://foobar.com/api/me-webservice/employees/123");
    }

    @Test
    public void assertJsonFieldEqualsDeeperJSONTest() {
        AssertService.assertJsonFieldEquals(JSON_PATH, "$officeCountry.displayValue", "United States");
    }

    @Test
    public void assertJsonFieldEqualsNoMessageTest() {
        AssertService.assertJsonFieldEquals(JSON_PATH, "lastName", "Foo");
    }

    @Test
    public void assertJsonFieldNotEqualsNoMessageTest() {
        AssertService.assertJsonFieldNotEquals(JSON_PATH, "lastName", "Foobar");
    }

    @Test
    public void assertJsonFieldNotEqualsTest() {
        AssertService.assertJsonFieldNotEquals("Unit Test", JSON_PATH, "lastName", "Foobar");
    }

    @Test
    public void assertJsonFieldEqualsTest() {
        AssertService.assertJsonFieldEquals("Unit Test", JSON_PATH, "emailAddress", "foobar@emailme.com");
    }

    @Test
    public void jsonContainsItemNoMessageTest() {
        AssertService.assertJsonContainsField(JSON_PATH, "hireDate");
    }

    @Test
    public void jsonContainsItemTest() {
        AssertService.assertJsonContainsField("Unit Test", JSON_PATH, "hireDate");
    }

    @Test
    public void jsonNotContainsItemNoMessageTest() {
        AssertService.assertJsonNotContainsField(JSON_PATH, "google");
    }

    @Test
    public void jsonNotContainsItemTest() {
        AssertService.assertJsonNotContainsField("Unit Test", JSON_PATH, "google");
    }

}
