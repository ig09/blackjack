package model.cards;

import model.shufflers.CardShuffler;
import model.shufflers.RandomShuffler;

import java.util.ArrayList;
import java.util.List;

public class Deck {
  private final List<Card> cards;
  private final CardShuffler cardShuffler;

  private Deck(CardShuffler cardShuffler) {
    this.cards = new ArrayList<>();
    this.cardShuffler = (cardShuffler != null) ? cardShuffler : new RandomShuffler();
  }

  public static Deck withShuffler(CardShuffler cardShuffler) {
    return new Deck(cardShuffler);
  }

  public Deck shuffle() {
    this.cardShuffler.shuffle(this);
    return this;
  }

  public List<Card> getCards() {
    return this.cards;
  }

  public Card getCard(int i) {
    return this.cards.get(i);
  }

  @Override
  public String toString() {
    StringBuilder stringBuffer = new StringBuilder();
    for (int i = 0; i < cards.size()-1; ++i) {
      Card card = cards.get(i);
      stringBuffer.append(card);
      stringBuffer.append(", ");
    }
    stringBuffer.append(cards.get(cards.size()-1));
    return stringBuffer.toString();
  }
}
