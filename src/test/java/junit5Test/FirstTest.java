package junit5Test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest {

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
    public void firstMethod() {
        System.out.println("First Test");
    }

    @Test
    @DisplayName("User Story 1234 / TC12 / this method is the second one")
    public void secondMethod() {
        System.out.println("Second Test");
    }
}
