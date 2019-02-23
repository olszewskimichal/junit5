package parameterized;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeTest {

  private static boolean isPalindrome(String candidate) {
    int length = candidate.length();
    for (int i = 0; i < length / 2; i++) {
      if (candidate.charAt(i) != candidate.charAt(length - (i + 1))) {
        return false;
      }
    }
    return true;
  }

  static Stream<String> stringProvider() {
    return Stream.of("foo", "bar");
  }

  @ParameterizedTest
  @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
  void palindromes(String candidate) {
    assertTrue(isPalindrome(candidate));
  }

  @ParameterizedTest
  @EnumSource(TimeUnit.class)
  void testWithEnumSource(TimeUnit timeUnit) {
    assertNotNull(timeUnit);
  }

  @ParameterizedTest
  @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
  void testWithEnumSourceInclude(TimeUnit timeUnit) {
    assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
  }

  @ParameterizedTest
  @MethodSource("stringProvider")
  void testWithSimpleMethodSource(String argument) {
    assertNotNull(argument);
  }

  @ParameterizedTest
  @CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
  void testWithCsvSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }


}
