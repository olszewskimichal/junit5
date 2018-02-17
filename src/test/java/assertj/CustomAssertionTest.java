package assertj;

import static assertj.PersonAssert.assertThat;

import org.junit.jupiter.api.Test;

class CustomAssertionTest {

  @Test
  void whenPersonNameMatches_thenCorrect() {
    Person person = new Person("John Doe", 20);
    assertThat(person).hasFullName("John Doe");
  }

  @Test
  void whenPersonAgeLessThanEighteen_thenNotAdult() {
    Person person = new Person("Jane Roe", 16);

    // assertion fails
    assertThat(person).isAdult();
  }

  @Test
  void whenPersonDoesNotHaveAMatchingNickname_thenIncorrect() {
    Person person = new Person("John Doe", 20);
    person.addNickname("Nick");

    // assertion will fail
    assertThat(person).hasNickName("John");
  }
}
