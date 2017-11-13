package basics;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BasicAnnotations {

  @BeforeAll
  static void setUp() {
    System.out.println("Before All");
  }

  @AfterAll
  static void done() {
    System.out.println("@AfterAll - executed after all test methods.");
  }

  @BeforeEach
  void init() {
    System.out.println("BeforeEach");
  }

  @DisplayName("Wyswietlana nazwa")
  @Test
  void successTest() {
    System.out.println("Success");
  }

  @Test
  @Disabled("Disabled test")
  void disabledTest() {
    System.out.println("Disabled");
  }

  @AfterEach
  void tearDown() {
    System.out.println("@AfterEach - executed after each test method.");
  }

  @Nested
  @DisplayName("Test-Nested")
  class NestedTest {

    @DisplayName("Wyswietlana nazwa")
    @Test
    void successTest() {
      System.out.println("Nested Test - Success");
    }
  }
}
