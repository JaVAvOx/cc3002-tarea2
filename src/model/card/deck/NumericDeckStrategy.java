package model.card.deck;

import model.card.ICardPile;

public class NumericDeckStrategy implements IDeckStrategy {

  private NumericDeckFactory numericFactory = new NumericDeckFactory();
  
  @Override
  public ICardPile createDeck() {
    return numericFactory.createDeck();
  }
}
