package assertj;

import static assertj.PersonAssert.assertThat;

import extensions.ReplaceCamelCase;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceCamelCase.class)
class CustomAssertionTest {

  @Test
  void whenPersonNameMatchesThenCorrect() {
    Person person = new Person("John Doe", 20);
    assertThat(person).hasFullName("John Doe");
  }

  @Test
  void whenPersonAgeLessThanEighteenThenNotAdult() {
    Person person = new Person("Jane Roe", 16);

    // assertion fails
    assertThat(person).isAdult();
  }

  @Test
  void whenPersonDoesNotHaveAMatchingNicknameThenIncorrect() {
    Person person = new Person("John Doe", 20);
    person.addNickname("Nick");

    // assertion will fail
    assertThat(person).hasNickName("John");
  }
}
