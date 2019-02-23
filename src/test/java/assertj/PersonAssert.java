package assertj;

import org.assertj.core.api.AbstractAssert;

class PersonAssert extends AbstractAssert<PersonAssert, Person> {

  private PersonAssert(Person actual) {
    super(actual, PersonAssert.class);
  }

  static PersonAssert assertThat(Person actual) {
    return new PersonAssert(actual);
  }

  PersonAssert hasFullName(String fullName) {
    isNotNull();
    if (!actual.getFullName().equals(fullName)) {
      failWithMessage("Expected person to have full name %s but was %s", fullName, actual.getFullName());
    }
    return this;
  }

  PersonAssert isAdult() {
    isNotNull();
    if (actual.getAge() < 18) {
      failWithMessage("Expected person to be adult");
    }
    return this;
  }

  PersonAssert hasNickName(String nickName) {
    isNotNull();
    if (!actual.getNicknames().contains(nickName)) {
      failWithMessage("Expected person to have nickname %s",
          nickName);
    }
    return this;
  }
}