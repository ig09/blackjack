package model.game;

import model.cards.Card;
import model.cards.Deck;

public class Game {
  private final Deck deck;
  private int currentCard;
  private final Player sam;
  private final Player dealer;
  private Player winner;

  public Game(Deck deck) {
    this.deck = deck;
    this.currentCard = 0;
    this.sam = new Player("sam");
    this.dealer = new Player("dealer");
  }

  public void start() {
    sam.addCardToHand(deck.getCard(currentCard++));
    dealer.addCardToHand(deck.getCard(currentCard++));
    sam.addCardToHand(deck.getCard(currentCard++));
    dealer.addCardToHand(deck.getCard(currentCard++));

    int samScore = sam.getCurrentScore();
    int dealerScore = dealer.getCurrentScore();

    if (dealerScore == 22 && samScore == 22) {
      winner = dealer;
      return;
    }

    if (dealerScore == 22) {
      winner = sam;
      return;
    }

    if (samScore == 22) {
      winner = dealer;
      return;
    }

    if (samScore == 21) {
      winner = sam;
      return;
    }

    if (dealerScore == 21) {
      winner = dealer;
    }

    while (winner == null) {
      this.drawCardsFor(sam, 17);
      samScore = sam.getCurrentScore();
      if (samScore > 21) {
        winner = dealer;
        break;
      }

      this.drawCardsFor(dealer, samScore);
      dealerScore = dealer.getCurrentScore();
      winner = dealerScore > 21 ? sam : dealer;
    }
  }

  private void drawCardsFor(Player player, int limit) {
    int score = player.getCurrentScore();
    while (score < limit && score < 21) {
      Card card = deck.getCard(currentCard++);
      player.addCardToHand(card);
      score = player.getCurrentScore();
    }
  }

  public Player getWinner() {
    return this.winner;
  }

  public Player getSam() {
    return this.sam;
  }

  public Player getDealer() {
    return this.dealer;
  }
}
