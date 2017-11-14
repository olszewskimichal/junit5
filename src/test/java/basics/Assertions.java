package basics;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import lombok.Value;
import org.junit.jupiter.api.Test;

public class Assertions {

  @Test
  void lambdaExpressions() {
    assertTrue(Stream.of(1, 2, 3)
        .mapToInt(i -> i)
        .sum() > 5, () -> "Sum should be greater than 5");
  }

  @Test
  void groupAssertions() {
    int[] numbers = {0, 1, 2, 3, 4};
    assertAll("numbers",
        () -> assertEquals(numbers[0], 0),
        () -> assertEquals(numbers[3], 3),
        () -> assertEquals(numbers[4], 4)
    );
  }

  @Test
  void dependentAssertions() {
    Person person = new Person("Jan", "De");

    assertAll("properties",
        () -> {
          String firstName = person.getFirstName();
          assertNotNull(firstName);

          assertAll("first name",
              () -> assertTrue(firstName.startsWith("J")),
              () -> assertTrue(firstName.endsWith("n"))
          );
        },
        () -> {
          String lastName = person.getLastName();
          assertNotNull(lastName);

          // Executed only if the previous assertion is valid.
          assertAll("last name",
              () -> assertTrue(lastName.startsWith("D")),
              () -> assertTrue(lastName.endsWith("e"))
          );
        }
    );
  }

  @Value
  private class Person {

    private final String firstName;
    private final String lastName;
  }


}
