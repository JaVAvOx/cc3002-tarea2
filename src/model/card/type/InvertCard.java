package model.card.type;

import controller.IController;
import model.IGameLogic;

public class InvertCard extends AbstractCard {

  public InvertCard(Color c) {
    this.color = c;
    this.symbol = Symbol.INVERT;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    game.invertDirection();
    ctrl.showMessage("Se juega un Inverse, se cambia la direccion!");

  }

}
