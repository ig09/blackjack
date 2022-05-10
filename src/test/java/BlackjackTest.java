
import model.cards.Card;
import model.cards.Deck;
import model.cards.Suit;
import model.cards.Value;
import model.game.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shufflers.NoShuffler;
import shufflers.StringShuffler;
import java.util.StringTokenizer;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackjackTest {

  private static String[] testCases = new String[]{
      "SA, DA, HA, CA", // -> both with AA - dealer wins
      "SA, H2, DA, C2", // -> only sam with AA - dealer wins
      "H2, SA, C2, DA", // -> only dealer with AA - sam wins
      "H10, SA, CA, D10", // -> both with blackjack - sam wins,
      "D2, S3, H7, DA, C3, D2, S5, D3" // -> dealer
  };

  private static String[] winner = new String[]{
      "dealer",
      "dealer",
      "sam",
      "sam",
      "dealer"
  };

  /**
   * This generates the rest of the cards in each test in order
   */
  @BeforeAll
  public static void fillInRestOfDeck() {
    for (int i = 0; i < testCases.length; ++i) {
      testCases[i] += ", " + getRestOfCardsInOrder(testCases[i]);
    }
  }

  private static String getRestOfCardsInOrder(String cardsLine) {
    Deck deck = Deck.withShuffler(new NoShuffler()).shuffle();
    StringTokenizer stringTokenizer = new StringTokenizer(cardsLine, ",");
    while (stringTokenizer.hasMoreTokens()) {
      String cardString = stringTokenizer.nextToken();
      cardString = cardString.stripLeading().stripTrailing();
      String suitString = cardString.substring(0,1);
      String valueString = cardString.substring(1);
      Suit suit = Suit.getSuiteFromString(suitString);
      Value value = Value.getValueFromString(valueString);
      Card cardToDelete = new Card(suit, value);
      deck.getCards().removeIf(card -> card.equals(cardToDelete));
    }
    return deck.toString();
  }

  @Test
  public void testAllTestCases() {
    for (int i = 0; i < testCases.length; ++i) {
      Deck deck = Deck.withShuffler(new StringShuffler(testCases[i])).shuffle();
      Game game = new Game(deck);
      game.start();
      assertEquals(winner[i], game.getWinner().getName(), String.format("Failed test case number %s", i+1));
    }
  }
}
