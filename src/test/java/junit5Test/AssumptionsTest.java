package junit5Test;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    public void intValues(int theParameter) {
        Assumptions.assumeTrue(theParameter > 4);
        System.out.println("The Param = " + theParameter);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel", "bucky,barnes",})
    public void csvSource_StringString(String one, String two) {
        Assumptions.assumeFalse(one.equals("steve"), "The assumption failed for the following parameter2: " + two);
        System.out.println("param1 = " + one + ", param2 = " + two);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,21,false", "bucky,5,true"})
    public void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        Assumptions.assumingThat(param2 > 20, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
