package model.card.type;

import controller.IController;
import model.IGameLogic;
/*
 * SkipCard skips the next player's turn
 * 
 * @author jgomez
 */
public class SkipCard extends AbstractCard {
  
  /*
   * Constructor for SkipCard
   * @param color color for the card
   */
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
