package model.card.type;

import controller.IController;
import model.IGameLogic;

/*
 * NumericCard is a card with a number value
 * 
 * @author jgomez
 */
public class NumericCard extends AbstractCard {

  /*
   * Constructor for NumericCard
   * @param color the color for the card
   * @param symbol the symbol for the card
   */
  public NumericCard(Color color, Symbol symbol) {
    this.color = color;
    this.symbol = symbol;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {

  }

}
