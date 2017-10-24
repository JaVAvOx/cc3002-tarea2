package test;

import static org.junit.Assert.*;

import model.player.type.IPlayer;
import model.card.Deck;
import model.card.ICardPile;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.player.type.HumanPlayer;
import model.player.type.RandomPlayer;

public class Test {

  @Before
  public void setUp() {
    IPlayer randomPlayer1 = new RandomPlayer();
    IPlayer randomPlayer2 = new RandomPlayer();
    IPlayer randomPlayer3 = new RandomPlayer();
    IPlayer humanPlayer = new HumanPlayer();
    ICardPile mazo = new Deck();

  }

}
