import model.cards.Deck;
import model.game.Game;
import model.game.Player;
import model.shufflers.CardShuffler;
import model.shufflers.FileShuffler;
import model.shufflers.RandomShuffler;

import java.io.IOException;

public class Blackjack {
  public static void main(String[] args) {

    CardShuffler cardShuffler = new RandomShuffler();
    if (args.length != 0) {
      try {
        cardShuffler = new FileShuffler(args[0]);
      } catch (IOException e) {
        System.err.printf("No such file %s%n", args[0]);
        return;
      }
    }

    Deck deck = Deck.withShuffler(cardShuffler).shuffle();

    Game game = new Game(deck);
    game.start();

    Player winner = game.getWinner();

    System.out.println(winner.getName());
    System.out.println(game.getSam().toString());
    System.out.println(game.getDealer().toString());
  }
}
