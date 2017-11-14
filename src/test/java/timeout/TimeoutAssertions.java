package timeout;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.Test;

class TimeoutAssertions {

  @Test
  void shouldFinishIn100Milis() throws Exception {
    assertTimeout(ofMillis(100), () -> {
      assertEquals("FizzBuzz", "FizzBuzz");
      Thread.sleep(101);
    }, "Przekroczony czas wykonywania");
  }

  @Test
  void timeoutExceededWithPreemptiveTermination() {
    // The following assertion fails with an error message similar to:
    // execution timed out after 10 ms
    assertTimeoutPreemptively(ofMillis(10), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(100);
    });
  }

}
