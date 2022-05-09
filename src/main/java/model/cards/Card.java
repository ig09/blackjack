package model.cards;

import java.util.Objects;

public class Card {
  private final Suit suit;
  private final Value value;

  public Card(Suit suit, Value value) {
    this.suit = suit;
    this.value = value;
  }

  public Suit getSuit() {
    return suit;
  }

  public Value getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Card)) return false;
    Card card = (Card) o;
    return getSuit() == card.getSuit() && getValue() == card.getValue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSuit(), getValue());
  }

  @Override
  public String toString() {
    return String.format("%s%s", suit.getVal(), value.getName());
  }
}
