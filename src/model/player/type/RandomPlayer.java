package model.player.type;

import java.util.ArrayList;
import java.util.Random;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public class RandomPlayer extends AbstractPlayer {
  
  private Random randomGenerator = new Random();
  
  public RandomPlayer(String name) {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    ctrl.showMessage("Carta actual en la pila: " + game.getCurrentPlayedCard().toString());
    if (this.needsToDrawCard(game.getCurrentPlayedCard())) {
      ctrl.showMessage(game.getCurrentPlayer().toString() + " no tiene cartas para jugar. Debe robar");
      ctrl.showMessage("[AUTODRAW] " + game.getCurrentPlayer().toString() + " roba una carta.");
      int askedIndex = this.getHandSize();
      if(!game.drawOneCard(this).isPlayableOver(game.getCurrentPlayedCard())) {
        askedIndex = -1;
      }
      return this.getCardFromHand(askedIndex);
    }
    
    
    ArrayList<ICard> playableCards = new ArrayList<ICard>();
    for (ICard card :this.hand) {
      if (card.isPlayableOver(game.getCurrentPlayedCard())) {
        playableCards.add(card);
      }
    }
    int index = randomGenerator.nextInt(playableCards.size());
    return playableCards.get(index);

  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    Color[] colors = Color.getColors();
    int index = randomGenerator.nextInt(colors.length);
    return colors[index];
  }

}
