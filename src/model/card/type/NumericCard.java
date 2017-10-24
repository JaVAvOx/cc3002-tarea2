package model.card.type;

import controller.IController;
import model.IGameLogic;

public class NumericCard extends AbstractCard {
  
  public NumericCard(Color color, Symbol symbol) {
    this.color = color;
    this.symbol = symbol;
  }

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    return this.getColor().equals(otherCard.getColor()) || this.getSymbol().equals(otherCard.getSymbol());
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {

  }

}
