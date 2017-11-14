package injections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class DependencyInjectionTest {

  @BeforeEach
  void init(TestInfo testInfo) {
    String displayName = testInfo.getDisplayName();
    System.out.printf("@BeforeEach %s %n", displayName);
  }

  @Test
  @DisplayName("My test")
  @Tag("my-tag")
  void testOne(TestInfo testInfo) {
    System.out.println(testInfo.getDisplayName());
    System.out.println(testInfo.getTags());
    System.out.println(testInfo.getTestClass());
    System.out.println(testInfo.getTestMethod());
  }

  @Test
  void reportSingleValue(TestReporter testReporter) {
    testReporter.publishEntry("key", "value");
  }

  @RepeatedTest(2)
  void test(RepetitionInfo repetitionInfo) {
    System.out.println("** Test " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
  }
}
