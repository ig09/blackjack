package model.cards;

public enum Value {
  TWO("2",2),
  THREE("3",3),
  FOUR("4",4),
  FIVE("5",5),
  SIX("6",6),
  SEVEN("7",7),
  EIGHT("8",8),
  NINE("9",9),
  TEN("10",10),
  JACK("J",10),
  QUEEN("Q",10),
  KING("K",10),
  ACE("A",11);

  private final String name;
  private final int score;

  Value(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public static Value getValueFromString(String valueString) {
    switch (valueString) {
      case "2":
        return TWO;
      case "3":
        return THREE;
      case "4":
        return FOUR;
      case "5":
        return FIVE;
      case "6":
        return SIX;
      case "7":
        return SEVEN;
      case "8":
        return EIGHT;
      case "9":
        return NINE;
      case "10":
        return TEN;
      case "J":
        return JACK;
      case "Q":
        return QUEEN;
      case "K":
        return KING;
      case "A":
        return ACE;
      default:
        throw new IllegalArgumentException(String.format("No such value as %s", valueString));
    }
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }
}
