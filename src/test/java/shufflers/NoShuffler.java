package shufflers;

import model.cards.Card;
import model.cards.Deck;
import model.cards.Suit;
import model.cards.Value;
import model.shufflers.CardShuffler;

public class NoShuffler implements CardShuffler {
  @Override
  public void shuffle(Deck deck) {
    for (Suit suit : Suit.values()) {
      for (Value value: Value.values()) {
        deck.getCards().add(new Card(suit, value));
      }
    }
  }
}
