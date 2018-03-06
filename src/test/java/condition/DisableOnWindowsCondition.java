package condition;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DisableOnWindowsCondition implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    String osName = System.getProperty("os.name");
    if (osName.equalsIgnoreCase("Windows 10")) {
      return ConditionEvaluationResult.disabled("Test disabled on Windows");
    } else {
      return ConditionEvaluationResult.enabled("Test enabled");
    }
  }
}