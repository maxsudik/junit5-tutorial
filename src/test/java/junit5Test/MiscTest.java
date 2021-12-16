package junit5Test;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void timeoutTest() throws InterruptedException {
        System.out.println("This is the test with the timeout");
        Thread.sleep(6000);
    }

    @Test
    @Timeout(99)
    @DisplayName("This is the nice method")
    @Tag("the tag")
    public void annotatedMethod1() {
        System.out.println("This is the annotated method");
    }

    @MyAnnotation
    public void annotatedMethod2() throws InterruptedException {
        System.out.println("This is the custom annotated method");
        Thread.sleep(3000);
    }


    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest {
        @BeforeAll
        public void beforeAll() {
            System.out.println("Before ALl in the nested test");
        }

        @Test
        public void nestedTestMethod() {
            System.out.println("Nested test method");
        }
    }
}
