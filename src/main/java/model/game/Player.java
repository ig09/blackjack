package model.game;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private final String name;
  private final List<Card> cards;
  private int currentScore;

  public Player(String name) {
    this.name = name;
    this.cards = new ArrayList<>();
    this.currentScore = 0;
  }

  public String getName() {
    return name;
  }

  public List<Card> getCards() {
    return cards;
  }

  public void addCardToHand(Card card) {
    this.cards.add(card);
    this.currentScore += card.getValue().getScore();
  }

  public int getCurrentScore() {
    return currentScore;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(name + ": ");
    for (int i = 0; i < cards.size() - 1; ++i) {
      stringBuilder.append(cards.get(i).toString());
      stringBuilder.append(", ");
    }
    stringBuilder.append(cards.get(cards.size()-1).toString());
    return stringBuilder.toString();
  }
}
