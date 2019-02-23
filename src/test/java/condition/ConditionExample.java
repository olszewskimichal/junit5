package condition;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ConditionExample {

  @Test
  @DisabledOnWindows
  void should_Disable_Test_On_Windows() {

  }

  @Test
  @DisabledOnMac
  void should_Disable_Test_On_Mac() {

  }

  @Test
  @DisabledIf("new Date().getDay() === 1")
  void should_Disable_Test_If_Monday() {

  }

  @Test
  @EnabledOnJRE8
  void should_Enable_Test_On_JRE8() {

  }

  @Test
  @DisabledOnJRE8
  void should_Disable_Test_On_JRE8() {

  }

}
