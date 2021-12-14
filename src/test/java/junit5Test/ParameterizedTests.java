package junit5Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    public void intValues(int theParameter) {
        System.out.println("The Param = " + theParameter);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"firstString", "secondString"})
    public void stringValues(String theParameter) {
        System.out.println("theParam = " + theParameter);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString2", "secondString2"})
    public void stringValues2(String theParameter) {
        System.out.println("theParam = " + theParameter);
    }
}
