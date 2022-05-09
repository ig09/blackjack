package model.shufflers;

import model.cards.Card;
import model.cards.Deck;
import model.cards.Suit;
import model.cards.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileShuffler implements CardShuffler {
  private final String cardsLine;

  public FileShuffler(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    cardsLine = reader.readLine();
    reader.close();
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
