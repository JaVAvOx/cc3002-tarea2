package model.card.type;

import controller.IController;
import model.IGameLogic;

/*
 * PlusTwoCard makes the next player draw two cards from deck
 * 
 * @author jgomez
 */
public class PlusTwoCard extends AbstractCard {

  /*
   * Constructor for PlusTwoCard
   * @param color color for the card
   */
  public PlusTwoCard(Color color) {
    this.color = color;
    this.symbol = Symbol.DRAW_TWO;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    game.addToDrawWell(2);
    ctrl.showMessage("Se juega un +2 !");

  }

}
