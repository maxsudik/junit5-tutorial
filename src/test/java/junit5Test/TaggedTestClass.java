package junit5Test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    @BeforeAll
    public void beforeAllMethod() {
        System.out.println("--This is the before All method");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("----This is the before Each method");
    }

    @AfterAll
    public void afterAllMethod() {
        System.out.println("--This is the the after ALl method");
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("----This is the after Each method");
    }

    @Test
    @Tag("sanity")
    public void firstMethod() {
        System.out.println("First Test");
    }

    @Test()
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("User Story 1234 / TC12 / this method is the second one")
    public void secondMethod() {
        System.out.println("Second Test");
    }

    @Test
    @Tag("acceptance")
    public void thirdMethod() {
        System.out.println("Third Test");
    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    public void intValues(int theParameter) {
        System.out.println("The Param = " + theParameter);
    }
}
