package model.card.type;

import controller.IController;
import model.IGameLogic;

/*
 * InvertCard changes the direction of the game
 */
public class InvertCard extends AbstractCard {
  
  /*
   * Constructor for InvertCard
   * @param c color for the card
   */
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
