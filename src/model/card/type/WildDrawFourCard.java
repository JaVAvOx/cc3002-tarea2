package model.card.type;

import controller.IController;
import model.IGameLogic;

/*
 * WildDrawFourCard lets the player change the color of the card and makes 
 * the next player draw four cards from the deck
 * 
 * @author jgomez
 */
public class WildDrawFourCard extends AbstractCard {

  public WildDrawFourCard() {
    this.color = Color.NONE;
    this.symbol = Symbol.WILD_DRAW_FOUR;

  }

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    return true;
  }

  @Override
  public boolean isFirstPlayable() {
    return false;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    this.setColor(game.getCurrentPlayer().selectColor(game, ctrl));
    game.addToDrawWell(4);
    ctrl.showMessage("Se juega Wild +4");

  }

}
