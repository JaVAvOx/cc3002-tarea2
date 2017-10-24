package model.card.deck;

import model.card.ICardPile;

public interface ICardDeckFactory {
  public ICardPile createDeck();
}
