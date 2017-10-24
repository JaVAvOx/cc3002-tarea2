import controller.ConsoleController;
import model.GameLogic;
import model.IGameLogic;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import model.player.type.RandomPlayer;
import view.ConsoleView;

/**
 * Main class of UNO Game
 * 
 * It instantiates model, view and controller and makes the turn loop while the game hasn't ended.
 * 
 * @author eriveros
 *
 */
public class Main {

  public static void main(String[] args) {
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    // TODO: Create one human player and 3 random players
    IPlayer humanPlayer = new HumanPlayer("Human");
    IPlayer randomPlayer1 = new RandomPlayer("Random 1");
    IPlayer randomPlayer2 = new RandomPlayer("Random 2");
    IPlayer randomPlayer3 = new RandomPlayer("Random 3");
    // TODO: Assign the players to playerBuilder.
    playerBuilder.addPlayer(randomPlayer3);
    playerBuilder.addPlayer(humanPlayer);
    playerBuilder.addPlayer(randomPlayer1);
    playerBuilder.addPlayer(randomPlayer2);
    IGameLogic game = new GameLogic(playerBuilder);
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);
    while (!game.hasEnded()) {
      ctrl.playTurn();
    }
    game.announceWinner(ctrl);
  }
}
