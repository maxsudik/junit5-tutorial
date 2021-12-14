package junit5Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest {

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
