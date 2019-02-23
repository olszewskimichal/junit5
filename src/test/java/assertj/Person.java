package assertj;

import java.util.ArrayList;
import java.util.List;

class Person {

  private String fullName;
  private int age;
  private List<String> nicknames;

  Person(String fullName, int age) {
    this.fullName = fullName;
    this.age = age;
    this.nicknames = new ArrayList<>();
  }

  void addNickname(String nickname) {
    nicknames.add(nickname);
  }

  public String getFullName() {
    return fullName;
  }

  public int getAge() {
    return age;
  }

  public List<String> getNicknames() {
    return nicknames;
  }
}