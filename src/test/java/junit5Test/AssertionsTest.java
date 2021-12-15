package junit5Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}
