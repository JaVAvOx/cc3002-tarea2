package model.card.type;

import controller.IController;
import model.IGameLogic;

public abstract class AbstractCard implements ICard {

  protected Color color;
  protected Symbol symbol;

  @Override
  public abstract boolean isPlayableOver(ICard otherCard);

  @Override
  public boolean isFirstPlayable() {
    return true;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public Symbol getSymbol() {
    return symbol;
  }

  @Override
  public abstract void executeAction(IGameLogic game, IController ctrl);

  @Override
  public boolean isDiscardable() {
    return true;
  }
  

  public String toString() {
    return "( " + color + " , " + symbol + " )";
  }
}
