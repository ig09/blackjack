package model.cards;

public enum Suit {
  CLUBS('C'),
  DIAMONDS('D'),
  HEARTS('H'),
  SPADES('S');

  private final char val;

  Suit(char val) {
    this.val = val;
  }

  public static Suit getSuiteFromString(String suitString) {
    if ("C".equals(suitString)) {
      return CLUBS;
    }
    if ("D".equals(suitString)) {
      return DIAMONDS;
    }
    if ("H".equals(suitString)) {
      return HEARTS;
    }
    if ("S".equals(suitString)) {
      return SPADES;
    }
    throw new IllegalArgumentException(String.format("No such suit as %s", suitString));
  }

  public char getVal() {
    return val;
  }
}
