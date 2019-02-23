package repeated;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.RepeatedTest;

class Junit5RepeatedTest {

  @RepeatedTest(value = 100, name = "Repetition {currentRepetition} of {totalRepetitions}")
  void shouldParallelSumReturnOfTenElementsReturn45() {
    assertEquals(45, IntStream.range(0, 10).parallel().sum());
  }

  @RepeatedTest(value = 100, name = RepeatedTest.LONG_DISPLAY_NAME)
  void shouldSequentialSumReturnOfTenElementsReturn45() {
    assertEquals(45, IntStream.range(0, 10).sum());
  }
}
