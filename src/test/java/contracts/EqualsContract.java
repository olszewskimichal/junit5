package contracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import org.junit.jupiter.api.Test;

public interface EqualsContract<T> extends Testable<T> {

  T createNotEqualValue();

  @Test
  default void valueEqualsItself() {
    T value = createValue();
    assertEquals(value, value);
  }

  @Test
  default void valueDoesNotEqualNull() {
    T value = createValue();
    assertFalse(value.equals(null));
  }

  @Test
  default void valueDoesNotEqualDifferentValue() {
    assertTimeout(Duration.ofMillis(10), () -> {
      T value = createValue();
      T differentValue = createNotEqualValue();
      assertNotEquals(value, differentValue);
      assertNotEquals(differentValue, value);
    });
  }

}