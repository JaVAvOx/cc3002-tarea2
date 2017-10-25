package model.card.deck;

import model.card.ICardPile;

/*
 * Interface for Deck Factories
 * 
 * @author jgomez
 */
public interface ICardDeckFactory {
  
  /**
   * Creates a new ICardDeck object.
   *
   * @return the deck to be used.
   */

  public ICardPile createDeck();
}
