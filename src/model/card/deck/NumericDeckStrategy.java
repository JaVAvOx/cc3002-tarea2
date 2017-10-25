package model.card.deck;

import model.card.ICardPile;
/*
 * Strategy for play using a only-numeric deck
 * @author jgomez
 */
public class NumericDeckStrategy implements IDeckStrategy {

  private NumericDeckFactory numericFactory = new NumericDeckFactory();

  @Override
  public ICardPile createDeck() {
    return numericFactory.createDeck();
  }
}
