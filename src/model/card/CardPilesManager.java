package model.card;

import java.util.ArrayList;

import model.card.deck.DeckStrategy;
import model.card.type.ICard;
import model.player.type.IPlayer;

public class CardPilesManager implements ICardPilesManager {
  ICardPile deck;
  ICardPile discard = new CardPile();
  
  
  public CardPilesManager(DeckStrategy strategy) {
    this.deck = strategy.createDeck();
    this.discard.pushCard(deck.popCard());
  }
  
  @Override
  public void rebuildDeck() {
    ICard a = discard.popCard();
    deck.pushCards(discard);
    deck.shuffle();
    discard.pushCard(a);

  }

  @Override
  public ICard drawCard() {
    return deck.popCard();
  }

  @Override
  public int getDrawableCardsNumber() {
    // TODO Auto-generated method stub
    return deck.getSize() + discard.getSize() - 1;
  }

  @Override
  public ArrayList<ICard> drawCards(int cardsNumber) {
    ArrayList<ICard> cardsToBeDrawn = new ArrayList<ICard>();
    for (int i = 0; i < cardsNumber; i++) {
      cardsToBeDrawn.add(deck.popCard());
    }
    return cardsToBeDrawn;
  }

  @Override
  public ICard getCurrentPlayedCard() {
    return this.discard.peekCard();
  }

  @Override
  public void discard(ICard newCard) {
    discard.pushCard(newCard);
  }

  @Override
  public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
    // TODO Auto-generated method stub
    ArrayList<ICard> cardsFromDeck = this.drawCards(number);
    player.addToHand(cardsFromDeck);
    return cardsFromDeck;
  }

}
