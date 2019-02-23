package basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Test case")
class Tags {

  @Test
  @Tag("Method")
  void testMethod() {
    assertEquals(2 + 2, 4);
  }
}
