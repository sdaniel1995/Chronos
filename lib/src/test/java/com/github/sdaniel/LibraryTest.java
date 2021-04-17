package com.github.sdaniel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void testSomeLibraryMethod() {
        LoginServlet classUnderTest = new LoginServlet();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }
}
