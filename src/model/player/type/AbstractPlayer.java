package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public abstract class AbstractPlayer implements IPlayer {
  
  private boolean shoutedUNO;
  private ArrayList<ICard> hand = new ArrayList<ICard>();
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
    boolean need = true;
    int index = 0;
    while (index < this.getHandSize() && need) {
      need = !hand.get(index).isPlayableOver(currentCard);
      index++;
    }
    return need;
  }

  @Override
  public ICard getCardFromHand(int number) {
    return hand.get(number);
  }
  
  public String toString() {
    return this.name;
  }

}
