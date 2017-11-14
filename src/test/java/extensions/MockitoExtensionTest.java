package extensions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class MockitoExtensionTest {
  @BeforeEach
  void init(@Mock PersonInterface person) {
    when(person.getFirstName()).thenReturn("Dilbert");
  }

  @Test
  void simpleTestWithInjectedMock(@Mock PersonInterface person) {
    assertEquals("Dilbert", person.getFirstName());
  }
}
