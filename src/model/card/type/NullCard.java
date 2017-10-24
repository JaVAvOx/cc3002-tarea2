package model.card.type;

import controller.IController;
import model.IGameLogic;

public class NullCard extends AbstractCard {

  public NullCard() {
    this.color = Color.NONE;
    this.symbol = Symbol.NONE;
  }
  
  @Override
  public boolean isDiscardable() {
    return false;
  }
  
  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    // No Action

  }

}
