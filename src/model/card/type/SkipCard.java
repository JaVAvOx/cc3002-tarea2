package model.card.type;

import controller.IController;
import model.IGameLogic;

public class SkipCard extends AbstractCard {

  public SkipCard(Color color) {
    this.color = color;
    this.symbol = Symbol.SKIP;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    game.skipPlayer();
    ctrl.showMessage("Se juega SKIP, salta al siguiente jugador!");

  }

}
