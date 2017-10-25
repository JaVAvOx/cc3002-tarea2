package model.card.type;

import controller.IController;
import model.IGameLogic;
/*
 * AbstractCard implements methods for ICard interface
 * @author jgomez
 */
public abstract class AbstractCard implements ICard {

  protected Color color;
  protected Symbol symbol;

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

  /*
   * Converts card's information to String 
   * @return String the card's information
   */
  public String toString() {
    return "[" + symbol + " , " + color + "]";
  }

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    return this.getColor().equals(otherCard.getColor())
        || this.getSymbol().equals(otherCard.getSymbol());
  }
  
  /*
   * Set a new color for a card
   */
  public void setColor(Color c) {
    this.color = c;
  }
}
