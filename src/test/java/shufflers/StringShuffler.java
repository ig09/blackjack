package shufflers;

import model.cards.Card;
import model.cards.Deck;
import model.cards.Suit;
import model.cards.Value;
import model.shufflers.CardShuffler;

import java.util.StringTokenizer;

public class StringShuffler implements CardShuffler {
  private final String cardsLine;

  public StringShuffler(String cardsLine) {
    this.cardsLine = cardsLine;
  }

  @Override
  public void shuffle(Deck deck) {
    StringTokenizer stringTokenizer = new StringTokenizer(cardsLine, ",");
    while (stringTokenizer.hasMoreTokens()) {
      String cardString = stringTokenizer.nextToken();
      cardString = cardString.stripLeading().stripTrailing();
      String suitString = cardString.substring(0,1);
      String valueString = cardString.substring(1);
      Suit suit = Suit.getSuiteFromString(suitString);
      Value value = Value.getValueFromString(valueString);
      Card card = new Card(suit, value);
      deck.getCards().add(card);
    }

  }
}
