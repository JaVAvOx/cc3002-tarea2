package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public class RandomPlayer extends AbstractPlayer {

  public RandomPlayer(String name) {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    ctrl.showMessage("Carta actual en la pila: " + game.getCurrentPlayedCard().toString());
    return this.getCardFromHand(ctrl.AskForCardFromHand(game.getCurrentPlayer()));
  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    return ctrl.askForColor();
  }

}
