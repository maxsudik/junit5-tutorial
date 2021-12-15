package junit5Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

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

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel", "bucky,barnes",})
    public void csvSource_StringString(String one, String two) {
        System.out.println("param1 = " + one + ", param2 = " + two);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,21,false", "bucky,5,true"})
    public void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve,rogers'", "winter soldier,'bucky,barnes'"})
    public void csvSource_StringWithComa(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    public void csvSource_StringWithDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
}
