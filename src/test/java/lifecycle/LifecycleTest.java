package lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class LifecycleTest implements TestLifecycleLogger, TimeExecutionLogger {

  @Test
  void sleep20ms() throws Exception {
    Thread.sleep(20);
  }

  @Test
  void sleep50ms() throws Exception {
    Thread.sleep(50);
  }

  @Test
  void isEqualValue() {
    assertEquals(1, 1, "is always equal");
  }

}
