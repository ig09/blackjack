package model.shufflers;

import model.cards.Card;
import model.cards.Deck;
import model.cards.Suit;
import model.cards.Value;

import java.util.Random;

public class RandomShuffler implements CardShuffler {

  @Override
  public void shuffle(Deck deck) {
    for (Suit suit : Suit.values()) {
      for (Value value: Value.values()) {
        deck.getCards().add(new Card(suit, value));
      }
    }

    Random rand = new Random();

    for (int trial = 0; trial < 1000000; ++trial) {
      int i = rand.nextInt(52);
      int j = rand.nextInt(52);
      swapCards(deck,i,j);
    }
  }

  private void swapCards(Deck deck, int i, int j) {
    Card cardI = deck.getCard(i);
    Card cardJ = deck.getCard(j);
    deck.getCards().set(i, cardJ);
    deck.getCards().set(j, cardI);
  }
}
