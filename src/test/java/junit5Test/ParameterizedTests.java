package junit5Test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)//This line is for avoiding making methods in the class static
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

    @ParameterizedTest
    @CsvFileSource(files = {"src/main/resources/parameters/shopping.csv", "src/main/resources/parameters/shopping2.csv"}, numLinesToSkip = 1)
    public void csvFileSource_String_Double_Int_String_String(String name, double price, int quantity, String unit, String provider) {
        System.out.println("name " + name + " price " + price + " quantity " + quantity + " unit " + unit + " provider " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/main/resources/parameters/shopping3.csv"}, numLinesToSkip = 1, delimiterString = "_")
    public void csvFileSource_String_Double_Int_String_String2(String name, double price, int quantity, String unit, String provider) {
        System.out.println("name " + name + " price " + price + " quantity " + quantity + " unit " + unit + " provider " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    public void methodSource_String(String param1) {
        System.out.println("param1 = " + param1);
    }

    //To pass value from this method to a test make it either static or use @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    //above the class
    public List<String> sourceString() {
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    public void methodSource_StringStream(String param1) {
        System.out.println("param1 = " + param1);
    }

    public Stream<String> sourceStringAsStream() {
        return Stream.of("beetroot", "apple", "cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_String_Double")
    public void methodSource_StringDoubleList(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    public List<Arguments> sourceList_String_Double() {
        return Arrays.asList(Arguments.arguments("tomato", 2.0),
                Arguments.arguments("carrot", 4.5),
                Arguments.arguments("cabbage", 7.8));
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStream_StringDouble")
    public void methodSource_StringDoubleStream(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    public Stream<Arguments> sourceStream_StringDouble() {
        return Stream.of(Arguments.arguments("apple", 8.9), Arguments.arguments("pear", 1.9));
    }

    @ParameterizedTest
    @MethodSource(value = "junit5Test.ParamProvider#sourceStream_StringDouble")
    public void methodSource_StringDoubleStreamFromAnotherClass(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
}
