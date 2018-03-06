package condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

class ConditionExample {

  @Test
  @DisabledOnWindows
  void shouldDisableTestOnWindows() {

  }

  @Test
  @DisabledOnMac
  void shouldDisableTestOnMac() {

  }

  @Test
  @DisabledIf("new Date().getDay() === 1")
  void shouldDisableTestIfMonday() {

  }

  @Test
  @EnabledOnJRE8
  void shouldEnableTestOnJRE8() {

  }

  @Test
  @DisabledOnJRE8
  void shouldDisableTestOnJRE8() {

  }

}
