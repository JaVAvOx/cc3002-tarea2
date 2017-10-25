package test;

import static org.junit.Assert.*;

import org.junit.Before;

import controller.ConsoleController;
import model.player.type.IPlayer;
import model.GameLogic;
import model.IGameLogic;
import model.card.ICardPile;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.type.HumanPlayer;
import model.player.type.RandomPlayer;
import view.ConsoleView;

public class Test {

  @Before
  public void setUp() {
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    IPlayer randomPlayer1 = new RandomPlayer("Random 1");
    IPlayer randomPlayer2 = new RandomPlayer("Random 2");
    IPlayer randomPlayer3 = new RandomPlayer("Random 3");
    IPlayer humanPlayer = new HumanPlayer("Human");
    playerBuilder.addPlayer(randomPlayer3);
    playerBuilder.addPlayer(humanPlayer);
    playerBuilder.addPlayer(randomPlayer1);
    playerBuilder.addPlayer(randomPlayer2);
    IGameLogic game = new GameLogic(playerBuilder);
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);

  }

}
