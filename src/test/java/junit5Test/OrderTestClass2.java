package junit5Test;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTestClass2 {

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
    @Order(2)
    public void firstMethod() {
        System.out.println("First Test");
    }

    @Test
    @Order(3)
    @DisplayName("User Story 1234 / TC12 / this method is the second one")
    public void secondMethod() {
        System.out.println("Second Test");
    }

    @Test
    @Order(1)
    public void thirdMethod() {
        System.out.println("Third Test");
    }
}
