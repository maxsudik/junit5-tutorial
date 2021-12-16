package junit5Test;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(Listener.class)
public class AssertionsTest {

    @Test
    public void assertEqualsTest() {
        Assertions.assertEquals("firstString", "secondString", "The string values were not equal");
    }

    @Test
    public void assertEqualsListTest() {
        List<String> expectedValue = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString");

        Assertions.assertEquals(expectedValue, actualValues);
    }

    @Test
    public void assertArraysEqualsTest() {
        int[] expectedValues = {1, 3};
        int[] actualValues = {1, 2, 3};

        Assertions.assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    public void assertTrueTest() {
        Assertions.assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    public void assertThrowsTest() {
        Assertions.assertThrows(NullPointerException.class, null);
    }

    @Test
    public void assertAllAssertions() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("firstString", "secondString", "The string values were not equal"),
                () -> Assertions.assertThrows(NullPointerException.class, null),
                () -> Assertions.assertTrue(false, "This boolean condition did not evaluate to true"));
    }

    @Test
    public void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, Matchers.hasValue(1));
        assertThat(theMap, Matchers.hasKey("secondKey"));
    }

    @Test
    public void assertForList() {
        List<String> theList = Arrays.asList("firstString", "secondString");
        assertThat(theList, Matchers.hasItem("secondString"));
    }

    @Test
    public void assertForAnyOf() {
        List<String> theList = Arrays.asList("firstString", "secondString");
        assertThat(theList, Matchers.anyOf(Matchers.hasItem("secondString"), Matchers.hasItem("noString")));
    }

    @Test
    public void assertForContainsAnyOrder() {
        List<String> theList = Arrays.asList("firstString", "secondString");
        assertThat(theList, Matchers.containsInAnyOrder("secondString", "firstString"));
    }
}
