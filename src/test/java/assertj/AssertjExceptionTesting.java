package assertj;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AssertjExceptionTesting {

  @Test
  void shouldHandleException() {
    assertThatThrownBy(() -> {
      List<String> list = Arrays.asList("String one", "String two");
      String s = list.get(2);
      Assert.fail();
    }).isInstanceOf(IndexOutOfBoundsException.class);
    /**
     * .hasMessage("Index: %s, Size: %s", 2, 2)
     * .hasMessageStartingWith("Index: 2")
     * .hasMessageContaining("2")
     * .hasMessageEndingWith("Size: 2")
     * .hasMessageMatching("Index: \\d+, Size: \\d+")
     * .hasCauseInstanceOf(IOException.class)
     * .hasStackTraceContaining("java.io.IOException");
     */
  }
}
