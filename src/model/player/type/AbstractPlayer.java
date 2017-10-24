package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

public abstract class AbstractPlayer implements IPlayer {
  
  private boolean shoutedUNO;
  protected ArrayList<ICard> hand = new ArrayList<ICard>();
  private String name;
  
  public AbstractPlayer(String name) {
    this.name = name;
  }
  
  @Override
  public void addToHand(ArrayList<ICard> hand) {
    this.hand.addAll(hand);

  }

  @Override
  public boolean hasWon() {
    return this.getHandSize() == 0;
  }

  @Override
  public abstract ICard getCardToPlay(IGameLogic game, IController ctrl);

  @Override
  public abstract Color selectColor(IGameLogic game, IController ctrl);

  @Override
  public int getHandSize() {
    return this.hand.size();
  }

  @Override
  public boolean hasOneCard() {
    return getHandSize() == 1;
  }

  @Override
  public ArrayList<ICard> getHand() {
    return hand;
  }

  @Override
  public void setSaidUNO(boolean status) {
    shoutedUNO = status;

  }

  @Override
  public boolean hasSaidUNO() {
    return shoutedUNO;
  }

  @Override
  public void removeCardFromHand(ICard card) {
    hand.remove(card);

  }

  @Override
  public boolean needsToDrawCard(ICard currentCard) {
    for(ICard card : hand) {
      if(card.isPlayableOver(currentCard)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public ICard getCardFromHand(int number) {
    if (number >= this.getHandSize() || number < 0) {
      return new NullCard();
    }
    return hand.get(number);
  }
  
  public String toString() {
    return this.name;
  }

}
